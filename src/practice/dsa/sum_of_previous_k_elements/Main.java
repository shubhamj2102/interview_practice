package practice.dsa.sum_of_previous_k_elements;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Solution sol=new Solution();

       var res= sol.sumOfKElements(new int[]{1, 6, 8},1);

        System.out.println(Arrays.toString(res));

    }
}
