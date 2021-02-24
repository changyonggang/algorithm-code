package com.leetcode.changyg.str;

public class Solution_10 {
    public static final char point = '.';
    public static final char star = '*';

    public boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();

        for (int i = 0, j = 0; i < sLen; i++) {
            char sc = s.charAt(i);
            char pc = p.charAt(j);

            if (sc == pc) {

            }
        }

        return false;
    }
}
