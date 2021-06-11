package leetcode;

import java.util.HashSet;
import java.util.Set;
class ListNode11 {
      int val;
      ListNode11 next;
      ListNode11() {}
      ListNode11(int val) { this.val = val; }
      ListNode11(int val, ListNode11 next) { this.val = val; this.next = next; }
  }
public class PalindromLinkedList {
    public static boolean isPalindrome(ListNode11 head) {

        ListNode11 fast=head;
        ListNode11 slow= head;
        int count=1;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;

            slow=slow.next;
            //System.out.println("slow "+ slow.val);

            count++;
        }
        if(count==1)
            return true;
        System.out.println("fast: "+ fast + " , slow : "+ slow.val + " , count "+ count);
        ListNode11 center = slow, centerNode = slow;
        ListNode11 reversedNodeFromMiddle  = reverse(slow);

        while(head!=null && reversedNodeFromMiddle!=null){
            System.out.println("head "+ head.val + " reverse node "+ reversedNodeFromMiddle.val);
            if(head.val!=reversedNodeFromMiddle.val)
                break;
            head=head.next;
            reversedNodeFromMiddle=reversedNodeFromMiddle.next;

        }
        System.out.println("head "+ head+ " reverse "+ reversedNodeFromMiddle);
        return (head==centerNode || head==null)&& reversedNodeFromMiddle==null? true :false;
    }

    static ListNode11 reverse(ListNode11 node)
    {
        ListNode11 prev = null;
        ListNode11 current = node;
        ListNode11 next = null;
        int count=0;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }
        node = prev;
        System.out.println("node.val "+ node.val   + " count"+ count) ;
        return node;
    }

    public static void main(String[] a){
        ListNode11 listNode11 = new ListNode11(1);
        listNode11.next = new ListNode11(0);
        listNode11.next.next= new ListNode11(0);
        listNode11.next.next.next= new ListNode11(1);
        System.out.println(isPalindrome(listNode11));
    }
}
