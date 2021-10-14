package com.java.dsa.strings;

public class Palindrome {

    public static boolean isPalindrome(String str) {

        boolean flag = true;
        for (int i = 0, j = str.length()-1; i < str.length() && j >= 0; i++, j--) {
            char c1 = str.charAt(i);
            char c2 = str.charAt(j);

            if (c1 != c2) {
                flag = false;
                break;
            }
        }

        return flag;
    }

    public static void main(String[] args) {

        System.out.println(Palindrome.isPalindrome("malayalam"));
        System.out.println(Palindrome.isPalindrome("rover"));
        System.out.println(Palindrome.isPalindrome("wasitacaroracatisaw"));
    }
}
