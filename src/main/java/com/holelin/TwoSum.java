package com.holelin;

import java.util.Arrays;
import java.util.HashMap;

/**
 * ClassName: TwoSum
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * Example:
 * <p>
 * Given nums = [2, 7, 11, 15], target = 9,
 * <p>
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 *
 * @author HoleLin
 * @version 1.0
 * @date 2019/1/20
 */
public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        // Solution1. 暴力求解
        long startTime = System.nanoTime();
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[i] + nums[j] == target) {
//                    return new int[]{i, j};
//                }
//            }
//        }
        // Solution2. 采用target-x=a 寻找数组中为与a相等的位置
        HashMap<Integer, Integer> map = new HashMap<>(10);
        for (int i = 0; i < nums.length; i++) {
            // 计算目标数-当前判断的值
            int temp = target - nums[i];
            // 若Map中key包含temp则表明找到答案
            // 返回当当前判断的值位置,和等于temp的值位置
            if (map.containsKey(temp)) {
                return new int[]{map.get(temp), i};
            }
            // 将当前数与位置放入Map中
            map.put(nums[i], i);

        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum(nums, 9)));
    }
}
