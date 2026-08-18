package practice.dsa.merge_intervals;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution solution=new Solution();
        int [][] input={{1,4},{2,4},{3,8},{10,15}};
        var result=  solution.merge(input);
        Arrays.stream(result).forEach(intv-> System.out.println(Arrays.toString(intv)));
    }
}
