package practice.dsa.longest_common_prefix;

import java.util.Arrays;

public class Solution {

    /**
     * 14. Longest Common Prefix
     * <p>
     * Write a function to find the longest common prefix string amongst an array of strings.
     * <p>
     * If there is no common prefix, return an empty string "".
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: strs = ["flower","flow","flight"]
     * Output: "fl"
     * Example 2:
     * <p>
     * Input: strs = ["dog","racecar","car"]
     * Output: ""
     * Explanation: There is no common prefix among the input strings.
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= strs.length <= 200
     * 0 <= strs[i].length <= 200
     * strs[i] consists of only lowercase English letters if it is non-empty.
     * <p>
     */

    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        StringBuilder res = new StringBuilder();
        if (n == 0) return res.toString();

        if (n == 1) {
            return strs[0];
        }
        Arrays.sort(strs);

        String first = strs[0];
        String last = strs[n - 1];


        for (int i = 0; i < Math.min(first.length(), last.length()); i++) {
            if (first.charAt(i) != last.charAt(i)) {
                return res.toString();
            }
            res.append(first.charAt(i));
        }

        return res.toString();
    }
}
