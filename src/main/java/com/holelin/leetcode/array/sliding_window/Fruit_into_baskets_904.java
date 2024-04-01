package com.holelin.leetcode.array.sliding_window;

import java.util.HashMap;

public class Fruit_into_baskets_904 {
    public static int totalFruit(int[] fruits) {
        int start = 0;
        int end;
        int result = Integer.MIN_VALUE;
        // 用hashmap初始化baskets,用hashmap的key来存储水果的类型,value来表示水果的数量
        HashMap<Integer, Integer> baskets = new HashMap<>();
        for (end = 0; end < fruits.length; end++) {
            final int fruit = fruits[end];
            // 判断篮子里面是否存在当前水果类型,存在数量就+1
            if (baskets.containsKey(fruit)) {
                baskets.put(fruit, baskets.get(fruit) + 1);
            } else {
                baskets.put(fruit, 1);
            }
            // 篮子只能放两种水果,超过两种之后,则需要清空第一个篮子(滑动窗口的起始位置的水果)
            while (baskets.size() > 2) {
                // 取出起始位的水果类型的key
                final int curFruitKey = fruits[start];
                // 将当前水果类型的数量减1(相当于窗口向右活动一格)
                final int curFruitNum = baskets.get(curFruitKey) - 1;
                baskets.put(curFruitKey, curFruitNum);
                // 等于0时将这个类型移除篮子,即空出一个篮子
                if (curFruitNum == 0) {
                    baskets.remove(curFruitKey);
                }
                start++;
            }
            result = Math.max(result, end - start + 1);
        }
        return result == Integer.MIN_VALUE ? 0 : result;
    }

    public static void main(String[] args) {
//        System.out.println(totalFruit(new int[]{1, 2, 1}));
//        System.out.println(totalFruit(new int[]{0, 1, 2, 2}));
//        System.out.println(totalFruit(new int[]{0, 1, 2, 2}));
        System.out.println(totalFruit(new int[]{0, 0, 2, 2, 3, 3, 3}));
    }
}
