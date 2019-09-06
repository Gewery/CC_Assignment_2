package com.company;

public class Equal extends Relation {

    public Equal(Expression left, Expression right) {
        super(left,right);
    }

    @Override
    public int calculate() {
        return left.calculate() == right.calculate() ? 1 : 0;
    }

}
