package practice.dsa.sortingAlgos;

import java.util.Arrays;

public class BubbleSort {

    public void sort(int[] nums){

        int n=nums.length;
        boolean swapped=false;
        for(int i=0;i<n;i++){
            swapped=false;

            for(int j=0;j<n-i-1;j++){
                if(nums[j]>nums[j+1]){
                    // swap

                    int temp=nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=temp;
                    swapped=true;
                }
            }

            if(!swapped) break;
        }
        System.out.println(Arrays.toString(nums));
    }
}
