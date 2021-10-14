package com.java.dsa.linked_lists;

public class DoublyLinkedList {

    DNode head;

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        DNode ref = head;
        int len = 0;
        if (head == null) {
            return len;
        }
        while (ref != null) {
            len++;
            ref = ref.next;
        }

        return len;
    }

    public void append(int data) {

        if (head == null) {
            head = new DNode(data);
            return;
        }

        DNode node = new DNode(data);
        DNode ref = head;
        DNode prev = null;

        while (ref != null) {
            prev = ref;
            ref = ref.next;
        }

        prev.next = node;
        node.previous = prev;
    }

    public void insertAtFront(int data) {

        if (head == null) {
            head = new DNode(data);
            return;
        }

        DNode node = new DNode(data);
        node.next = head;
        head.previous = node;
        head = node;
    }

    public void insertAt(int position, int data) {

        if (head == null) {
            head = new DNode(data);
            System.out.println("List is empty...so Node created at 1st Position!");
            return;
        }

        if (position < 1 || position > size()) {
            System.out.println("Invalid Position!");
            return;
        }

        DNode ref = head;
        while (position-- != 1 && ref != null) {
            ref = ref.next;
        }

        DNode node = new DNode(data);
        node.next = ref;
        node.previous = ref.previous;
        ref.previous.next = node;
        ref.previous = node;
    }

    public void deleteAtPosition(int position) {

        if (head == null) {
            System.out.println("List is empty!");
            return;
        }

        if (position < 1 || position > size()) {
            System.out.println("Invalid Position!");
            return;
        }

        DNode ref = head;
        while (ref != null && position != 1) {
            ref = ref.next;
            position--;
        }

        ref.next.previous = ref.previous;
        ref.previous.next = ref.next;
        ref = null;
    }

    public void deleteByValue(int value) {

        if (head == null) {
            System.out.println("List is empty!");
            return;
        }

        DNode ref = head;
        while (ref != null && ref.data != value) {
            ref = ref.next;
        }

        if (ref == null) {
            System.out.println("Value Not Found!");
            return;
        }

        ref.next.previous = ref.previous;
        ref.previous.next = ref.next;
        ref = null;
    }

    public void reverseList() {

        DNode ref = head;
        while (ref != null) {
            if (ref.next == null) {
                break;
            }
            ref = ref.next;
        }

        while (ref != null) {
            System.out.print(ref.data + " ");
            ref = ref.previous;
        }
    }

    public void printList() {
        DNode ref = head;
        while (ref != null) {
            System.out.print(ref.data + " ");
            ref = ref.next;
        }
    }

    public static void main(String[] args) {

        DoublyLinkedList linkedList = new DoublyLinkedList();

        System.out.println("Is List empty ? " + linkedList.isEmpty());
        System.out.println("Size of List = " + linkedList.size());

        linkedList.append(23);
        linkedList.append(76);
        linkedList.append(41);
        linkedList.append(83);
        linkedList.append(10);
        linkedList.append(50);

        System.out.println("Original List : ");
        linkedList.printList();

        System.out.println();

        System.out.println("Reverse List : ");
        linkedList.reverseList();

        System.out.println();

        System.out.println("Is List empty ? " + linkedList.isEmpty());
        System.out.println("Size of List = " + linkedList.size());

        System.out.println();

        linkedList.insertAt(3, 96);
        System.out.println("List after insertion of 96 : ");
        linkedList.printList();

        System.out.println();

        System.out.println("Final List in Reverse Order : ");
        linkedList.reverseList();

        System.out.println();

        linkedList.insertAtFront(60);
        System.out.println("List after insertion of 60");
        linkedList.printList();

        System.out.println();

        System.out.println("Final List in Reverse Order : ");
        linkedList.reverseList();

        System.out.println();

        linkedList.deleteAtPosition(3);
        System.out.println("List after deleting element at position 3");
        linkedList.printList();

        System.out.println();

        System.out.println("Final List in Reverse Order : ");
        linkedList.reverseList();

        System.out.println();

        linkedList.deleteByValue(76);
        System.out.println("List after deleting 76 from list : ");
        linkedList.printList();

        System.out.println();

        System.out.println("Final List in Reverse Order : ");
        linkedList.reverseList();

        System.out.println();

        System.out.println("Final List in Reverse Order : ");
        linkedList.reverseList();

        System.out.println();
    }
}

class DNode {
    int data;
    DNode next, previous;

    public DNode(int data) {
        this.data = data;
        next = null;
        previous = null;
    }
}