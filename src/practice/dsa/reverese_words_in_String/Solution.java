package practice.dsa.reverese_words_in_String;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Solution {
  /**
     * 151. Reverse Words in a String
     * <p>
     * Given an input string s, reverse the order of the words.
     * A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
     * <p>
     * Return a string of the words in reverse order concatenated by a single space.
     * <p>
     * Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.
     * <p>
     * Example 1:
     * Input: s = "the sky is blue"
     * Output: "blue is sky the"
     * <p>
     * Example 2:
     * Input: s = "  hello world  "
     * Output: "world hello"
     * Explanation: Your reversed string should not contain leading or trailing spaces.
     * <p>
     * Example 3:
     * Input: s = "a good   example"
     * Output: "example good a"
     * Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
     * <p>
     * */

    public String reverseWords(String s) {
        String [] words=s.split(" ");

        int p1=0, p2=words.length-1;

        while(p1<p2){
            String temp=words[p1];
            words[p1]=words[p2];
            words[p2]=temp;
            p1++; p2--;
        }

        StringBuilder sb=new StringBuilder();
       for(String word:words){
           if(word.isEmpty()){
               continue;
           }
           sb.append(word);
           sb.append(" ");
       }

       return sb.toString().trim();

     }
}
