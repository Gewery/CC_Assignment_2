package com.company;

public class Paranthesized extends Primary {
    private Expression expression;

    @Override
    public int calculate() {
        return expression.calculate();
    }
}
