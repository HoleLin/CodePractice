package com.holelin.leetcode;

public class 反转字符串II_541 {
    public String reverseStr2(String s, int k) {
        char[] ch = s.toCharArray();
        // 1. 每隔 2k 个字符的前 k 个字符进行反转
        for (int i = 0; i < ch.length; i += 2 * k) {
            // 2. 剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符
            if (i + k <= ch.length) {
                reverse(ch, i, i + k - 1);
                continue;
            }
            // 3. 剩余字符少于 k 个，则将剩余字符全部反转
            reverse(ch, i, ch.length - 1);
        }
        return new String(ch);

    }

    // 定义翻转函数
    public void reverse(char[] ch, int i, int j) {
        for (; i < j; i++, j--) {
            char temp = ch[i];
            ch[i] = ch[j];
            ch[j] = temp;
        }

    }

    public static String reverseStr(String s, int k) {
        final char[] chars = s.toCharArray();
        // 如果剩余字符少于 k 个，则将剩余字符全部反转。
        // 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样
        int p = 0;
        int q = 0;
        while (q < chars.length) {
            // 区间达到2k
            final int interval = q - p + 1;
            if (interval == 2 * k) {
                // 进行前k个字符翻转
                int x = p;
                int y = q - k;
                while (x < y) {
                    char temp = chars[x];
                    chars[x] = chars[y];
                    chars[y] = temp;
                    x++;
                    y--;
                }
                p = q + 1;
            }
            if (q == chars.length - 1 && interval < 2 * k && interval >= k) {
                int x = p;
                int y = p + k - 1;
                while (x < y) {
                    char temp = chars[x];
                    chars[x] = chars[y];
                    chars[y] = temp;
                    x++;
                    y--;
                }
            }
            if (q == chars.length - 1 && interval < k) {
                int x = p;
                int y = q;
                while (x < y) {
                    char temp = chars[x];
                    chars[x] = chars[y];
                    chars[y] = temp;
                    x++;
                    y--;
                }
            }
            q++;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
//        System.out.println(reverseStr("abcdefg", 2));
        System.out.println(reverseStr("abcdefg", 3));
//        System.out.println(reverseStr("abcd", 3));
//        System.out.println(reverseStr("abcd", 2));
    }
}
