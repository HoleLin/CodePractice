package com.holelin.leetcode.backtracing.split;

import java.util.LinkedList;
import java.util.List;

public class 复原IP地址_93 {

    public static List<String> restoreIpAddresses(String s) {
        List<String> result = new LinkedList<>();
        if (s.length() > 12) {
            return result;
        }
        backtracing(result, s, 0, 0);
        return result;
    }

    /**
     * @param result     结果集
     * @param s          字符串
     * @param startIndex 字符分割其实位置
     * @param pointSum   ip地址逗号数量
     */
    private static void backtracing(List<String> result, String s, int startIndex, int pointSum) {

        // 确定终止条件
        // ip地址格式为: xxx.xxx.xxx.xxx 其中有且只有3个逗号
        if (pointSum == 3) {
            // 当逗号数为3时,对应校验第三个逗号右侧被分割的字符串是否合法
            if (isValid(s, startIndex, s.length() - 1)) {
                // 填充结果集
                result.add(s);
                return;
            }
        }
        // 遍历
        for (int i = startIndex; i < s.length(); i++) {
            // check [startIndex,i]
            if (!isValid(s, startIndex, i)) {
                break;
            }
            //在str的后⾯插⼊⼀个逗点
            s = s.substring(0, i + 1) + "." + s.substring(i + 1);
            pointSum++;
            backtracing(result, s, i + 2, pointSum);
            pointSum--;
            // 回溯删掉逗点
            s = s.substring(0, i + 1) + s.substring(i + 2);
        }
    }

    private static boolean isValid(String s, int start, int end) {
        if (start > end) {
            return false;
        }
        // 0开头的数字不合法
        if (s.charAt(start) == '0' && start != end) {
            return false;
        }
        int num = 0;
        for (int i = start; i <= end; i++) {
            // 遇到⾮数字字符不合法
            if (s.charAt(i) > '9' || s.charAt(i) < '0') {
                return false;
            }
            num = num * 10 + (s.charAt(i) - '0');
            // 如果⼤于255了不合法
            if (num > 255) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(restoreIpAddresses("0000"));
    }

}
