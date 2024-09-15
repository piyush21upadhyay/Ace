package com.ace.stacks;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/*You are given a string s, which contains stars *.
In one operation, you can:

1) Choose a star in s.
2) Remove the closest non-star character to its left, as well as remove the star itself.
Return the string after all stars have been removed.

Note:
The input will be generated such that the operation is always possible.
It can be shown that the resulting string will always be unique.

Example 1:
Input: s = "leet**cod*e"
Output: "lecoe"
Explanation: Performing the removals from left to right:
        - The closest character to the 1st star is 't' in "leet**cod*e". s becomes "lee*cod*e".
        - The closest character to the 2nd star is 'e' in "lee*cod*e". s becomes "lecod*e".
        - The closest character to the 3rd star is 'd' in "lecod*e". s becomes "lecoe".
There are no more stars, so we return "lecoe".
*/
public class RemoveStarsFromString {
    public static void main(String[] args) {
        //using Stack
        String str = "leet**cod*e";
        Stack<Character> stack = new Stack<>();
        for(char c: str.toCharArray()){
            if(c=='*'){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }else{
                stack.push(c);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for(Character c: stack){
            stringBuilder.append(c);
        }
        //stack.forEach(stringBuilder::append);
        System.out.println("using stack::"+stringBuilder.toString());

        //using Deque
        Deque<Character> deque = new ArrayDeque<>();
        str = "leet**cod*e";
        str.chars().forEach(c -> {
            if(c == '*'){
                if(!deque.isEmpty()){
                    deque.pollLast();
                }
            }else{
                deque.addLast((char) c);
            }
        });
        StringBuilder result = new StringBuilder();
        deque.forEach(result::append);

        System.out.println("using deque::"+result.toString());
    }
}
