package com.java.dsa.arrays;

import java.util.Arrays;
import java.util.Objects;

/*
* All arrays in Java are dynamically allocated
* Arrays are objects in Java
* Direct superclass of an array type is Object
* Every array type implements the interfaces Cloneable and Serializable
* */
public class ArrayLearn {

    public static void main(String[] args) {

        SingleDimensionalArray singleDimensionalArray = new SingleDimensionalArray();
        singleDimensionalArray.printArray();

        System.out.println();

        StudentArray studentArray = new StudentArray();
        studentArray.addIntoStudentArray();
        studentArray.printArray();

        MultiDimensionalArray multiDimensionalArray = new MultiDimensionalArray();
        multiDimensionalArray.printArray();
    }
}


class SingleDimensionalArray {

    int[] arr = new int[5];

    public SingleDimensionalArray() {
        arr[0] = 10;
        arr[1] = 43;
        arr[2] = 50;
        arr[3] = 61;
        arr[4] = 87;
    }

    public void printArray() {
        System.out.println("Printing Single Dimensional Array : ");
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }
}

class StudentArray {

    int rollNo;
    String name;
    StudentArray[] studentArrays = new StudentArray[5];

    public StudentArray() {}

    public StudentArray(int rollNo, String name) {
        this.rollNo = rollNo;
        this.name = name;
    }

    public void addIntoStudentArray() {
        studentArrays[0] = new StudentArray(1, "Sudarshan");
        studentArrays[1] = new StudentArray(2, "Ajay");
        studentArrays[2] = new StudentArray(3, "Harry");
        studentArrays[3] = new StudentArray(4, "Navin");
        studentArrays[4] = new StudentArray(5, "Abhishek");
    }

    public void printArray() {
        System.out.println("Printing Array of Objects : ");
        for (StudentArray s : studentArrays) {
            System.out.println(s.rollNo + " " + s.name);
        }
    }
}

class MultiDimensionalArray {

    int[][] arr = { {2, 4, 7}, {3, 9, 1}, {5, 6, 8} };

    public void printArray() {
        System.out.println("Printing Multidimensional Array : ");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}