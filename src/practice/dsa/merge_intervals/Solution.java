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
import java.util.Comparator;
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

    public int[][] merge(int[][] intervals) {

        int m=intervals.length;

        if(m==0){
            return new int[][]{{}};
        }

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<List<Integer>> mergedList=new ArrayList<>();

        addInterval(intervals[0][0],intervals[0][1],mergedList);
        int currIdx=0;

        for(int i=1;i<m;i++){
            if(mergedList.get(currIdx).get(1)>=intervals[i][0]){
                mergedList.get(currIdx).set(1,Math.max(intervals[i][1],mergedList.get(currIdx).get(1)));
            }
            else{
                addInterval(intervals[i][0],intervals[i][1],mergedList);
                currIdx++;
            }
        }

        return mergedList.stream().map(intv->new int[]{intv.get(0),intv.get(1)}).toArray(int[][]::new);


    }

    private void addInterval(int start, int end, List<List<Integer>> mergedList){
        List<Integer>  interval=new ArrayList<>();
        interval.add(start);
        interval.add(end);
        mergedList.add(interval);
    }
}
