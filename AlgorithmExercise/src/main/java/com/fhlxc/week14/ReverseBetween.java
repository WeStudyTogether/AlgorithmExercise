package com.fhlxc.week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.fhlxc.mylove.ListNode;

/**
* @author Xingchao Long
* @date 2020年4月11日 上午9:46:57
* @classname ReverseBetween
* @description 
* 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
* 说明:
* 1 ≤ m ≤ n ≤ 链表长度。
* 示例:
* 输入: 1->2->3->4->5->NULL, m = 2, n = 4
* 输出: 1->4->3->2->5->NULL
*/

public class ReverseBetween {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode h;
        ListNode next = null;;
        ListNode p;
        ListNode curr = pre;
        int count = 0;
        while (count < m - 1) {
            count++;
            curr = curr.next;
        }
        h = curr;
        p = curr;
        curr = curr.next;
        count++;
        while (count <= n) {
            next = curr.next;
            curr.next = p;
            p = curr;
            curr = next;
            count++;
        }
        h.next.next = curr;
        h.next = p;
        return pre.next;
    }
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        ListNode head = new ListNode(1);
        ListNode l = head.next = new ListNode(2);
        l = l.next = new ListNode(3);
        l = l.next = new ListNode(4);
        l = l.next = new ListNode(5);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(reader.readLine());
        int n = Integer.parseInt(reader.readLine());
        l = new ReverseBetween().reverseBetween(head, m, n);
        while (l != null) {
            System.out.print(l.val + " ");
            l = l.next;
        }
    }

}
