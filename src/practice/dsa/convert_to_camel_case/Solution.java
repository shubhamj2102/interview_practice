package practice.dsa.convert_to_camel_case;


import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 *
 * Given a sentence, convert it to a hashtag in CamelCase style.
 * Each word should start with an uppercase letter, then all words should be
 * joined and prefixed with. Ignore extra spaces between words.
 *
 * Requirements:
 *
 * 1. MUST use Java 8 streams.
 * 2. Solve in functional programming style.
 *
 * Example:
 * Input: "hello world java"
 * Output: "#HelloWorldJava"
 */

public class Solution {

    public String convertToCamelCase(String sentence){
      var res=  Arrays.stream(sentence.split(" ")).filter(str->!str.isEmpty()).map(str->Character.toUpperCase(str.charAt(0))+str.substring(1).toLowerCase()).collect(Collectors.joining("","#",""));

        return res;
    }
}
