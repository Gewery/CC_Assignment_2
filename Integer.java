package com.company;

public class Integer extends Primary {
    private int value;

    public Integer(int value) {
        this.value = value;
    }

    @Override
    public int calculate() {
        return value;
    }
}
