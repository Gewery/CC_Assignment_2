package com.company;

public class Greater extends Relation {

    public Greater(Expression left, Expression right) {
        super(left,right);
    }

    @Override
    public int calculate() {
        return left.calculate() > right.calculate() ? 1 : 0;
    }

}
