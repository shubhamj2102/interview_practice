package practice.dsa.sum_of_previous_k_elements;


/**
 * You are given: An array of integers and a number k.
      Create a new array where:
        1. For each index, calculate the sum of "the current element and the previous k-1 elements".
        2. If there are less than k elements before index i, sum all elements from index 0 to i.

 Example 1:
 Input:  array = [1, 2, 3, 4, 5], k = 3
 Output is: [1, 3, 6, 9, 12]
 Explanation: 1, 1+2, 1+2+3, 2+3+4, 3+4+5 -> {1,3,6,9,12}

 **/

public class Solution {


     public int [] sumOfKElements(int [] nums, int k){

         int sum=0;
         int count=0;
         int n=nums.length;
         int [] res=new int[n];


         for(int i=0;i<n;i++){
             if(count>=k){
                 sum=sum-nums[i-k];
             }
             sum+=nums[i];
             res[i]=sum;
             count++;
         }

         return res;

     }

}
