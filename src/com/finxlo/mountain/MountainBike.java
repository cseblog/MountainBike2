package com.finxlo.mountain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static com.finxlo.mountain.Node.*;

public class MountainBike {
    private Graph g;
    private int[] intArr;

    public MountainBike(String file) {
        // FIXME parse file and init map
        // TODO: call MountainBike(int n, String matri xStr)
    }

    /**
     * n is matrix size
     * matrixStr is matrix value in string with space as delimiter
     * 4 8 7 3 2 5 9 3 6 3 2 5 4 4 1 6
     * @param n
     * @param matrixStr
     */
    public MountainBike(int n, String matrixStr) {
        String[] strArr = matrixStr.split(" ");
        intArr = Stream.of(strArr).mapToInt(Integer::parseInt).toArray();
        g = new Graph(intArr.length);
        buildGraph(g, n, intArr);
    }

    private List<Integer> convert(List<Integer> indexes) {
        List<Integer> result = new ArrayList<>();
        indexes.forEach(i -> {
            result.add(intArr[i]);
        });
        return result;
    }

    private void buildGraph(Graph g, int n, int[] arr) {
        //go up [i, j - 1], go right [x + 1, y], go down [x, y + 1], go left [x - 1, y]
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int vIndex = n * i + j;
                int v = arr[vIndex];
                Node up = getUp(arr, n, i, j);
                Node down = getDown(arr, n, i, j);
                Node right = getRight(arr, n, i, j);
                Node left = getLeft(arr, n, i, j);
                if (v > up.value && up.index != -1) {
                    g.addEdge(vIndex, up.index);
                }

                if (v > down.value && down.index != -1) {
                    g.addEdge(vIndex, down.index);
                }

                if (v > right.value && right.index != -1) {
                    g.addEdge(vIndex, right.index);
                }

                if (v > left.value && left.index != -1) {
                    g.addEdge(vIndex, left.index);
                }
            }
        }
    }

    public List<Integer> run() {
        List<Integer> indexList = run(g, intArr);
        return convert(indexList);
    }

    private List<Integer> run(Graph g, int[] arr) {
        List<Integer> finalLongestPath = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            List<Integer> historyList = new ArrayList<>();
            historyList = g.longestPathByDFS(i, historyList);

            if (finalLongestPath != null &&
                    historyList.size() > 0 &&
                    historyList.size() > finalLongestPath.size()) {
                finalLongestPath = historyList;
            }

            if (historyList.size() == finalLongestPath.size()) {
                finalLongestPath = g.getSteepestList(historyList, finalLongestPath);
            }
        }
        return finalLongestPath;
    }
}
