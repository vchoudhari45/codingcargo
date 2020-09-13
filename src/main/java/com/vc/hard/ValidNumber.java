package com.vc.hard;

class ValidNumber {
    private final int INITIAL = 0;
    private final int DIGIT = 1;
    private final int DOT = 2;
    private final int OPERATOR = 3;
    private final int EXPR = 4;

    private final int DIGIT_AFTER_DOT = 5;
    private final int DIGIT_AFTER_EXPR = 6;
    private final int OPERATOR_AFTER_EXPR = 7;
    private int state = INITIAL;

    public boolean isNumber(String s) {

        s = s.trim();

        //if(s.equals(".") || s.equals("-") || s.equals("+") || s.equals("e")) return false;

        boolean seenDigit = false;

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            //System.out.println("State is : "+decodeState(state)+" ch: "+ch);

            if(ch == ' ') return false;

            if(isDigit(ch)) {
                seenDigit = true;
                if(isNotForDigitState()) return false;
                else {
                    if(state == DOT || state == DIGIT_AFTER_DOT) state = DIGIT_AFTER_DOT;
                    else if(state == EXPR || state == DIGIT_AFTER_EXPR) state = DIGIT_AFTER_EXPR;
                    else if(state == OPERATOR_AFTER_EXPR) state = DIGIT_AFTER_EXPR;
                    else state = DIGIT;
                }
            }

            else if(isDot(ch)){
                if(isNotForDotState()) return false;
                else state = DOT;
            }


            else if(isOperator(ch)) {
                if(isNotForOperator()) return false;
                else {
                    if(state == INITIAL) state = OPERATOR;
                    else state = OPERATOR_AFTER_EXPR;
                }
            }

            else if(isExpr(ch)) {
                if(isNotForExpr()) return false;
                else if(state == DOT && !seenDigit) return false;
                else state = EXPR;
            }

            else return false;
        }

        //System.out.println("State is : "+decodeState(state));
        return (state == DIGIT || state == DOT || state == DIGIT_AFTER_DOT || state == DIGIT_AFTER_EXPR) && seenDigit;
    }

    private String decodeState(int state) {
        if(state == INITIAL) return "INITIAL";
        else if(state == DIGIT) return "DIGIT";
        else if(state == DOT) return "DOT";
        else if(state == OPERATOR) return "OPERATOR";
        else if(state == EXPR) return "EXPR";
        else if(state == DIGIT_AFTER_DOT) return "DIGIT_AFTER_DOT";
        else if(state == DIGIT_AFTER_EXPR) return "DIGIT_AFTER_EXPR";
        else if(state == OPERATOR_AFTER_EXPR) return "OPERATOR_AFTER_EXPR";
        else return "INVALID";
    }

    private boolean isNotForExpr() {
        return state != DIGIT && state != DIGIT_AFTER_DOT && state != DOT;
    }

    private boolean isNotForOperator() {
        return state != INITIAL && state != EXPR;
    }

    private boolean isNotForDotState() {
        return state != INITIAL && state != DIGIT && state != OPERATOR;
    }

    private boolean isNotForDigitState() {
        return state != INITIAL && state != DIGIT && state != DIGIT_AFTER_DOT
                && state != DIGIT_AFTER_EXPR && state != OPERATOR && state != DOT && state != EXPR
                && state != OPERATOR_AFTER_EXPR;
    }

    private boolean isDigit(char ch) {
        return Character.isDigit(ch);
    }

    private boolean isDot(char ch) {
        return ch == '.';
    }

    private boolean isOperator(char ch) {
        return ch == '+' || ch == '-';
    }

    private boolean isExpr(char ch) {
        return ch == 'e';
    }
}
