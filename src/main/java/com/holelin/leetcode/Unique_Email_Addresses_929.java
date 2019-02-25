package com.holelin.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * ClassName: Unique_Email_Addresses_929
 * Every email consists of a local name and a domain name, separated by the @ sign.
 * <p>
 * For example, in alice@leetcode.com, alice is the local name, and leetcode.com is the domain name.
 * <p>
 * Besides lowercase letters, these emails may contain '.'s or '+'s.
 * <p>
 * If you add periods ('.') between some characters in the local name part of an email address, mail sent there will be forwarded to the same address without dots in the local name.  For example, "alice.z@leetcode.com" and "alicez@leetcode.com" forward to the same email address.  (Note that this rule does not apply for domain names.)
 * <p>
 * If you add a plus ('+') in the local name, everything after the first plus sign will be ignored. This allows certain emails to be filtered, for example m.y+name@email.com will be forwarded to my@email.com.  (Again, this rule does not apply for domain names.)
 * <p>
 * It is possible to use both of these rules at the same time.
 * <p>
 * Given a list of emails, we send one email to each address in the list.  How many different addresses actually receive mails?
 * <p>
 * Example 1:
 * <p>
 * Input: ["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"]
 * Output: 2
 * Explanation: "testemail@leetcode.com" and "testemail@lee.tcode.com" actually receive mails
 *
 * @author HoleLin
 * @version 1.0
 * @date 2019/1/20
 */

public class Unique_Email_Addresses_929 {

    public static int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            String temp = options(email);
            set.add(temp);
        }
        return set.size();
    }

    private static String options2(String email) {
        int index = email.indexOf("@");
        String front = email.substring(0, index);
        String end = email.substring(index);
        String temp;
        // 判断前部分是否包含+号
        if (front.contains("+")) {
            temp = front.split("\\+")[0];
        } else {
            temp = front;
        }
        temp = temp.replaceAll("\\.", "");
        return temp +
                end;
    }

    private static String options(String email) {
        String[] temp = email.split("@");
        String temp2;
        // 若@前部分包含+号,则进行
        if (temp[0].contains("+")) {
            temp2 = temp[0].split("\\+")[0];
        } else {
            temp2 = temp[0];
        }

        temp2 = temp2.replaceAll("\\.", "");
        return temp2 + "@" +
                temp[1];
    }

    public static void main(String[] args) {
        String[] strings = new String[]{"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com", "test.e.mail+bob.cathy@leetcode.com"};
        System.out.println(numUniqueEmails(strings));
    }
}
