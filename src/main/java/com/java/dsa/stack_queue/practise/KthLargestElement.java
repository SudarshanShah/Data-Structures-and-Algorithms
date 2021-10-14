package com.java.dsa.stack_queue.practise;

import java.util.PriorityQueue;

public class KthLargestElement {

    public static int getKthLargestElement(int[] arr, int KthLargest) {

        if (KthLargest > arr.length || KthLargest <= 0) {
            return -1;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (Integer i : arr) {
            pq.offer(i);
        }

        int element = 0;
        while (!pq.isEmpty()) {
            int e = pq.poll();
            if (element == arr.length-KthLargest) {
                element = e;
                break;
            }
            if (e != pq.peek()) {
                element++;
            }
        }

        return element;
    }

    public static void main(String[] args) {

        int[] arr = {4, 2, 7, 3, 1, 6};
        System.out.println(KthLargestElement.getKthLargestElement(arr, 1));
    }
}
