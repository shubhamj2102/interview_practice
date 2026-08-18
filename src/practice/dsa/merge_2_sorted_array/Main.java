package practice.dsa.merge_2_sorted_array;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Solution sol=new Solution();
        int[] arr1= {1, 3, 5};
        int[] arr2={2, 4, 6};

       var res= sol.merge2SortedArray(arr1,arr2);

        System.out.println(Arrays.toString(res));
    }
}
