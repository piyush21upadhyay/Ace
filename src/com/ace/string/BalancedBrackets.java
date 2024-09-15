package com.ace.string;

import java.util.Stack;

public class BalancedBrackets {
    public static void main(String[] args) {
        String input = "{[()]}";
        System.out.println("Is the string balanced? " + isBalanced(input));
    }

    private static boolean isBalanced(String input) {
        Stack<Character> stack = new Stack<>();
        for(Character currentChar: input.toCharArray()){
            // If it's an opening bracket, push onto the stack
            if(currentChar=='(' || currentChar=='{' || currentChar=='['){
                stack.push(currentChar);
            } else if (currentChar==')' || currentChar=='}' || currentChar==']') {
                // If it's a closing bracket, check if it matches the top of the stack
                if(stack.isEmpty()){
                    return false;
                }
                char top = stack.pop();
                if(!isMatchingPair(top, currentChar)){
                    return false;
                    
                }

            }
        }
        // If the stack is empty at the end, it's balanced
        return stack.isEmpty();
    }

    private static boolean isMatchingPair(char opening, char closing) {
        return (opening=='{' && closing == '}')
                || (opening=='(' && closing == ')')
                || (opening=='[' && closing == ']');
    }
}
