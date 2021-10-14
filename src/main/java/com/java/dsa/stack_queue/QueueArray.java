package com.java.dsa.stack_queue;

public class QueueArray {

    private String[] arr;
    private int front = 0;
    private int rear = 0;

    public QueueArray() {
        int initialCapacity = 5;
        arr = new String[initialCapacity];
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public void enqueue(String item) {

        if (rear == arr.length) {
            resizeArray(2 * arr.length);
        }
        arr[rear++] = item;
    }

    private void resizeArray(int capacity) {

        String[] str = new String[capacity];
        System.out.println("capacity=" + capacity);
        System.out.println("front="+ front);
        for (int i = 0, j = front; i < rear-front && j < rear; i++, j++) {
            str[i] = arr[j];
        }

        arr = str;
    }

    public String dequeue() {

        if (front == rear || arr[front] == null) {
            return "Queue is empty!";
        }

        String item  = arr[front++];
        arr[front-1] = null;
        System.out.println("front in dequeue=" + front);
        if (front > 0 && front == (arr.length/4)+1) {
            resizeArray((arr.length/2)+1);
            front = 0;
            rear = arr.length;
        }

        return item;
    }

    public static void main(String[] args) {

        QueueArray queueArray = new QueueArray();
        queueArray.enqueue("Chennai");
        queueArray.enqueue("Kolkata");
        queueArray.enqueue("Surat");
        queueArray.enqueue("Bhubaneswar");

        System.out.println(queueArray.dequeue());
        System.out.println(queueArray.dequeue());
        System.out.println(queueArray.dequeue());
        System.out.println(queueArray.dequeue());
        System.out.println(queueArray.dequeue());
    }
}
