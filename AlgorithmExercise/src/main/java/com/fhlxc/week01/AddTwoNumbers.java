package com.fhlxc.week01;

/**
* @author Xingchao Long
* @date 2020/39/10 17:39:28
* @ClassName AddTwoNumbers
* @Description 
* 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

* 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

* 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

* 示例：

* 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
* 输出：7 -> 0 -> 8
* 原因：342 + 465 = 807
*/

public class AddTwoNumbers {
    //节点类
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { 
            val = x; 
        }
    }
    
    //对两个链表进行加操作
    private void add(ListNode l1, ListNode l2) {
        while (l1 != null) {
            //初始时，val是长的链表的那个节点
            int val = l1.val;
            
            //如果短的那个节点不是null，相加两个数
            if (l2 != null) {
                val = l1.val + l2.val;
            }
            
            //如果当前值大于1，进位
            if (val >= 10) {
                l1.val = val % 10;
                
                //没有节点，就新建一个
                if (l1.next != null) {
                    l1.next.val++;
                } else {
                    ListNode w = new ListNode(1);
                    l1.next = w;
                    w.next = null;
                }
            } else {
                l1.val = val;
            }
            
            //循环遍历
            l1 = l1.next;
            if (l2 != null) {
                l2 = l2.next;
            }
        }
    }
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //i记录l1的长度
        int i = 0;
        //j记录l2的长度
        int j = 0;
        
        //临时的链表找到长度，以便不改变l1和l2链表
        ListNode l;
        
        //找到l1的长度
        l = l1;
        while (l != null) {
            i++;
            l = l.next;
        }
        
        //找到l2的长度
        l = l2;
        while (l != null) {
            j++;
            l = l.next;
        }
        
        //分两种情况，左边是长的那个链表
        if (i > j) {
            add(l1, l2);
            return l1;
            
        } else {
            add(l2, l1);
            return l2;
        }
    }
    
    public static void main(String[] args) {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode l1 = addTwoNumbers.new ListNode(9);
        ListNode l2 = addTwoNumbers.new ListNode(9);
        l1.next = null;
        l2.next = null;
        ListNode l = addTwoNumbers.addTwoNumbers(l1, l2);
        while (l != null) {
            System.out.println(l.val);
            l = l.next;
        }
    }

}
