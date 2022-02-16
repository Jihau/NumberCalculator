package com.example.teht2_2;

public class Counter {
    private static int value = 0;

    public Counter(){

    }
    public static void getPlus(){
        value++;
    }
    public static void getMinus(){
        value--;
    }
    public static void getReset(){
        value = 0;
    }
}
