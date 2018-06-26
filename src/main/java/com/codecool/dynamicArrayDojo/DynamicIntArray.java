package com.codecool.dynamicArrayDojo;

import java.util.stream.IntStream;

public class DynamicIntArray {

    private int size;
    private int[] arr;

    DynamicIntArray() {
        this.size = 0;
        this.arr = new int[0];
    }

    DynamicIntArray(int size) {
        this.size = size;
        this.arr = new int[size];
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) sb.append(" ").append(String.valueOf(arr[i]));
        return sb.toString();
    }

    public void add(int number) {
        this.size += 1;
        int[] newArray = new int[size];
        System.arraycopy(arr, 0, newArray, 0, arr.length);
        newArray[size - 1] = number;
        this.arr = newArray;
    }

    public void remove(int number) throws ArrayIndexOutOfBoundsException {
        boolean contains = IntStream.of(arr).anyMatch(num -> num == number);

        if (contains) {
            for (int i = 0; i < size; i++) {
                if (arr[i] == number) {
                    this.size--;
                    int[] newArray = new int[size];
                    System.arraycopy(arr, 0, newArray, 0, i);
                    System.arraycopy(arr, i + 1, newArray, i, size - i);
                    this.arr = newArray;
                }
            }
        } else {
            throw ArrayIndexOutOfBoundsException;
        }
    }

    public void insert(int index, int number) {

    }
}

