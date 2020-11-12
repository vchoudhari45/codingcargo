package com.vc.hard;

import java.util.*;

class ParseLispExpression {
    public int evaluate(String expression) {
        HashMap<String, Integer> variables = new HashMap<>();
        return solve(expression, variables);
    }

    private int solve(String expression, HashMap<String, Integer> variables) {
        if(isNumber(expression)) return Integer.parseInt(expression);
        else if(isVariable(expression)) return variables.get(expression);

        List<String> list = parse(expression);
        if(list.get(0).equals("add")) {
            return solve(list.get(1), variables) + solve(list.get(2), variables);
        }
        else if(list.get(0).equals("mult")) {
            return solve(list.get(1), variables) * solve(list.get(2), variables);
        }
        else {
            HashMap<String, Integer> subVariables = new HashMap<>(variables);
            for(int i = 1; i < list.size() - 2; i += 2) {
                String variable = list.get(i);
                int value = solve(list.get(i + 1), subVariables);
                subVariables.put(variable, value);
            }
            return solve(list.get(list.size() - 1), subVariables);
        }
    }

    private List<String> parse(String expression) {
        int n = expression.length();
        StringBuilder str = new StringBuilder();
        List<String> list = new ArrayList<>();
        int countParen = 0;
        for(int i = 1; i < expression.length() - 1; i++) {
            char ch = expression.charAt(i);
            if(ch == ')') {
                str.append(")");
                countParen--;
            }
            else if(ch == '(') {
                str.append("(");
                countParen++;
            }
            else if(ch == ' ' && countParen == 0) {
                list.add(str.toString());
                str.setLength(0);
            }
            else str.append(ch);
        }
        if(str.length() > 0) list.add(str.toString());
        return list;
    }

    private boolean isNumber(String expression) {
        char ch = expression.charAt(0);
        return (ch >= '0' && ch <= '9') || ch == '-';
    }

    private boolean isVariable(String expression) {
        char ch = expression.charAt(0);
        return ch >= 'a' && ch <= 'z';
    }
}