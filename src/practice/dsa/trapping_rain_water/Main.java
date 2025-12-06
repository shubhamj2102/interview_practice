package practice.dsa.trapping_rain_water;


public class Main {
    public static void main(String[] args) {
        Solution sol=new Solution();

       var res= sol.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
        System.out.println("water vol with approach 1="+res);
        System.out.println("water vol with approach 2="+ sol.trap2(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));

    }
}
