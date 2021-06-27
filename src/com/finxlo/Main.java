package com.finxlo;

import com.finxlo.mountain.MountainBike;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        String data = "4 8 7 3 2 5 9 3 6 3 2 5 4 4 1 6";
        int n = 4;
        var mountainBike = new MountainBike(n, data);
        List<Integer> result = mountainBike.run();
        System.out.println(result);
    }
}
