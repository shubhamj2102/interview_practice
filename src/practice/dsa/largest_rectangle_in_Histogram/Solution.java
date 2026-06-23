package practice.dsa.largest_rectangle_in_Histogram;

import java.util.Stack;

// Leetcode 84. Largest Rectangle in Histogram
public class Solution {

    public int largestRectangleArea(int[] heights) {
        int n=heights.length;


        int [] left=new int[n];
        int [] right=new int[n];

        Stack<Integer> stack=new Stack<>();


        for(int i=0;i<n;i++){
            while(!stack.empty() && heights[stack.peek()]>=heights[i]){
                stack.pop();
            }
            left[i]=stack.empty()?-1:stack.peek();
            stack.add(i);
        }
        stack.clear();

        for(int i=n-1;i>=0;i--){
            while(!stack.empty() && heights[stack.peek()]>=heights[i]){
                stack.pop();
            }
            right[i]=stack.empty()?n:stack.peek();
            stack.add(i);
        }

        int maxArea=0;

        for(int i=0;i<n;i++){
            maxArea=Math.max(maxArea, (right[i]-left[i]-1)*heights[i]);
        }

        return maxArea;

    }
}
