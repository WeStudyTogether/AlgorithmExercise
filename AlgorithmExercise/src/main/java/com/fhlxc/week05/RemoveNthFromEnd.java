package com.fhlxc.week05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
* @author Xingchao Long
* @date 2020年2月3日 下午4:05:25
* @ClassName RemoveNthFromEnd
* @Description 
* 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
*/

public class RemoveNthFromEnd {

    public static class ListNode {
        int val;
        ListNode next;
        
        public ListNode(int x) {
            val = x;
        }
    }
    
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pointer = new ListNode(0);
        pointer.next = head;
        ListNode front = pointer;
        ListNode rear = pointer;
        for (int i = 0; i < n; i++) {
            rear = rear.next;
        }
        while (rear.next != null) {
            front = front.next;
            rear = rear.next;
        }
        front.next = front.next.next;
        return pointer.next;
    }
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        ListNode head = new ListNode(1);
        ListNode l = head;
        l = l.next = new ListNode(2);
        l = l.next = new ListNode(3);
        l = l.next = new ListNode(4);
        l = l.next = new ListNode(5);
        l = l.next = new ListNode(6);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        l = removeNthFromEnd(head, n);
        while (l != null) {
            System.out.print(l.val + " ");
            l = l.next;
        }
    }

}
