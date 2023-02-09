/**
 *
 * taken help from leet code discussion
 *
 * You are given the head of a singly linked-list. The list can be represented as:
 *
 * L0 → L1 → … → Ln - 1 → Ln
 * Reorder the list to be on the following form:
 *
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 */
package leetcode;

import java.util.List;
import java.util.Stack;

public class ReorderList {
        public void reorderList(ListNode head) {
            Stack<ListNode> sc = new Stack<>();
            int c=0;
            ListNode curr = head;
            while(curr!=null){
                sc.push(curr);
                curr=curr.next;
                c++;
            }

            System.out.println("head "+ head.val);

            curr=head;

            for(int i=0;i<c/2;i++){
                ListNode temp=curr.next;
                ListNode end=sc.pop();
                curr.next=end;
                end.next=temp;
                curr=temp;

            }
            curr.next=null;
         }

    public static void main(String[] a){
        ReorderList r = new ReorderList();

        ListNode ll1= new ListNode(1, null);
        ListNode ll11= ll1;
        ll1.next=new ListNode(2, null);
        ll1=ll1.next;

        ll1.next=new ListNode(3,null);
        ll1=ll1.next;
        ll1.next=new ListNode(4,null);

        System.out.println("before");
        ListNode res=ll11;
        while(res!=null) {
            System.out.print(res.val + "  ");
            res=res.next;
        }
        System.out.println();
        System.out.println("after");
        r.reorderList(ll11);
    }
}
