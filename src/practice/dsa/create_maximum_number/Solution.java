package practice.dsa.create_maximum_number;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    private boolean isChar(char ch){
      return   Character.isDigit(ch) || Character.isAlphabetic(ch);
    }


    private boolean isEqual(char a, char b){

        if(Character.isDigit(a) || Character.isDigit(b)){
            return a==b;
        }
       return Character.toString(a).equalsIgnoreCase(Character.toString(b));

    }
    public boolean isPalindrome(String s) {

        int n=s.length();
        int p1=0, p2=n-1;

        while(p1<p2){

            while(p1<p2 && !isChar(s.charAt(p1))){
                p1++;
            }

            while(p1<p2 && !isChar(s.charAt(p2))){
                p2--;
            }

            if(!isEqual(s.charAt(p1),s.charAt(p2))){

                return false;
            }

            p1++; p2--;
        }

        return true;

    }
}
