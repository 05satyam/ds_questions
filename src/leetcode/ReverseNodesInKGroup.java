/**
 * Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.
 *
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
 *
 * You may not alter the values in the list's nodes, only nodes themselves may be changed.
 *
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [2,1,4,3,5]
 */
package leetcode;

public class ReverseNodesInKGroup {
    public ListNode reverseList(ListNode head, ListNode last) {
        ListNode curr=head;
        ListNode prev=null;
        ListNode next= null;

        while(curr!=null && last!=null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        //curr.next=null;
        head = prev;

        ListNode test1=head, test2=last;
//        System.out.println("-------");
//        while(test1!=null){
//            System.out.print( "test  " + test1.val + "    ");
//            test1=test1.next;
//        }
//        System.out.println("-------");


        return head;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode prev=null, last= head, head1=null, res=null;
        while(true){
            if(last==null)
                break;
            int count=0;
            head1=last;
            //System.out.println("head-1 "+ head1.val);
            while(count<k && last!=null){
                prev=last;
                last=last.next;
                count++;
            }
            //System.out.println("count "+ count);
            if(count<k && head1!=null){
                ListNode dummyRes=res;
                while(dummyRes.next!=null){
                    dummyRes=dummyRes.next;
                }
                while(head1!=null){
                   dummyRes.next=head1;
                   dummyRes=dummyRes.next;
                   head1=head1.next;

                }
                break;
            }
            if(count<k)
                break;
            last=prev;

            ListNode last1=prev.next;
            last.next=null;
            //last=null;
            ListNode reverHead = reverseList(head1, last);

            if(res==null){
                res=reverHead;
            }else{
                ListNode dummyRes=res;
                while(dummyRes.next!=null){
                    dummyRes=dummyRes.next;
                }
                dummyRes.next=reverHead;
            }
            //System.out.println("prev val "+ prev.val + "     prev next val "+ prev.next.val );
            last = last1;
            //System.out.println("last next val "+ prev.val);
        }
        return res;
    }
    public static void main(String[] a){
        ReverseNodesInKGroup obj= new ReverseNodesInKGroup();
        ListNode ll1= new ListNode(1, null);
        ListNode lll1=ll1;
        ll1.next= new ListNode(2, null);
        ll1=ll1.next;

        ll1.next=new ListNode(3,null);
        ll1= ll1.next;
        ll1.next= new ListNode(4, null);



//        while(lll1!=null){
//            System.out.print(lll1.val + "   ");
//            lll1=lll1.next;
//        }
        System.out.println( "ll1 val "+ ll1.val);

        ListNode res1 = obj.reverseKGroup(lll1, 2);
        ListNode res=res1;
        System.out.println("res");
        while(res!=null){
            System.out.print(res.val + "    ");
            res=res.next;
        }
    }
}
