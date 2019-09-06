package com.company;

public class Main {

    public static void main(String[] args) {
        Parser par = new Parser();
        Expression exp = par.parse("(1*9+2-(55<22*6))*2+34*(1=(1=(1<4+(1>0))))");
        System.out.println(exp.calculate());
    }
}
