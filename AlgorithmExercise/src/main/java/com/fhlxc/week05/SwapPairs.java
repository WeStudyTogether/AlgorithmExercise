package com.fhlxc.week05;

/**
* @author Xingchao Long
* @date 2020年2月7日 上午10:59:21
* @ClassName SwapPairs
* @Description 两两反转链表
* 例如：
* 输入：1->3->4->5
* 输出：3->1->5->4
*/

public class SwapPairs {

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
                return l;
            }
            l = l.next;
        }
        return l;
    }
    
    public static ListNode swapPairs(ListNode head) {
        ListNode result = head;
        ListNode tail = null;
        ListNode next = null;
        ListNode prev = null;
        ListNode[] ls = new ListNode[2];
        while (result != null) {
            tail = kNode(result, 2);
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
    
    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        ListNode l = l1;
        l = l.next = new ListNode(4);
        l = l.next = new ListNode(5);
        l = l.next = new ListNode(6);
        l = swapPairs(l1);
        for (;l != null; l = l.next) {
            System.out.print(l.val + " ");
        }
    }

}
