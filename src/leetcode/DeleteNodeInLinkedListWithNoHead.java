/**
 * Write a function to delete a node in a singly-linked list. You will not be given access to the head of the list, instead you will be given access to the node to be deleted directly.
 *
 * It is guaranteed that the node to be deleted is not a tail node in the list.
 *
 * Input: head = [1,2,3,4], node = 3
 * Output: [1,2,4]
 */

package leetcode;

 class ListNode1 {
      int val;
      ListNode1 next;
      ListNode1(int x) { val = x; }
  }
 
public class DeleteNodeInLinkedListWithNoHead {
    public void deleteNode(ListNode1 node) {
        ListNode1 prev = null;
        while(node.next!=null){
           prev= node;
           node.val = node.next.val;
           node=node.next;
        }
        prev.next=null;
    }
}
