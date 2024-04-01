package com.holelin.leetcode.array.sliding_window;

public class Grumpy_bookstore_owner_1052 {

    public static int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int sum = 0;
        int[] diff = new int[customers.length];
        for (int i = 0; i < customers.length; i++) {
            final int customer = customers[i];
            if (grumpy[i] == 0) {
                sum += customer;
            } else {
                diff[i] = customer;
            }
        }
        int left = 0;
        int diffSum = 0;
        int max = Integer.MIN_VALUE;
        for (int right = 0; right < diff.length; right++) {
            diffSum += diff[right];
            while (right - left + 1 >= minutes) {
                max = Math.max(max, diffSum);
                diffSum -= diff[left++];
            }
        }
        return sum + max;
    }

    public static void main(String[] args) {
//        int[] customers = {1, 0, 1, 2, 1, 1, 7, 5};
//        int[] grumpy = {0, 1, 0, 1, 0, 1, 0, 1};
        int[] customers = {1};
        int[] grumpy = {0};
        System.out.println(maxSatisfied(customers, grumpy, 1));
    }
}
