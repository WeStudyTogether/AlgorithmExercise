package com.fhlxc.week14;

import com.fhlxc.mylove.ListNode;

/**
* @author Xingchao Long
* @date 2020年4月6日 下午4:16:42
* @classname DeleteDuplicates
* @description 
* 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
* 示例 1:
* 输入: 1->2->3->3->4->4->5
* 输出: 1->2->5
* 示例 2:
* 输入: 1->1->1->2->3
* 输出: 2->3
*/

public class DeleteDuplicates {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode p = new ListNode(0);
        p.next = head;
        ListNode curr = p;
        ListNode t = null;
        head = curr;
        while (curr.next != null) {
            if (curr.next.next == null) {
                break;
            }
            if (curr.next.val == curr.next.next.val) {
                t = curr;
                while (t.next.val == curr.next.val) {
                    t = t.next;
                    if (t.next == null) {
                        break;
                    }
                }
                curr.next = t.next;
            } else {
                curr = curr.next;
            }
        }
        return head.next;
    }
    
    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        ListNode tmp = head;
        tmp = tmp.next = new ListNode(3);
        tmp = tmp.next = new ListNode(3);
        tmp = new DeleteDuplicates().deleteDuplicates(head);
        while (tmp != null) {
            System.out.print(tmp.val + " ");
            tmp = tmp.next;
        }
    }

}
