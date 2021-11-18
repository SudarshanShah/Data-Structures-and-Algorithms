package com.java.dsa.arrays.practise;

import java.util.HashSet;

public class DistinctPairs {


        // Function to return the number
        // of unique pairs in the array
        static int countUnique(int arr[])
        {
            if(arr.length==0 || arr.length==1 || arr==null) {
                return 0;
            }

            HashSet<Integer> s = new HashSet<>();
            for (int i = 0; i < arr.length; i++)
            {
                s.add(arr[i]);
            }
            int count = (int) Math.pow(s.size(), 2);

            return count%(10^9+7);
        }

        // Driver code
        public static void main(String[] args) {
            int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
            System.out.println(countUnique(arr));
        }
}


