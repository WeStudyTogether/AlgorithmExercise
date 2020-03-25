package com.fhlxc.week12;

import com.fhlxc.mylove.ListNode;

/**
* @author Xingchao Long
* @date 2020年3月25日 上午9:48:56
* @classname DeleteDuplicates
* @description 
* 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
* 示例 1:
* 输入: 1->1->2
* 输出: 1->2
* 示例 2:
* 输入: 1->1->2->3->3
* 输出: 1->2->3
*/

public class DeleteDuplicates {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode l = head;
        if (l == null) {
            return l;
        }
        while (l.next != null) {
            if (l.val == l.next.val) {
                l.next = l.next.next;
            } else {
                l = l.next;
            }
        }
        return head;
    }
    
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode l = new ListNode(1);
        head.next = l;
        l = l.next = new ListNode(2);
        l = l.next = new ListNode(3);
        l = new DeleteDuplicates().deleteDuplicates(head);
        while (l != null) {
            System.out.print(l.val + " ");
            l = l.next;
        }
    }

}
