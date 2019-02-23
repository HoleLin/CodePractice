package com.holelin;

/**
 * ClassName: Max_Difference
 * 利用桶排序思想,求排完序后数值中相邻两数的最大差值
 *
 * @author HoleLin
 * @version 1.0
 * @date 2019/2/23
 */

public class Max_Difference {
	public static int maxGroup(int[] arr) {
		if (arr == null || arr.length < 2) {
			return 0;
		}
		int len = arr.length;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		// 求arr数组中最大值和最小值 -- 来确立桶划分区间
		for (int i = 0; i < len; i++) {
			min = Math.min(min, arr[i]);
			max = Math.max(max, arr[i]);
		}
		if (min == max) {
			return 0;
		}
		// 保存每个桶中是否为空桶
		boolean[] hasNum = new boolean[len + 1];
		// 保存每个桶中的最小值
		int[] mins = new int[len + 1];
		// 保存每个桶中的最大值
		int[] maxs = new int[len + 1];
		// 记录桶的编号
		int bid = 0;
		for (int i = 0; i < len; i++) {
			bid = bucket(arr[i], len, min, max);
			// hasNum[bid] -- 查看编号为bid的桶中是否为空桶
			// 为空,桶bid的最小、最大值都为arr[i]
			// 不为空,用桶bid中最小值和当前数进行比较,更新桶bid的最小值
			mins[bid] = hasNum[bid] ? Math.min(mins[bid], arr[i]) : arr[i];
			// 不为空,用桶bid中最大值和当前数进行比较,更新桶bid的最大值
			maxs[bid] = hasNum[bid] ? Math.max(maxs[bid], arr[i]) : arr[i];
		}
		// 保存相邻两数的最大差值
		int res = 0;
		int lastMax = maxs[0];
		int i = 1;
		while (i <= len) {
			if (hasNum[i]) {
				// 若桶i不空 差值为 当前桶的最小值 - 前一个桶的最大值
				res = Math.max(res, mins[i] - lastMax);
				// 更新前一个桶最大值 来循环得到最大的差值
				lastMax = maxs[i];
			}
			i++;
		}
		return res;
	}

	/**
	 * 确定num应该在哪个桶中
	 *
	 * @param num 待确定的数
	 * @param len 数组的长度
	 * @param min 数组元素中最小值
	 * @param max 数组元素中最大值
	 * @return 待确定的数num在的桶的编号
	 */
	private static int bucket(long num, long len, long min, long max) {
		return (int) ((num - min) * len / (max - min));
	}


	public static void main(String[] args) {

	}
}
