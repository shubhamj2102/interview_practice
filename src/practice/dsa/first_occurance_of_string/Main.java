package practice.dsa.first_occurance_of_string;

public class Main {
    public static void main(String[] args) {
        Solution sol=new Solution();
        Solution2 sol2=new Solution2();
        System.out.println(sol.strStr("sadbutsad","sad"));
        System.out.println(sol.strStr("leetcode","leeto"));

        System.out.println("Optimized approach");
        System.out.println(sol2.strStr("sadbutsad","sad"));
        System.out.println(sol2.strStr("leetcode","leeto"));
    }
}
