package leetcode;

public class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode temRes, res = new ListNode(0);
        temRes = res;
        while (l1 != null || l2 != null || carry != 0) {
            if (l1 != null) {
                carry += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                carry += l2.val;
                l2 = l2.next;
            }
            temRes.next = new ListNode(carry%10);
            carry /= 10;
            temRes = temRes.next;
        }
        return res.next;
    }


    public static void main(String[] a){
        ListNode l1=new ListNode(2);
        l1.next=new ListNode(4);
        l1.next.next=new ListNode(3);

        ListNode l2=new ListNode(5);
        l2.next=new ListNode(6);
        l2.next.next=new ListNode(4);
        ListNode res = addTwoNumbers(l1,l2);
       // System.out.println("res imn main " + res.val + "    "+ res.next.val + "    "+ res.next.next.val);

    }
}
