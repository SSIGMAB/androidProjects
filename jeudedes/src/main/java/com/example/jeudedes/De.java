package com.example.jeudedes;

import java.util.Random;

public class De {
    private int value;
    private Random random;

    public De() {
        random = new Random();
    }

    public void lancer(){
        value = random.nextInt(6)+1;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
