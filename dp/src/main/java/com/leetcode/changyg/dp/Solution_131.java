package com.leetcode.changyg.dp;

import java.util.ArrayList;
import java.util.List;

public class Solution_131 {
    private int len;
    private List<List<Boolean>> dpMap;
    private List<List<String>> subStrs = new ArrayList<List<String>>();
    private String s;
    // 构建 dp 二维表
    public List<List<String>> partition(String s) {
        // 1. 异常处理
        if (null == s) {
            return null;
        }
       init(s);
        if (len < 1) {
            List<String> row = new ArrayList<String>(1);
            row.add("");
            List<List<String>> ret = new ArrayList<List<String>>(1);
            ret.add(row);
            return ret;
        }
        // 2. 构建 dp 二维表, 这部分为核心。
        dp(s);
        // 3. 根据 dp 二维表构造返回数组
        dpMap2Array(0, len);
        return subStrs;
    }

    private void init(String s) {
        len = s.length();
        s = s;
    }

    // dpMap[i][j] 为 true ， 代表 s[i : j] 为回文字符串
    private void dp(String s) {
        dpMap = new ArrayList<List<Boolean>>(len);
        for(int j = 0; j < len; j++) {
            for(int i = j; i > -1; i--) {
                if(i == j || j == 0) {
                    // 只有一个字母时，为回文
                    dpMap.get(i).set(j, true);
                } else if (dpMap.get(i + 1).get(j - 1)) {
                    if (s.charAt(i) == s.charAt(j)) {
                        dpMap.get(i).set(j, true);
                    }
                }
            }
        }
    }

    private void dpMap2Array(int left, int right) {
        if(right - left == 1 && dpMap.get(left).get(right)) {
            for (List<String> subStr : subStrs) {
                subStr.add(Character.toString(s.charAt(left)));
            }
            return ;
        }

        for (int j = 0; j < len; j++) {
            if (dpMap.get(left).get(j)) {
                for (List<String> subStr : subStrs) {
                    subStr.add(s.substring(left, j));
                }
            }
        }
    }
}
