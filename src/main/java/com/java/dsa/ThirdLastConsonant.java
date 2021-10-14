package com.java.dsa;

import java.util.HashSet;
import java.util.Set;

public class ThirdLastConsonant {

    public static char findThirdLastConsonant(String str) {

        Set<Character>set = new HashSet<>();
        set.add('A');
        set.add('I');
        set.add('O');
        set.add('U');
        set.add('E');
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        int count = 0;
        char thirdLastConsonant = 0;
        for (int i = str.length()-1; i >= 0; i--) {
            char c = str.charAt(i);
            if (!set.contains(c)) {
                count++;
            }
            if (count==3) {
                thirdLastConsonant = c;
                break;
            }
        }

        return thirdLastConsonant;
    }

    public static void main(String[] args) {

        System.out.println(ThirdLastConsonant.findThirdLastConsonant("asdfguihj"));
    }
}
