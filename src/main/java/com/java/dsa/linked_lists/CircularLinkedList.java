package com.java.dsa.linked_lists;

public class CircularLinkedList {

    CNode last;

    public boolean isEmpty() {
        return last == null;
    }

    public int size() {

        if (last == null) {
            return 0;
        }

        CNode ref = last;
        int size = 0;
        while (ref.next != last) {
            size++;
            ref = ref.next;
        }

        return size+1;
    }

    public void append(int data) {

        if(checkNullCondition(data)) {
            return;
        }

        CNode node = new CNode(data);
        node.next = last.next;
        last.next = node;
        last = node;
    }

    public void insertAtFront(int data) {

        if(checkNullCondition(data)) {
            return;
        }

        CNode node = new CNode(data);
        node.next = last.next;
        last.next = node;
    }

    public void insertAt(int position, int data) {

        if(checkNullCondition(data)) {
            return;
        }

        if (position < 1 || position > size()) {
            System.out.println("Invalid Position!");
            return;
        }

        CNode node = new CNode(data);
        if (position == 1) {
            insertAtFront(data);
            return;
        }
        if (position == size()) {
            append(data);
            return;
        }

        CNode ref = last;
        while (ref.next != last && position-- != 1) {
            ref = ref.next;
        }

        node.next = ref.next;
        ref.next = node;
    }

    private boolean checkNullCondition(int data) {
        if (last == null) {
            last = new CNode(data);
            last.next = last;
            return true;
        }

        return false;
    }

    public void printList() {

        CNode ref = last;
        while (ref.next != last) {
            System.out.print(ref.next.data + " ");
            ref = ref.next;
            if (ref.next == last) {
                System.out.print(ref.next.data + " ");
            }
        }
    }

    public static void main(String[] args) {

        CircularLinkedList circularLinkedList = new CircularLinkedList();

        System.out.println("Initial size = " + circularLinkedList.size());

        circularLinkedList.append(30);
        circularLinkedList.append(87);
        circularLinkedList.append(62);
        circularLinkedList.append(59);
        circularLinkedList.printList();

        System.out.println();

        circularLinkedList.insertAtFront(21);
        circularLinkedList.printList();
        System.out.println();
        System.out.println("Size of List is : " + circularLinkedList.size());

        System.out.println();

        circularLinkedList.insertAt(2, 40);
        circularLinkedList.printList();

    }
}

class CNode {

    int data;
    CNode next;

    public CNode(int data) {
        this.data = data;
        next = null;
    }
}