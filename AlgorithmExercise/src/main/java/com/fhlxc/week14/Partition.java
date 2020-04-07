package com.fhlxc.week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.fhlxc.mylove.ListNode;

/**
* @author Xingchao Long
* @date 2020年4月7日 下午7:04:05
* @classname Partition
* @description 
* 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
* 你应当保留两个分区中每个节点的初始相对位置。
* 示例:
* 输入: head = 1->4->3->2->5->2, x = 3
* 输出: 1->2->2->4->3->5
*/

public class Partition {

    public ListNode partition(ListNode head, int x) {
        ListNode curr = new ListNode(0);
        ListNode tmp = null;
        ListNode temp;
        ListNode tp;
        ListNode result = curr;
        curr.next = head;
        while (curr.next != null) {
            if (curr.next.val >= x) {
                tmp = curr;
                break;
            }
            curr = curr.next;
        }
        curr = curr.next;
        if (curr == null) {
            return head;
        }
        while (curr.next != null) {
            if (curr.next.val < x) {
                if (tmp != null) {
                    temp = tmp.next;
                    tp = curr.next;
                    tmp.next = curr.next;
                    curr.next = curr.next.next;
                    tp.next = temp;
                    tmp = tmp.next;
                }
            } else {
                curr = curr.next;
            }
        }
        return result.next;
    }
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        ListNode head = new ListNode(3);
        ListNode l = head.next = new ListNode(1);
        l = l.next = new ListNode(2);
        l = new Partition().partition(head, Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine()));
        while (l != null) {
            System.out.print(l.val + " ");
            l = l.next;
        }
    }

}
