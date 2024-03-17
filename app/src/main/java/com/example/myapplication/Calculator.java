package com.example.myapplication;

import java.util.Stack;

public class Calculator {
    private String equation;
    private static final String operators = "-+÷×";
    private static final String operands = "0123456789.";

    public Calculator(String equation) {
        this.equation = equation.replaceAll("\\s+", "");
    }

    public String convert2Postfix() {
        StringBuilder infixExpr = new StringBuilder(this.equation);
        infixExpr.insert(0, "(").append(")");
        infixExpr = new StringBuilder(infixExpr.toString().replaceAll("(?<=[0-9])\\.", "."));
        char[] chars = infixExpr.toString().toCharArray();
        Stack<Character> stack = new Stack<>();
        StringBuilder out = new StringBuilder();

        for (char c : chars) {
            if (Character.isDigit(c) || c == '.') {
                out.append(c);
            } else if (isOperator(c)) {
                out.append(' ');
                while (!stack.isEmpty() && stack.peek() != '(' && operatorGreaterOrEqual(stack.peek(), c)) {
                    out.append(stack.pop()).append(' ');
                }
                stack.push(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    out.append(' ').append(stack.pop());
                }
                stack.pop();
            }
        }
        return out.toString().trim();
    }




    public Double Calculate() {
        String postfixExpr = convert2Postfix();
        Stack<Double> stack = new Stack<>();

        for (int i = 0; i < postfixExpr.length(); i++) {
            char token = postfixExpr.charAt(i);
            if (isOperand(token)) {
                StringBuilder operand = new StringBuilder();
                while (i < postfixExpr.length() && (isOperand(postfixExpr.charAt(i)) || postfixExpr.charAt(i) == '.')) {
                    operand.append(postfixExpr.charAt(i++));
                }

                stack.push(Double.parseDouble(operand.toString()));
            } else if (isOperator(token)) {
                double op1 = stack.pop();
                double op2 = stack.pop();
                double result;
                switch (token) {
                    case '×':
                        result = op1 * op2;
                        stack.push(result);
                        break;
                    case '÷':
                        if (op1 == 0) {
                            throw new ArithmeticException("Division by zero");
                        }
                        result = op2 / op1;
                        stack.push(result);
                        break;
                    case '+':
                        result = op1 + op2;
                        stack.push(result);
                        break;
                    case '-':
                        result = op2 - op1;
                        stack.push(result);
                        break;
                }
            }
        }
        return stack.pop();
    }






    private int getPrecedence(char operator) {
        if (operator == '-' || operator == '+') {
            return 1;
        } else if (operator == '×' || operator == '÷') {
            return 2;
        } else {
            return 0;
        }
    }

    private boolean operatorGreaterOrEqual(char op1, char op2) {
        return getPrecedence(op1) > getPrecedence(op2);
    }

    private boolean isOperator(char val) {
        return operators.indexOf(val) != -1;
    }

    private boolean isOperand(char val) {
        return operands.indexOf(val) != -1 || val == '.';
    }

}
