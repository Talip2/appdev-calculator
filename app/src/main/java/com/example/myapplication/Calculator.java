package com.example.myapplication;

import java.util.Stack;

public class Calculator {
    private String equation;
    private Stack<Integer> stack;

    char c;
    int n = 0;
    public Calculator(String equation) {
        this.equation = equation;
    }

    public int Calculate() {
        String equ = this.equation;
        stack = new Stack<>();
        for (int i = 0; i < equ.length()-1; i++) {
             c = equ.charAt(i);

            if (Character.isDigit(c)){
                System.out.println("wala ing sud " + c);
                stack.push(c - '0');

            }

            else {
                n++;
                System.out.println("passes: " + n);
                int val1 = stack.pop();
                int val2 = stack.pop();
                System.out.println(val1  + " " + " " +  val2);



                switch (c) {
                    case '+':
                        stack.push(val2 + val1);
                        break;
                    case '-':
                        stack.push(val2 - val1);
                        break;
                    case '÷':
                        stack.push(val2 / val1);
                        break;
                    case '×':
                        stack.push(val2 * val1);
                        break;
                }
            }
        }
        return stack.pop();
    }
}
