package com.leetcode.ListNode;

/*
*
*
*
*
* Merge two sorted linked lists and return it as a new list.
* The new list should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4
*
* */

import java.util.*;

public class MergeTwoSortedLists {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        LinkedList<Integer> list = new LinkedList<>();
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                list.add(l1.val);
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
                list.add(l2.val);
            }
        }
        Collections.sort(list);
        return toListNode(list);
    }

    private static ListNode toListNode(Deque<Integer> list) {
        ListNode firstNode = new ListNode(list.pollFirst());
        ListNode lastNode = firstNode;
        for (Integer i : list) {
            lastNode.next = new ListNode(i);
            lastNode = lastNode.next;
        }
        return firstNode;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(2);
        listNode.next = new ListNode(4);
        listNode.next.next = new ListNode(3);
        ListNode listNode1 = new ListNode(2);
        listNode1.next = new ListNode(4);
        listNode1.next.next = new ListNode(3);
        ListNode listNode2 = null;
        ListNode ki = mergeTwoLists(listNode, listNode1);
    }

}
