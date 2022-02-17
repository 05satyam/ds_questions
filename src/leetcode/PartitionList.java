/*
* Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.
*
*
* Input: head = [1,4,3,2,5,2], x = 3
Output: [1,2,2,4,3,5]
*
* */
package leetcode;

import java.util.List;

public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode res = new ListNode();
        ListNode finalRes = res;
        ListNode newHead =head;
        while(newHead!=null){
            if(newHead.val<x) {
                ListNode node = new ListNode(newHead.val);
                res.next=node;
            }
            newHead=newHead.next;
            res=res.next;
        }

        newHead=head;
        while(newHead!=null){
            if(newHead.val>=x) {
                ListNode node = new ListNode(newHead.val);
                res.next=node;
            }
            newHead=newHead.next;
            res=res.next;
        }
        return finalRes.next;
    }
}
