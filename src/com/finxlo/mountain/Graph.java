package com.finxlo.mountain;

import java.util.*;

class Graph {
    private int V;
    private LinkedList<Integer> adj[];

    @SuppressWarnings("unchecked")
    Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

//    void DFSUtil(int v, boolean visited[], List<Integer> history)
//    {
//        visited[v] = true;
//        history.add(v);
//        Iterator<Integer> i = adj[v].listIterator();
//        while (i.hasNext())
//        {
//            int n = i.next();
//            if (!visited[n])
//                DFSUtil(n, visited, history);
//        }
//    }

    public List<Integer> getSteepestList(List<Integer> newList, List<Integer> oldList) {
        if (oldList == null || oldList.size() == 0) {
            return newList;
        }
        if (newList.size() > 0) {
            int delta1 = newList.get(0) - newList.get(newList.size() - 1);
            int delta2 = oldList.get(0) - oldList.get(oldList.size() - 1);
            if (delta1 > delta2) {
                return newList;
            } else {
                return oldList;
            }
        } else {
            return oldList;
        }
    }

    public List<Integer> longestPathByDFS(int v, List<Integer> history) {
        history.add(v);
        int max = 0;
        List<Integer> topList = new ArrayList<>();
        for (int i = 0; i < adj[v].size(); i++) {
            List<Integer> tmpList = new ArrayList<>();
            tmpList = longestPathByDFS(adj[v].get(i), tmpList);
            if (tmpList.size() > max) {
                topList = tmpList;
                max = tmpList.size();
            }

        }
        history.addAll(topList);
        return history;
    }

}
