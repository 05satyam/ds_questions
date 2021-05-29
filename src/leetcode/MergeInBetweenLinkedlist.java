/*

You are given two linked lists: list1 and list2 of sizes n and m respectively.

Remove list1's nodes from the ath node to the bth node, and put list2 in their place.

The blue edges and nodes in the following figure incidate the result:


Build the result list and return its head.



Example 1:


Input: list1 = [0,1,2,3,4,5], a = 3, b = 4, list2 = [1000000,1000001,1000002]
Output: [0,1,2,1000000,1000001,1000002,5]
Explanation: We remove the nodes 3 and 4 and put the entire list2 in their place. The blue edges and nodes in the above figure indicate the result.
*/


package leetcode;


class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
public class MergeInBetweenLinkedlist {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        int count = 0;
        ListNode currNode = list1;
        while (count < a - 1) {
            currNode = currNode.next;
            count++;
        }
        ListNode removed = currNode.next;
        currNode.next = list2;
        while (currNode.next != null) currNode = currNode.next;
        while (count < b) {
            removed = removed.next;
            count++;
        }
        currNode.next = removed;
        return list1;
    }

}
