package com.holelin.others;

import java.util.ArrayList;

/**
 * ClassName: Small_Sum
 * 小和问题
 *  问题描述：
 * 一个数列，其中一个数p，其左边所有比p小的数的和，是数p的小和。
 * 求这个数列所有数的小和之和。
 * exp:int[] num={1, 4,3, 5, 0, 6}
 * out: 23 {[1, 1, 0, 5, 2, 6, 8]}
 * @author HoleLin
 * @version 1.0
 * @date 2019/2/21
 */

public class Small_Sum {
	/**
	 * 利用归并排序求小和问题
	 * @param arr
	 */
	public static void calSmallAnd(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		ArrayList<Integer> arrayList = new ArrayList<>();
		division(arr, 0, arr.length - 1, arrayList);
		System.out.println(arrayList);
		int sum = 0;
		for (int i : arrayList) {
			sum += i;
		}
		System.out.println(sum);
	}

	private static void division(int[] arr, int l, int r, ArrayList<Integer> arrayList) {
		if (l == r) {
			return;
		}
		int mid = l + (r - l) / 2;
		division(arr, l, mid, arrayList);
		division(arr, mid + 1, r, arrayList);
		merge(arr, l, mid, r, arrayList);
	}

	private static void merge(int[] arr, int l, int m, int r, ArrayList<Integer> arrayList) {
		int[] help = new int[r - l + 1];
		int i = 0;
		int left = l;
		int mid = m + 1;
		int sum;
		while (left <= m && mid <= r) {
			if (arr[left] < arr[mid]) {
				sum = arr[left] * (r - mid + 1);
				arrayList.add(sum);
				help[i++] = arr[left++];
			} else {
				help[i++] = arr[mid++];
			}
		}
		while (left <= m) {
			help[i++] = arr[left++];
		}
		while (mid <= r) {
			help[i++] = arr[mid++];
		}
		// 将排完序的数组help中的值赋给原数组arr
		for (int j = 0; j < help.length; j++) {
			arr[l + j] = help[j];
		}
	}

	/**
	 * 暴力求解
	 * @param  arr 原数组
	 */
	public static void calSmallAnd2(int[] arr) {
		int sum = 0;
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j]) {
					sum += arr[j];
				}
			}
		}
		System.out.println(sum);
	}

	public static void main(String[] args) {
		calSmallAnd(new int[]{1, 4,3, 5, 0, 6});
		calSmallAnd2(new int[]{1, 4,3, 5, 0, 6});
	}
}
