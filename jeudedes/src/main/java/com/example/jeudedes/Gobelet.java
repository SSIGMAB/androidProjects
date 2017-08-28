package com.example.jeudedes;

public class Gobelet {
    private De de1, de2;

    public Gobelet() {
        de1 = new De();
        de2 = new De();
    }

    public void lancer(){
        de1.lancer();
        de2.lancer();
    }

    public int getScore(){
        return de1.getValue() + de2.getValue();
    }

    public De getD1() {
        return de1;
    }

    public void setD1(De de1) {
        this.de1 = de1;
    }

    public De getD2() {
        return de2;
    }

    public void setD2(De de2) {
        this.de2 = de2;
    }
}
