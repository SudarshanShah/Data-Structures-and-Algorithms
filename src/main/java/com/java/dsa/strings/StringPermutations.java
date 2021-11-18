package com.java.dsa.strings;

import java.util.ArrayList;
import java.util.List;

public class StringPermutations {

    public static List<String> getPermutations(String string) {

        List<String> permutations = new ArrayList<>();
        StringBuilder sb;
        StringBuilder sbr;

        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            sb = new StringBuilder(string);
            sb = sb.deleteCharAt(i);
            String str = sb.toString();
            for (int j = 0; j < string.length(); j++) {
                sbr = new StringBuilder(str.substring(0, j) + c + str.substring(j, string.length()-1));
                if(!permutations.contains(sbr.toString())) {
                    permutations.add(sbr.toString());
                }
                sb = sbr;
                sb.reverse();
                if (!permutations.contains(sb.toString())) {
                    permutations.add(sb.toString());
                }
            }
        }

        return permutations;
    }

    public static void main(String[] args) {

        int[] a = {4, 5, 3, 6, 1, 2, 9, 8, 7};
        System.out.println(StringPermutations.getPermutations("453612987"));
    }
}
