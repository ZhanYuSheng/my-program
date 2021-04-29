package com.zys.leetcode;

/**
 * 链表翻转
 *
 */
public class ReverseList {

    static class ListNode{
        private ListNode next;
        private int value;

        public ListNode(int value, ListNode next) {
            this.next = next;
            this.value = value;
        }

    }

    //通过迭代方式实现
    public static ListNode iterator(ListNode head){
        ListNode next, prev = null;
        ListNode curr = head;
        while (curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    //通过递归方式实现
    public static ListNode recursion(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode newHead = recursion(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode listNode5 = new ListNode(5, null);
        ListNode listNode4 = new ListNode(4, listNode5);
        ListNode listNode3 = new ListNode(3, listNode4);
        ListNode listNode2 = new ListNode(2, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);

//        ListNode prev = iterator(listNode1);
        ListNode prev = recursion(listNode1);
        System.out.println("");
    }

}
