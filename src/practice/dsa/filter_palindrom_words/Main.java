package practice.dsa.filter_palindrom_words;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution sol=new Solution();

        var res=sol.filterPalindromeWords(List.of("madam", "apple", "racecar"));

        System.out.println(res);

    }
}
