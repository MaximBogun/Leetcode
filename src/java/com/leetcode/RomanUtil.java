package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class RomanUtil {

    private final Map<String, Integer> romanNumber = new HashMap<String, Integer>() {{
        put("I", 1);
        put("V", 5);
        put("X", 10);
        put("L", 50);
        put("C", 100);
        put("D", 500);
        put("M", 1000);
    }};

    private int romanToInt(String s) {
        int prevN = Integer.MAX_VALUE;
        int sum = 0;
        int n;
        for (char ch : s.toCharArray()) {
            n = romanNumber.get(String.valueOf(ch));
            if (prevN < n) {
                sum -= prevN * 2;
            }
            sum += n;
            prevN = n;
        }
        return sum;
    }

    public static void main(String[] args) {
        RomanUtil romanUtil = new RomanUtil();
        System.out.println(romanUtil.romanToInt("XLVIII"));
    }
}
