package com.java.dsa.stack_queue;

// Time complexity - O(1) -> for all operations
// Memory - 40 bytes per stack node
public class StackLinkedList {

    // 16 bytes -> object overhead
    Node top;

    // 8 bytes, Inner Class overhead
    private class Node {
        // 8 bytes, for string
        String item;
        //8 bytes for Node reference
        Node next;

        Node(String item) {
            this.item = item;
            next = null;
        }
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void push(String item) {

            Node node = new Node(item);
            node.next = top;
            top = node;
    }

    public String pop() {

        if (!isEmpty()) {
            String item = top.item;
            top = top.next;
            return item;
        }
        else {
            return "Stack is Empty!";
        }
    }

    public static void main(String[] args) {

        StackLinkedList stackLinkedList = new StackLinkedList();
        stackLinkedList.push("Spiderman");
        stackLinkedList.push("Eternals");
        stackLinkedList.push("Shang-Chi");
        stackLinkedList.push("Black Widow");

        System.out.println(stackLinkedList.pop());
        System.out.println(stackLinkedList.pop());
        System.out.println(stackLinkedList.pop());
        System.out.println(stackLinkedList.pop());
        System.out.println(stackLinkedList.pop());

    }
}
