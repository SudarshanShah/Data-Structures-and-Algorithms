package com.java.dsa.strings;

import java.util.Arrays;

public class Anagram {

    public static boolean isAnagram(String str1, String str2) {

        if (str1.length() != str2.length()) {
            return false;
        }

        if (str1.equals(str2)) {
            return true;
        }

        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();

        Arrays.sort(ch1);
        Arrays.sort(ch2);

        int compare = Arrays.compare(ch1, ch2);

        if (compare == 0) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {

        System.out.println(Anagram.isAnagram("Tar", "raT"));
        System.out.println(Anagram.isAnagram("Night", "Thing"));
    }
}
