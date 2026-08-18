package practice.dsa.second_highest_length;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Find the second highest length in a given sentence of words.
 *
 * Requirements:
 *
 * 1.MUST use java 8 streams.
 * 2.Solve in functional programming style. AVOID for/while loops and mutable variables.
 *
 * Example:
 * Input: "I am motivated to grow in my organization"
 * Output: 9
 *
 *
 */
public class Solution {

    public int secondHighestLength(String sentence){

       return Arrays.stream(sentence.split("\\s+")).map(String::length).sorted(Comparator.reverseOrder()).distinct().skip(1).findFirst().get();
    }
}
