package practice.dsa.merge_2_sorted_array;

public class Solution {

    /**
    *
     * Write a function that merges two sorted integer arrays into a single sorted array.
     * The function should maintain sorted order and handle arrays of different lengths.
     *
     * Requirements:
     *
     * 1. Do not use built-in sorting methods.
     *
     * Example:
     * Input: arr1 = [1, 3, 5], arr2 = [2, 4, 6]
     * Output: [1, 2, 3, 4, 5, 6]
    * */

    public int[] merge2SortedArray(int [] nums1, int[] nums2){

        int n1=nums1.length;
        int n2=nums2.length;

        int p1=0, p2=0, i=0;
        int [] mergedArr=new int[n1+n2];



        while(p1<n1 && p2<n2){
            if(nums1[p1]<nums2[p2]){
                mergedArr[i]=nums1[p1];
                i++;
                p1++;
            }
            else{
                mergedArr[i]=nums2[p2];
                i++;
                p2++;
            }
        }

        if(p1<n1){
            for(int j=p1;j<n1;j++){
                mergedArr[i]=nums1[j];
                i++;
            }


        }

        if(p2<n2){
            for(int j=p2;j<n2;j++){
                mergedArr[i]=nums2[j];
                i++;
            }
        }

        return mergedArr;
    }
}
