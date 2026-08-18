package practice.dsa.find_duplicate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

/**
 *
 * Find all duplicate elements in a list. Return each duplicate as a pair of its index and value, preserving order of occurrence.
 *
 * Requirements:
 *
 * 1.MUST use Java 8 streams.
 * 2.Solve in functional programming style. AVOID for/while loops and mutable variables.
 *
 * Example:
 * Input: [1, 3, 2, 3, 1]
 * Output:
 * [3, 3]
 * [4, 1]
 */

public class Solution {

    public List<List<Integer>> findDuplicate(List<Integer> list){
       var res= IntStream.range(0,list.size()).filter(i->list.subList(0,i).contains(list.get(i))).mapToObj(i->List.of(i,list.get(i))).toList();
       return res;
    }
}
