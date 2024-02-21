package com.holelin.leetcode;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class 前K个高频元素_347 {
    public int[] topKFrequent(int[] nums, int k) {
        final HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        final PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(item -> item[1]));
        //小顶堆只需要维持k个元素有序
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            //小顶堆元素个数小于k个时直接加
            if (pq.size() < k) {
                pq.add(new int[]{entry.getKey(), entry.getValue()});
            } else {
                //当前元素出现次数大于小顶堆的根结点(这k个元素中出现次数最少的那个)
                if (entry.getValue() > pq.peek()[1]) {
                    //弹出队头(小顶堆的根结点),即把堆里出现次数最少的那个删除,留下的就是出现次数多的了
                    pq.poll();
                    pq.add(new int[]{entry.getKey(), entry.getValue()});
                }
            }
        }
        int[] ans = new int[k];
        //依次弹出小顶堆,先弹出的是堆的根,出现次数少,后面弹出的出现次数多
        for (int i = k - 1; i >= 0; i--) {
            ans[i] = pq.poll()[0];
        }
        return ans;
    }
}
