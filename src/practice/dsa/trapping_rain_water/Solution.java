package practice.dsa.trapping_rain_water;

/*Leetcode: 42. Trapping Rain Water-HARD

* Given n non-negative integers representing an elevation map where
* the width of each bar is 1, compute how much water it can trap after raining.
*
*Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
Example 2:

Input: height = [4,2,0,3,2,5]
Output: 9

Constraints:
n == height.length
1 <= n <= 2 * 104
0 <= height[i] <= 105
*
* */

public class Solution {
    public int trap(int[] height) {
        int leftMax=0;
        int rightMax=0;

        int l=0, r=height.length-1;
        int res=0;

        while(l<=r){
           if(height[l]<=height[r]){
               //process left
               if(height[l]>leftMax){
                   leftMax=height[l];
               }
               else{
                   res+=leftMax-height[l];
               }

               l++;
           }
           else{
               // Process right
               if(height[r]>rightMax){
                   rightMax=height[r];
               }
               else{
                   res+=rightMax-height[r];
               }

               r--;
           }
        }

        return res;
    }

    public int trap2(int [] height){

        int n=height.length;
        int [] leftMax=new int[n];
        int[] rightMax=new int[n];
        leftMax[0]=height[0];
        rightMax[n-1]=height[n-1];
        for(int i=1;i<n;i++){
            leftMax[i]=Math.max(height[i],leftMax[i-1]);
        }

        for(int i=n-2;i>=0;i--){
            rightMax[i]=Math.max(height[i],rightMax[i+1]);
        }

        int res=0;
        for(int i=0;i<n;i++){

            int minH=Math.min(leftMax[i],rightMax[i]);
            res+=minH-height[i];
        }

        return res;
    }
}
