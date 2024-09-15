package com.ace.linkedlist;


public class ReverseLinkedList {
    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(5);
        printLinkedList(node);

        Node reversedHead = reverseLinkedList(node);
        System.out.println("After reversing");
        printLinkedList(reversedHead);
    }

    private static Node reverseLinkedList(Node head) {
        if (head == null) {
            return head;
        }
        Node prev = null;
        Node current = head;

        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;

    }

    private static void printLinkedList(Node node) {
        while (node != null) {
            System.out.println("Node data");
            System.out.println(node.data);
            node = node.next;
        }
    }

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
}
