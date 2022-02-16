package com.example.teht2_2;

public class Counter2 {
    private int value;
    private int max;
    private int min;
    private int d;
    private int step;


    public Counter2(int d, int max, int min, int step){
        this.d = d;
        this.max = max;
        this.min = min;
        this.step = step;
        this.value = d;

    }
    public void getPlus() {
        if(value < max)
            value += step;
    }
    public void getMinus() {
        if(value > min)
            value -= step;
    }
    public void getReset() {
        value = 0;
    }

    public int getValue() {
        return this.value;
    }
}

