package com.holelin.others;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * ClassName: The_Dutch_Flag
 * 荷兰国旗问题
 * --
 * 现有红白蓝三个不同颜色的小球，乱序排列在一起，请重新排列这些小球，使得红白蓝三色的同颜色的球在一起。
 * 这个问题之所以叫荷兰国旗问题，是因为我们可以将红白蓝三色小球想象成条状物，有序排列后正好组成荷兰国旗。
 *
 * @author HoleLin
 * @version 1.0
 * @date 2019/2/22
 */

public class The_Dutch_Flag {
	public static void partition(int[] arr, int l, int r) {
		// 小于部分边界
		int less = l - 1;
		// 大于部分边界
		int more = r;
		while (l < more) {
			if (arr[l] < arr[r]) {
				// 小于区域扩张
				swap(arr, ++less, l++);
			} else if (arr[l] > arr[r]) {
				// 大于区域扩张
				swap(arr, --more, l);
			} else {
				l++;
			}
		}
		swap(arr,more,r);
		System.out.println(less+1+" "+more);
	}

	/**
	 * 交换数据 -- 数组
	 *
	 * @param arr 数组
	 * @param i   待交换的值
	 * @param j   待交换的值
	 */
	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		// 使用异或运算实现交换操作
//        arr[i] = arr[i] ^ arr[j];
//        arr[j] = arr[i] ^ arr[j];
//        arr[i] = arr[i] ^ arr[j];
	}

	public static void main(String[] args) {
		int[] nums={1,2,3,3,2,1,3,2};
		partition(nums,0,nums.length-1);
		System.out.println(Arrays.toString(nums));
	}
}
