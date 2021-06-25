package com.finxlo.mountain;

public class Node {
    int index;
    int value;

    public Node(int i, int v) {
        index = i;
        value = v;
    }

    public static Node getUp(int[] arr, int n, int i, int j) {
        if (i - 1 < 0) {
            return new Node(-1, -1); //the lowest level of mountain is 0
        } else {
            int x = i - 1;
            int index = n * x + j;
            return new Node(index, arr[index]);
        }
    }

    public static Node getDown(int[] arr, int n, int i, int j) {
        if (i + 1 >= n) {
            return new Node(-1, -1);
        } else {
            int x = i + 1;
            int index = n * x + j;
            return new Node(index, arr[index]);
        }
    }

    public static Node getLeft(int[] arr, int n, int i, int j) {
        if (j - 1 < 0) {
            return new Node(-1, -1);
        } else {
            int y = j - 1;
            int index = n * i + y;
            return new Node(index, arr[index]);
        }
    }

    public static Node getRight(int[] arr, int n, int i, int j) {
        if (j + 1 >= n) {
            return new Node(-1, -1);
        } else {
            int y = j + 1;
            int index = n * i + y;
            return new Node(index, arr[index]);
        }
    }
}
