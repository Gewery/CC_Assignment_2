package com.company;

import com.sun.javafx.applet.ExperimentalExtensions;

public class Parser {

    public Expression parse(String input) { return parseRelation(input); }

    private Expression parseRelation(String st) {
        int balance = 0;
        for (int i = 0; i < st.length(); i++) {
            if (st.charAt(i) == '(')
                balance++;
            else if (st.charAt(i) == ')')
                balance--;

            if (balance == 0 && (st.charAt(i) == '<' || st.charAt(i) == '>' || st.charAt(i) == '=')) {
                if (st.charAt(i) == '<') {
                    return new Less(parseTerm(st.substring(0, i)), parseTerm(st.substring(i + 1)));
                }
                else if (st.charAt(i) == '>')
                    return new Greater(parseTerm(st.substring(0, i)), parseTerm(st.substring(i + 1)));
                else if (st.charAt(i) == '=')
                    return new Equal(parseTerm(st.substring(0, i)), parseTerm(st.substring(i + 1)));
                else
                    System.out.println("ERROR. ParseRelation");
            }
        }
        return parseTerm(st);
    }

    private Expression parseTerm(String st) {
        int balance = 0;
        for (int i = 0; i < st.length(); i++) {
            if (st.charAt(i) == '(')
                balance++;
            else if (st.charAt(i) == ')')
                balance--;

            if (balance == 0 && (st.charAt(i) == '+' || st.charAt(i) == '-')) {
                if (st.charAt(i) == '+')
                    return new Plus(parseFactor(st.substring(0, i)), parseTerm(st.substring(i + 1)));
                else if (st.charAt(i) == '-')
                    return new Minus(parseFactor(st.substring(0, i)), parseTerm(st.substring(i + 1)));
                else
                    System.out.println("ERROR. ParseTerm");
            }
        }
        return parseFactor(st);
    }

    private Expression parseFactor(String st) {
        int balance = 0;
        for (int i = 0; i < st.length(); i++) {
            if (st.charAt(i) == '(')
                balance++;
            else if (st.charAt(i) == ')')
                balance--;

            if (balance == 0 && st.charAt(i) == '*')
                return new Multiply(parsePrimary(st.substring(0, i)), parseFactor(st.substring(i + 1)));
        }
        return parsePrimary(st);
    }

    private Expression parsePrimary(String st) {
        if (st.charAt(0) == '(' && st.charAt(st.length() - 1) == ')')
            return parse(st.substring(1, st.length() - 1));
        else {
            int value = 0;
            for (int i = 0; i < st.length(); i++) {
                value *= 10;
                value += st.charAt(i) - '0';
            }
            return new Integer(value);
        }
    }

}
