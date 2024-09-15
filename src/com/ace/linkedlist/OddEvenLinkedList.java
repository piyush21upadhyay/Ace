package com.ace.linkedlist;



public class OddEvenLinkedList {
    static class Node {
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
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(5);
        printLinkedList(node);

        Node result = oddEvenList(node);

        System.out.println("Reordered list:");
        printLinkedList(result);
    }

    private static Node oddEvenList(Node head) {
        if (head == null) {
            return null;
        }
        Node odd = head;
        Node even = head.next;
        Node evenHead = even;

        while (even!=null && even.next!=null){
            odd.next = even.next;
            odd=odd.next;
            even.next = odd.next;
            even=even.next;
        }
        odd.next=evenHead;
        return  head;
    }

    private static void printLinkedList(Node node) {
        while (node != null) {
            System.out.println("Node data");
            System.out.println(node.data);
            node = node.next;
        }
    }
}


