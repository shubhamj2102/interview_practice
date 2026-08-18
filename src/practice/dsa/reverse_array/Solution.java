package practice.dsa.reverse_array;

import java.util.stream.IntStream;

/**
 *
 * Given a character array, reverse the array in-place.
 *
 * Requirements:
 *
 * 1.Provide an optimal solution in terms of space and time complexity.
 * 2.Don't use extra space.
 * 3.Time Complexity should be O (n).
 *
 * Example:
 * Input: ["h", "e", "l", "l", "o"]
 * Output: ["o", "l", "l", "e", "h"]
 */
public class Solution {

    public void reverseArray(String [] arr){
        int n=arr.length;
        int p1=0, p2=n-1;

        while(p1<p2){
            String temp=arr[p1];
            arr[p1]=arr[p2];
            arr[p2]=temp;
            p1++;
            p2--;
        }
    }

}
