package com.company;

public class Minus extends Term {
    public Minus(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int calculate() {
        return left.calculate() - right.calculate();
    }
}
