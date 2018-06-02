package com.leetcode;
/*
* Given a 32-bit signed integer, reverse digits of an integer.

Example 1:

Input: 123
Output: 321
Example 2:

Input: -123
Output: -321
Example 3:

Input: 120
Output: 21
Note:
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range:
[−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.*/

import java.math.BigInteger;

public class ReverseInteger {
    public int reverse(int x) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(x);
        stringBuilder.reverse();
        if ((x >= 0 && new BigInteger(stringBuilder.toString())
                .compareTo(new BigInteger(String.valueOf(Integer.MAX_VALUE))) > 0)
                || x < 0 && new BigInteger("-" + stringBuilder.toString().replace("-", ""))
                .compareTo(new BigInteger(String.valueOf(Integer.MIN_VALUE))) < 0) {
            return 0;
        }
        return x > 0 ? Integer.valueOf(stringBuilder.toString()) :
                -Integer.valueOf(stringBuilder.toString().replace("-", ""));
    }

    public static void main(String[] args) {
        ReverseInteger reverseInteger = new ReverseInteger();
        reverseInteger.reverse(123);
        reverseInteger.reverse(-123);
    }
}
