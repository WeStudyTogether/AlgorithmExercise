package com.fhlxc.week05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
* @author Xingchao Long
* @date 2020年2月7日 下午4:49:25
* @ClassName ReverseKGroup
* @Description k组反转,不够的保持原序
* 给定这个链表：1->2->3->4->5
* 当 k = 2 时，应当返回: 2->1->4->3->5
* 当 k = 3 时，应当返回: 3->2->1->4->5
*/

public class ReverseKGroup {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    
    private static ListNode[] swap(ListNode head, ListNode tail) {
        ListNode[] result = new ListNode[2];
        
        ListNode l = new ListNode(0);
        ListNode tmp = head;
        l.next = tmp;
        
        ListNode prev = l;
        ListNode curr = tmp;
        ListNode next = null;
        
        while (curr != tail) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        curr.next = prev;
        tmp.next = null;
        
        result[0] = tail;
        result[1] = head;
        return result;
    }
    
    private static ListNode kNode(ListNode head, int k) {
        ListNode l = head;
        for (int i = 0; i < k - 1; i++) {
            if (l.next == null) {
                return null;
            }
            l = l.next;
        }
        return l;
    }
    
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode result = head;
        ListNode tail = null;
        ListNode next = null;
        ListNode prev = null;
        ListNode[] ls = new ListNode[2];
        while (result != null) {
            tail = kNode(result, k);
            if (tail == null) {
                return head;
            }
            next = tail.next;
            ls = swap(result, tail);
            if (prev != null) {
                prev.next = ls[0];
            } else {
                head = ls[0];
            }
            ls[1].next = next;
            prev = ls[1];
            result = next;
        }
        return head;
    }
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        ListNode l1 = new ListNode(1);
        ListNode l = l1;
        l = l.next = new ListNode(2);
        l = l.next = new ListNode(3);
        l = l.next = new ListNode(4);
        l = l.next = new ListNode(5);
        l = reverseKGroup(l1, Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine()));
        for (;l != null; l = l.next) {
            System.out.print(l.val + " ");
        }
    }

}
