package neetcode;

import java.util.ArrayList;

/**
 * Design Singly Linked List
 * Design a Singly Linked List class.
 *
 * Your LinkedList class should support the following operations:
 *
 * LinkedList() will initialize an empty linked list.
 * int get(int i) will return the value of the ith node (0-indexed). If the index is out of bounds, return -1.
 * void insertHead(int val) will insert a node with val at the head of the list.
 * void insertTail(int val) will insert a node with val at the tail of the list.
 * int remove(int i) will remove the ith node (0-indexed). If the index is out of bounds, return false, otherwise return true.
 * int[] getValues() return an array of all the values in the linked list, ordered from head to tail.
 * Example 1:
 *
 * Input:
 * ["insertHead", 1, "insertTail", 2, "insertHead", 0, "remove", 1, "getValues"]
 *
 * Output:
 * [null, null, null, true, [0, 2]]
 * Example 2:
 *
 * Input:
 * ["insertHead", 1, "insertHead", 2, "get", 5]
 *
 * Output:
 * [null, null, -1]
 * Note:
 *
 * The index int i provided to get(int i) and remove(int i) is guranteed to be greater than or equal to 0.
 */

class Node{
    int data;
    Node next;

    Node(int d){
        this.data=d;
        this.next=null;
    }
}
class DesignSingleLinkedList {
    Node head;

    public DesignSingleLinkedList() {
        head = new Node(-1);
    }

    //O(n) = n=size of linkedlist--worst case if index is the last element
    public int get(int index) {
        Node temp = this.head.next;
        int i=0;
        while(temp!=null){
            if(i==index){
                return temp.data;
            }
            temp=temp.next;
            i++;
        }
        return -1;
    }
    //O(1)
    public void insertHead(int val) {
        Node newNode = new Node(val);
        newNode.next = this.head.next;
        this.head.next=newNode;
    }
    //O(n)==worst case and avg case, n = size of linkedlist
    public void insertTail(int val) {
        Node temp = this.head;
        Node newNode = new Node(val);
        if(temp==null){
            this.head = newNode;
            return;
        }
        if(temp.next==null){
            this.head.next = newNode;
            return;
        }

        while(temp.next!=null){
            temp=temp.next;
        }

        temp.next = newNode;
    }

    //O(n) = n=size of linkedlist--worst case if index is the last element
    public boolean remove(int index) {
        Node temp = this.head;
        int i=0;
        while(temp!=null && temp.next!=null){
            if(i==index){
                temp.next = temp.next.next;
                return true;
            }
            i++;
            temp=temp.next;
        }
        return false;
    }
    //O(n) = n=size of linkedlist
    public ArrayList<Integer> getValues() {
        ArrayList<Integer> res = new ArrayList<>();
        Node curr = this.head.next;
        while (curr != null) {
            res.add(curr.data);
            curr = curr.next;
        }
        return res;
    }
}

