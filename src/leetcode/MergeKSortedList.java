/**
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 *
 * Merge all the linked-lists into one sorted linked-list and return it.
 *
 *
 *
 * Example 1:
 *
 * Input: lists = [[1,4,5],[1,3,4],[2,6]]
 * Output: [1,1,2,3,4,4,5,6]
 * Explanation: The linked-lists are:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * merging them into one sorted list:
 * 1->1->2->3->4->4->5->6
 *
 *
 */
package leetcode;

import java.util.*;

public class MergeKSortedList {
    public static ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0)
            return null;

        List<Integer> elem = new LinkedList<>();
        for(int i=0;i<lists.length;i++){
            ListNode ll = lists[i];

            //System.out.println("i   "+ i );
            while (ll!=null){
                elem.add(ll.val);
                //System.out.println("ll "+ ll.val);
                ll=ll.next;
            }
        }
        if(elem.size()==0)
            return null;

        Collections.sort(elem);
        ListNode res = new ListNode();
        ListNode resll = new ListNode();
        resll=res;
        res.val=elem.get(0);
        //System.out.println("elem "+ elem.get(0));
        for(int i=1;i<elem.size();i++){
            res.next=new ListNode();
            res=res.next;
            res.val=elem.get(i);
            //System.out.println("elem1 "+ res.val);
        }
        return resll;
    }

    public static void main(String[] a){
        ListNode[] ll= new ListNode[1];

        ListNode ll1= new ListNode(1, null);
        ListNode ll11= new ListNode();

        ll1.next=new ListNode(2, null);
        ll1=ll1.next;

        ll1.next=new ListNode(3,null);

        ListNode ll2= new ListNode(4, null);
        ListNode ll22= ll2;

        ll2.next=new ListNode(5, null);
        ll2=ll2.next;

        ll2.next=new ListNode(6, null);
        ll2=ll2.next;



        ll[0]=ll11;
       // ll[1]=ll22;
        ListNode res = mergeKLists(ll);
        while(res!=null) {
            System.out.println(res.val);
            res=res.next;
        }
    }
}
