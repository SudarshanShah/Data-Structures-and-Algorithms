package com.java.dsa;

public class StepGame {

    public static int minSteps(int step) {

        if (step == 0) {
            return 0;
        }

        if (step == 1) {
            return 1;
        }

        if (step % 2 == 0) {
            return 1 + minSteps(step/2);
        }

        return 1+ minSteps(step-1);
    }

    public static void main(String[] args) {

        System.out.println(StepGame.minSteps(10));
    }
}
