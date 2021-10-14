package com.java.dsa.linked_lists;

// Linked list is a linear data structure,
// where data stored in memory is connected through pointers or references.
// Advantages of Linked List are dynamic size ease of insertion/deletion.
// Disadvantages of Linked List are more usage of memory, random access not allowed and not cache friendly.
public class SinglyLinkedList {

    Node head;

    public int size() {
        Node ref = head;
        int len = 0;
        while (ref != null) {
            len++;
            ref = ref.next;
        }

        return len;
    }

    public int length(Node node) {
        if (node == null) {
            return 0;
        }

        return 1 + length(node.next);
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void append(int data) {

        if (head == null) {
            head = new Node(data);
        }
        else {
            Node node = new Node(data);
            Node ref = head;
            while (ref.next != null) {
                ref = ref.next;
            }
            ref.next = node;
        }
    }

    public void insertAtFront(int data) {

        if (head == null) {
            head = new Node(data);
        }
        else {
            Node node = new Node(data);
            node.next = head;
            head = node;
        }
    }

    public void insertAtPosition(int position, int data) {
        if (position <= 0) {
            throw new RuntimeException("Position can't be less than or equal to 0!");
        }

        int listSize = size() + 1;
        if (position > listSize) {
            throw new RuntimeException("Invalid Position!");
        }

        if (head == null) {
            head = new Node(data);
            return;
        }

        if (position == 1) {
            insertAtFront(data);
            return;
        }

        Node ref = head;
        Node previous = null;
        int counter = 0;

        while (ref != null && counter != position-1) {
            previous = ref;
            ref = ref.next;
            counter++;
        }

        Node node = new Node(data);
        node.next = ref;
        previous.next = node;
    }

    public void delete(int position) {
        if (position <= 0) {
            throw new RuntimeException("Position can't be less than or equal to 0!");
        }

        int listSize = size();
        if (position > listSize) {
            throw new RuntimeException("Invalid Position!");
        }

        if (head == null) {
            throw new RuntimeException("Linked List is Empty!");
        }

        if (position == 1) {
            Node ref = head;
            head = ref.next;
            ref.next = null;
            ref = null;
            return;
        }

        Node ref = head;
        Node previous = null;
        int counter = 0;

        while (ref != null && counter != position-1) {
            previous = ref;
            ref = ref.next;
            counter++;
        }

        previous.next = ref.next;
        ref.next = null;
    }

    public void deleteByValue(int data) {
        Node ref = head;
        Node previous = null;

        while (ref != null && ref.data != data) {
            previous = ref;
            ref = ref.next;
        }

        if (ref == null) {
            System.out.println("The value doesn't exist in Linked List!");
            return;
        }

        if (previous == null) {
            head = ref.next;
            ref.next = null;
            ref = null;
            return;
        }

        previous.next = ref.next;
        ref.next = null;
    }

    // Time complexity - O(n)
    // Space complexity - O(1)
    public void reverseList() {
        Node previous = null;
        Node ref = head.next;
        Node current = head;

        while (current.next != null) {
            current.next = previous;
            previous = current;
            current = ref;
            if (ref != null) {
                ref = ref.next;
            }
            if (current.next == null) {
                current.next = previous;
                head = current;
                break;
            }
        }
    }

    public void printList() {
        Node ref = head;
        while (ref != null) {
            System.out.print(ref.data + " ");
            ref = ref.next;
        }
    }

    public static void main(String[] args) {

        SinglyLinkedList linkedList = new SinglyLinkedList();

        System.out.println("Is linked list empty ? " + linkedList.isEmpty());

        linkedList.append(12);
        linkedList.append(34);
        linkedList.append(8);
        linkedList.append(90);

        linkedList.printList();

        System.out.println();

        linkedList.insertAtFront(56);
        linkedList.printList();

        System.out.println("Size of the linked list = " + linkedList.size());

        System.out.println("Is linked list empty ? " + linkedList.isEmpty());

        linkedList.insertAtPosition(5, 100);
        linkedList.printList();

        System.out.println();

        linkedList.delete(3);
        linkedList.printList();

        System.out.println();

        linkedList.deleteByValue(101);
        linkedList.printList();

        System.out.println("length of linked list is : " + linkedList.length(linkedList.head));

        linkedList.reverseList();
        linkedList.printList();
    }
}

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        next = null;
    }
}