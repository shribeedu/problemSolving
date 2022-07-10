package com.shri.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class ValidParanthesis {

    public static void main(String args[]) {

        String str;
        boolean isValid;
        System.out.println("Enter the String");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            str = br.readLine();
            isValid = isParanthValid(str);
            if (isValid)
                System.out.println("Entered String is valid");
            else
                System.out.println("Entered String is not valid");

        } catch (IOException ioE) {

        }


    }

    private  static boolean isMachingPair(Character ch1 ,Character ch2){
        if(ch1 == '(' && ch2 == ')')
            return true;
        else if(ch1 =='{' && ch2 == '}')
            return true;
        else if(ch1 == '[' && ch2 == ']')
            return true;
        return  false;
    }

    private static boolean isParanthValid(String str) {

        Character ch;
        Stack<Character> stack = new Stack<Character>();
        for(int i=0;i<str.length();i++){
             ch=str.charAt(i);
             if(ch =='{' || ch == '(' || ch=='['){
                 stack.push(ch);
             }else if(ch =='}' || ch == ')' || ch==']'){
                 if(stack.isEmpty())
                     return false;
                 else if(!isMachingPair(stack.pop(),ch)){
                     return  false;
                 }

             }
        }

        return stack.isEmpty();

    }
}
