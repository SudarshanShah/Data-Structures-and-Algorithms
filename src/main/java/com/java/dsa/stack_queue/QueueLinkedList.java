package com.java.dsa.stack_queue;

public class QueueLinkedList {

    Node front, rear;

    private static class Node {
        String item;
        Node next;

        Node(String item) {
            this.item = item;
            next = null;
        }
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void enqueue(String item) {

        if (isEmpty()) {
            front = new Node(item);
            rear = front;
            return;
        }

        Node node = new Node(item);
        rear.next = node;
        rear = node;
    }

    public String dequeue() {

        if (isEmpty()) {
            return "Queue is Empty!";
        }

        Node ref = front;
        front = front.next;
        String item = ref.item;
        ref.next = null;

        return item;
    }

    public static void main(String[] args) {

        QueueLinkedList queueLinkedList = new QueueLinkedList();
        queueLinkedList.enqueue("Mumbai");
        queueLinkedList.enqueue("Bangalore");
        queueLinkedList.enqueue("Jodhpur");
        queueLinkedList.enqueue("Hyderabad");

        System.out.println(queueLinkedList.dequeue());
        System.out.println(queueLinkedList.dequeue());
        System.out.println(queueLinkedList.dequeue());
        System.out.println(queueLinkedList.dequeue());
        System.out.println(queueLinkedList.dequeue());
    }
}
