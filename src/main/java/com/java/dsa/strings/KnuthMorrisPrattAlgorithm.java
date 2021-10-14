package com.java.dsa.strings;

import java.util.Arrays;

public class KnuthMorrisPrattAlgorithm {

    // Implementation of KMP Pattern Search Algorithm
    public boolean isSubstring(String string, String subString) {

        // get prefix array
        int[] prefix = prefixArray(subString);
        boolean flag = false;

        for (int i = 0, j = 0; i < string.length() && i >= 0 && j < subString.length(); i++) {

            char c1 = string.charAt(i);
            char c2 = subString.charAt(j);

            // if characters are not equal
            if (c1 != c2) {
                flag = false;
                // if 'i' and 'j' reaches at their last index, we terminate the loop as no further
                // matching can be done.
                if (i == string.length()-1 && j == subString.length()-1) {
                    break;
                }
                // if only 'j' reaches last index, we set 'j' value by
                // decrementing it, and getting actual value by passing it to index of prefix array.
                if (j == subString.length()-1) {
                    j = prefix[--j];
                    // if characters match, set 'flag' to true and continue loop.
                    if (c1 == subString.charAt(j)) {
                        flag = true;
                    }
                    else {
                        // increment 'j' if not match
                        j++;
                    }
                }
                else {
                    // if 'j' not reaches last index, assign value of 'j' by passing its current value as index of
                    // prefix array to get the actual value;
                    j = prefix[j];
                }
            }
            else {
                // if match found, just increment 'j' and set 'flag' to true.
                j++;
                flag = true;
            }
        }

        return flag;
    }

    // method to construct prefix array for subString
    private int[] prefixArray(String subString) {

        int[] prefix = new int[subString.length()];
        // first element will always be 0.
        prefix[0] = 0;

        for (int i = 1, j = 0; i < subString.length() && j < i && j >= 0; i++) {
            char c1 = subString.charAt(i);
            char c2 = subString.charAt(j);

            // if character are equal, we write indexOf 'j' + 1 in the current index of prefix array, i.e., 'i'
            if (c1 == c2) {
                prefix[i] = j+1;
                j++;
            }

            else {
                boolean flag = false;
                // we get value of 'j' by decrementing it by 1, and assigning the value at corresponding
                // 'j' value index of prefix array.
                if (--j >= 0) {
                    flag = true;
                    j = prefix[j];
                }
                // if character are equal, we write indexOf 'j' + 1 in the current index of prefix array, i.e., 'i'
                if (j >= 0 && c1 == subString.charAt(j)) {
                    prefix[i] = j+1;
                    j++;
                }
                else {
                    // if 'i' reaches end, then we continue to put 'i' at there and decrement 'j' till its 0.
                    if (i == subString.length()-1 && j == 0) {
                        j = -1;
                        i--;
                    }
                    // if 'i' at some index other than last, then we assign value at current index of
                    // prefix array as 0.
                    else {
                        prefix[i] = 0;
                    }
                }
                // if 'j' is less than zero, increment it to 0.
                if (!flag) {
                    j++;
                }
            }
        }

        System.out.println("prefix array is : " + Arrays.toString(prefix));

        return prefix;
    }

    public static void main(String[] args) {

        System.out.println(new KnuthMorrisPrattAlgorithm()
                .isSubstring("THIS IS A TEST TEXT", "TEST"));
    }
}
