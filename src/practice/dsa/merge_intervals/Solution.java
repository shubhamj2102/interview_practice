package practice.dsa.merge_intervals;


// Overlapping possibility before sort
/* 1.  -------------------
 *                  ---------------
 *
 *
 *
 * 2.          --------------------
 *   ----------------
 *
 *
 *
 * 3.           ---------------------
 *        ---------------------------------
 *
 *
 * **/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// Overlapping possibility after sort
/* 1.  -------------------
 *                  ---------------
 *
 *
 * 2.           ----------------------------------
 *                       ------------
 *
 *  3.   -----------------------
 *                    ----------
 *
 * 4.  ----------------
 *     --------------------
 *
 * **/
public class Solution {

    public List<List<Integer>> mergeInterval(int[][] intervals){

        if(intervals.length<=1){
            return Arrays.stream(intervals).map(i->Arrays.stream(i).boxed().collect(Collectors.toList())).toList();

        }
       List<List<Integer>> mergedList=new ArrayList<>();
        Arrays.sort(intervals, (i1,i2)->{
            if(i1[0]==i2[0]){
                return i1[1]-i2[1];
            }
            return i1[0]-i2[0];
        });
        List<Integer> currInterval=new ArrayList<>();
        currInterval.add(intervals[0][0]);
        currInterval.add(intervals[0][1]);
        mergedList.add(currInterval);

        int currIndex=0;
        for(int i=1;i<intervals.length;i++){
            int[] interval=intervals[i];
            if(interval[0]<=mergedList.get(currIndex).get(1)){
                mergedList.get(currIndex).set(1,interval[1]);
            }
            else {
                currInterval=new ArrayList<>();
                currInterval.add(intervals[i][0]);
                currInterval.add(intervals[i][1]);
                mergedList.add(currInterval);
                currIndex++;
            }
        }

        return mergedList;
    }
}
