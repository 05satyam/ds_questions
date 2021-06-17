/**
 * You are given the head of a linked list, and an integer k.
 *
 * Return the head of the linked list after swapping the values of the kth node from the beginning and the kth node from the end (the list is 1-indexed).
 *
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [1,4,3,2,5]
 * Example 2:
 *
 * Input: head = [7,9,6,6,7,8,3,0,9,5], k = 5
 * Output: [7,9,6,6,8,7,3,0,9,5]
 */
package leetcode;

import java.util.LinkedList;

public class SwappingNodesInLinkedList {
    public ListNode swapNodes(ListNode head, int k) {
        int listLen = 0;
        ListNode root = head;
        while(root!=null){
            listLen++;

            root = root.next;
        }
        root = head;
        ListNode kStart = null;
        ListNode kEnd = null;
        int count = 1;
        while(root!=null){
            if(count==k){
                kStart = root;
            }
            //count++;
            if(count==(listLen-k+1))
                kEnd =root;
            count++;
            root=root.next;
        }

        int temp = kStart.val;
        kStart.val=kEnd.val;
        kEnd.val=temp;

        return head;
    }
}
