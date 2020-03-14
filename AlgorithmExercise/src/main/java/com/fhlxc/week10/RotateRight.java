package com.fhlxc.week10;

import com.fhlxc.mylove.ListNode;

/**
* @author Xingchao Long
* @date 2020年3月14日 下午3:55:27
* @ClassName RotateRight
* @Description
* 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
* 示例 1:
* 输入: 1->2->3->4->5->NULL, k = 2
* 输出: 4->5->1->2->3->NULL
* 解释:
* 向右旋转 1 步: 5->1->2->3->4->NULL
* 向右旋转 2 步: 4->5->1->2->3->NULL
* 示例 2:
* 输入: 0->1->2->NULL, k = 4
* 输出: 2->0->1->NULL
* 解释:
* 向右旋转 1 步: 2->0->1->NULL
* 向右旋转 2 步: 1->2->0->NULL
* 向右旋转 3 步: 0->1->2->NULL
* 向右旋转 4 步: 2->0->1->NULL
*/

public class RotateRight {

    public ListNode rotateRight(ListNode head, int k) {
        int length = 0;
        ListNode t  = head;
        int  tp = 0;
        while (t != null) {
            length ++;
            t = t.next;
        }
        if (length == 0) {
            return head;
        }
        k = k % length;
        if (k == 0) {
            return head;
        }
        int[] tmp = new int[k];
        t = head;
        for (int i = 1; i <= k; i++) {
            tmp[i % k] = t.val;
            t = t.next;
        }
        for (int i = 1; i <= length; i++) {
            tp = tmp[i % k];
            tmp[i % k] = t.val;
            t.val = tp;
            t = t.next;
            if (t == null) {
                t = head;
            }
        }
        return head;
    }
    
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode t = head.next = new ListNode(2);
        t = t.next = new ListNode(3);
        t = t.next = new ListNode(4);
        t = t.next = new ListNode(5);
        t = new RotateRight().rotateRight(head, 6);
        while (t != null) {
            System.out.print(t.val + " ");
            t = t.next;
        }
    }

}
