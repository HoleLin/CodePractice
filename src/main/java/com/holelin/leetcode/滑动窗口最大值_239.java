package com.holelin.leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class 滑动窗口最大值_239 {
    class MonotoneQueue {

        private Deque<Integer> deque = new LinkedList<>();

        void pop(Integer value) {
            if (!deque.isEmpty() && value.equals(deque.peek())) {
                deque.poll();
            }
        }

        void push(Integer value) {
            // 如果放入的元素大于单调队列中的最后一个元素,则将最后一个元素移除,将当前元素放入
            if (!deque.isEmpty() && deque.getLast() < value) {
                deque.removeLast();
            }
            deque.offer(value);
        }

        Integer peek() {
            return deque.peek();
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 1) {
            return nums;
        }
        int len = nums.length - k + 1;
        //存放结果元素的数组
        int[] res = new int[len];
        int num = 0;
        //自定义队列
        MonotoneQueue myQueue = new MonotoneQueue();
        //先将前k的元素放入队列
        for (int i = 0; i < k; i++) {
            myQueue.push(nums[i]);
        }
        res[num++] = myQueue.peek();
        for (int i = k; i < nums.length; i++) {
            //滑动窗口移除最前面的元素，移除是判断该元素是否放入队列
            myQueue.pop(nums[i - k]);
            //滑动窗口加入最后面的元素
            myQueue.push(nums[i]);
            //记录对应的最大值
            res[num++] = myQueue.peek();
        }
        return res;
    }
}
