package practice.dsa.merge_intervals;

public class Main {
    public static void main(String[] args) {
        Solution solution=new Solution();
        int [][] input={{1,4},{2,4},{3,8},{10,15}};
        var result=  solution.mergeInterval(input);
        System.out.println(result);
    }
}
