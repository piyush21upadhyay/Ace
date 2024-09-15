package com.ace.array.easy;

public class LeftRotateArrayBy1 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        leftRotateArrayBy1(array);
    }

    private static void leftRotateArrayBy1(int[] array) {
        int[] temp = new int[array.length];
        for(int i=1; i<array.length; i++){
            temp[i-1]=array[i];
        }

        temp[array.length-1]=array[0];
        System.out.println("Array after left rotation by 1 is: ");
        for(int n : temp){
            System.out.println(n);
        }
    }

}
