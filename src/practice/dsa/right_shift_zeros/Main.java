package practice.dsa.right_shift_zeros;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Solution solution=new Solution();

        int[] input={10,12,0,4,31,0,58,0};
        solution.rightShiftZeros(input);
        System.out.println(Arrays.toString(input));
    }
}
