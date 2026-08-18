package practice.dsa.right_shift_zeros;

import java.util.List;

public class Solution {

    public void rightShiftZeros(int[] nums){

        int index = 0;

        for (int num : nums) {
            if (num != 0) {
                nums[index++] = num;
            }
        }

        while (index < nums.length) {
            nums[index++] = 0;
        }

    }
}
