package com.leetcode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */

import java.math.BigInteger;

public class AddTwoNumbers {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    private ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        BigInteger numberOne = getNumberFromListNode(l1);
        BigInteger numberTwo = getNumberFromListNode(l2);
        StringBuilder sumNumbers = new StringBuilder();
        sumNumbers.append(numberOne.add(numberTwo));
        ListNode firstNode = new ListNode(0);
        ListNode lastNode = firstNode;
        char[] numericChar = sumNumbers.reverse().toString().toCharArray();
        lastNode.val = Character.getNumericValue(numericChar[0]);
        for (int i = 1; i < numericChar.length; i++) {
            lastNode.next = new ListNode(Character.getNumericValue(numericChar[i]));
            lastNode = lastNode.next;
        }
        return firstNode;
    }


    private BigInteger getNumberFromListNode(ListNode l) {
        StringBuilder nodeNumber = new StringBuilder();
        while (l != null) {
            nodeNumber.append(l.val);
            l = l.next;
        }
        return nodeNumber.length() == 0 ? new BigInteger("0")
                : new BigInteger(nodeNumber.reverse().toString());
    }

    public static void main(String[] args) {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode listNode = new ListNode(2);
        listNode.next = new ListNode(4);
        listNode.next.next = new ListNode(3);

        ListNode listNode2 = new ListNode(5);
        listNode2.next = new ListNode(6);
        listNode2.next.next = new ListNode(4);
        addTwoNumbers.addTwoNumbers(listNode, listNode2);
    }
}
