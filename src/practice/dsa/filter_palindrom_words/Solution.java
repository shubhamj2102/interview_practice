package practice.dsa.filter_palindrom_words;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Filter and return only palindrome words from a list.
 *
 * Requirements:
 *
 * 1.MUST use Java 8 streams.
 * 2. Solve in functional programming style. AVOID for/while loops and mutable variables.
 * 3.Don't use StringBuffer.
 *
 * Example:
 * Input: ["madam", "apple", "racecar"]
 * Output: ["madam", "racecar"]
 */
public class Solution {

    public List<String> filterPalindromeWords(List<String> words){
      var res=  words.stream().filter(str-> IntStream.range(0,str.length()/2).allMatch(i->str.charAt(i)==str.charAt(str.length()-i-1))).toList();
      return  res;
    }
}
