package practice.dsa.filter_integers;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution sol=new Solution();

        var res=sol.validIntegers(List.of("zz","376","-302","2xy"));
        System.out.println(res);
    }
}
