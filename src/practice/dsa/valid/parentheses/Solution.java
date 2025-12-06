package practice.dsa.valid.parentheses;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {

    public boolean isValid(String s) {
        Stack<Character> stk=new Stack<>();
        Map<Character,Character> openBracket=new HashMap<>();
        openBracket.put(')','(');
        openBracket.put('}','{');
        openBracket.put(']','[');

        for(char ch: s.toCharArray()){
            if(ch=='(' || ch=='{' || ch=='['){
                stk.push(ch);
            }
            else {
               if(!stk.isEmpty() && stk.peek()==openBracket.get(ch)){
                   stk.pop();
               }
               else {
                   return false;
               }
            }
        }
        return true;
    }
}
