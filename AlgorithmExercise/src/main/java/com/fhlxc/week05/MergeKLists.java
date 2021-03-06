package com.fhlxc.week05;

/**
* @author Xingchao Long
* @date 2020年2月6日 下午3:55:12
* @ClassName MergeKLists
* @Description 合并K个有序链表
*/

public class MergeKLists {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    
    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode tmp = null;
        ListNode head = null;
        ListNode l = null;
        ListNode x = null;
        
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        
        if (l1.val < l2.val) {
            head = l1;
            tmp = l2;
        } else {
            head = l2;
            tmp = l1;
        }
        l = head;
        for (;l.next != null && tmp != null; ) {
            if (l.next.val < tmp.val) {
                l = l .next;
            } else {
                x = tmp;
                tmp = l.next;
                l.next = x;
                l = l.next;
            }
        }
        l.next = tmp;
        return head;
    }
    
    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode head = null;
        if (lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        head = lists[0];
        for (int i = 1; i < lists.length; i++) {
            head = mergeTwoLists(head, lists[i]);
        }
        return head;
    }
    
    public static void main(String[] args) {
        ListNode[] ls = new ListNode[2];
        ListNode l1 = new ListNode(3);
        ListNode l = l1;
        l = l.next = new ListNode(4);
        l = l.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l = l2;
        l = l.next = new ListNode(3);
        ls[0] = l1;
        ls[1] = l2;
        l = mergeKLists(ls);
        for (;l != null; l = l.next) {
            System.out.print(l.val + " ");
        }
    }

}
