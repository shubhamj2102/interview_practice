package practice.dsa.reverse_array;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution sol=new Solution();
        String[] input=new String[]{"h", "e", "l", "l", "o"};
        sol.reverseArray(input);
        System.out.println(Arrays.toString(input));

    }
}
