package leetcode;

import java.util.List;

public class LinkedListCycyle {
    public boolean hasCycle(ListNode head) {
        ListNode fast=head;
        ListNode slow= head;
        while(fast!=null && fast.next!=null){
            if(slow==fast)
                return true;

            slow=slow.next;
            fast=fast.next.next;
        }
        return false;
    }
}
