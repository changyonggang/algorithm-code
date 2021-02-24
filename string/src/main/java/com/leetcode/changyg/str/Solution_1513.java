package com.leetcode.changyg.str;

import java.util.ArrayList;
import java.util.List;

class Solution_1513 {
    private static final char one = '1';
    private static final int base = 10 * 10 * 10 * 10 * 10 * 10 * 10 * 10 * 10 + 7;

    public int numSub(String s) {
        List<Integer> subLengths = getSubStringOneLengths(s);

        long sum = 0L;
        for (Integer subLen : subLengths) {
            System.out.println(subLen);
            sum = sum + funcSum(subLen);
        }

        return (int)(sum % base);
    }

    private List<Integer> getSubStringOneLengths(String s) {
        int len = s.length();
        List<Integer> ret = new ArrayList<Integer>();
        int left = -1;
        for (int idx = 0; idx < len; idx++) {
            if (s.charAt(idx) != one) {
                if (left != -1) {
                    // add window size to array
                    ret.add(idx - left);
                    int tmp = idx - 1;
                    System.out.println("[" + left + ", " + tmp + "]");
                    left = -1;
                }
            } else {
                if (left == -1) {
                    left = idx;
                }
            }
        }
        if (left != -1) {
            ret.add(len - left);
            System.out.println("[" + left + ", " + len + "]");
        }

        return ret;
    }

    // return 1 + 2 + ... + n
    private long funcSum(int n) {
        long sum = 0L;
        for (int idx = 1; idx <= n; idx++) {
            sum = sum + idx;
        }

        return sum;
    }

    public static void main(String[] args) {
        String testCase = "";
        System.out.println(new Solution_1513().numSub(testCase));
    }
}
