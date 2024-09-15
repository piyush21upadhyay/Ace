package com.ace.linkedlist;

import java.util.LinkedList;


/**
 * Initialize two pointers, slow and fast, both starting at the head of the list.
 * Move the fast pointer two steps and the slow pointer one step at a time.
 * When the fast pointer reaches the end of the list, the slow pointer will be at the middle.
 * To delete the middle node, keep track of the previous node to the slow pointer and adjust its next reference.
 */
public class DeleteMiddleElementLinkedList {
    static class Node{
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next= new Node(3);
        node.next.next.next=new Node(4);
        node.next.next.next.next=new Node(5);
        printLinkedList(node);
        deleteMiddleElement(node);

    }

    private static void deleteMiddleElement(Node head) {
        Node slowPtr = head;
        Node fastPtr = head;
        Node prev = null;

        while (fastPtr!=null && fastPtr.next!=null){
            fastPtr = fastPtr.next.next;
            prev = slowPtr;
            slowPtr = slowPtr.next;
        }

        // slow is now pointing to the middle element, prev is pointing to the element before the middle
        if(prev!=null){
            prev.next = slowPtr.next;
        }
        System.out.println("After deleting middle element");
        printLinkedList(head);
    }

    private static void printLinkedList(Node node) {
        while (node!=null){
            System.out.println("Node data");
            System.out.println(node.data);
            node = node.next;
        }
    }

}
