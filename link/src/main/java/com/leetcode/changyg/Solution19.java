package com.leetcode.changyg;

public class Solution19 {
    // 总体评价，这道题比较中规中矩，不涉及复杂的算法，主要考察对链表的理解和使用，
    // 这个问题的难点在于链表是个傻子，只能正向遍历，不能逆序遍历。
    // 有以下几种思路解决这个问题
    // 1. 最基础的解法
    //    遍历两遍数组，第一遍获取链表长度，进而知道需要删除的节点是第 len - k 个节点
    //    第二遍遍历的时候删除第 len - k 个节点
    // 2. 链表操作有一个小技巧就是，多个指针同步前进。最巧妙的方法其实就是前后两个间隔距离
    //    为k的指针同步前进，前面指针到达了尾节点，后节点就找到了指定位置。
    //
    // 3. 解决逆序问题，可以通过单链表构建成双向链表，通过双向链表解决逆序问题。
    // 4. 利用栈的思想，FILO，将链表中数据依次放入栈中，再弹出k个，就找到了对应节点，
    //    空间换时间，有点空间浪费。
    //
    // 这题可以总结的点：熟悉链表的那些骚操作，记住其套路就 ok 了。

    // 本函数采用第二种思路解决
    public ListNode removeNthFromEnd(ListNode head, int n){
        ListNode p = head;
        ListNode pre = head;
        while(n > 0) {
            pre = pre.next;
            n--;
        }

        while(null != pre.next){
            p = p.next;
            pre = pre.next;
        }
        p.next = p.next.next;

        return head;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args){

    }
}