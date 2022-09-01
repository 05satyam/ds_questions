/**
 * 19. Remove Nth Node From End of List
 * Medium
 *
 * 12117
 *
 * 528
 *
 * Add to List
 *
 * Share
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 *
 *
 *
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 * Example 2:
 *
 * Input: head = [1], n = 1
 * Output: []
 * Example 3:
 *
 * Input: head = [1,2], n = 1
 * Output: [1]
 */
package leetcode;

public class RemoveNthNodeFromEndOfList {
    //solution1 - not efficient

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int listLen=0;
        ListNode newHead = head;

        while(newHead!=null){
            listLen++;
            newHead=newHead.next;

        }
        if(listLen==1 && n==1)
            return head.next;
        int nodeLen= listLen-n;
        if(nodeLen==0){
            return head.next;
        }

        int nodeToBeRemoved  = listLen-n;

        newHead=head;
        int i=1;
        while(i<nodeToBeRemoved){
            newHead=newHead.next;
            i++;
            System.out.println(i);
        }

        if(i==nodeToBeRemoved){
            System.out.println(i+ "  "+ nodeToBeRemoved);
            newHead.next=newHead.next.next;
            System.out.println(newHead.val);
        }
        return head;
    }
}
