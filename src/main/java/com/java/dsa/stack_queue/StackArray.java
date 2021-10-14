package com.java.dsa.stack_queue;

// Time Complexity -> push, pop - worst-case -> O(N)
public class StackArray {

    private String[] strings;
    private int n = 0;

    public StackArray() {
        int initialCapacity = 5;
        strings = new String[initialCapacity];
    }

    public void push(String item) {
        if (n == strings.length) {
            resizeArray(2 * strings.length);
        }

        strings[n++] = item;
    }

    private void resizeArray(int capacity) {

        String[] str = new String[capacity];
        if (n >= 0) System.arraycopy(strings, 0, str, 0, n);

        strings = str;
    }

    public String pop() {
        if (n == 0) {
            return "Stack is Empty!";
        }

        String item = strings[--n];
        strings[n] = null;

        if (n > 0 && n == strings.length/4) {
            resizeArray(strings.length/2);
        }

        return item;
    }

    public static void main(String[] args) {

        StackArray stackArray = new StackArray();
        stackArray.push("Alpha");
        stackArray.push("Beta");
        stackArray.push("Gamma");
        stackArray.push("Theta");
        stackArray.push("Delta");

        System.out.println(stackArray.pop());
        System.out.println(stackArray.pop());
        System.out.println(stackArray.pop());
        System.out.println(stackArray.pop());
        System.out.println(stackArray.pop());
    }
}
