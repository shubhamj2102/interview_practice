package practice.dsa.find_duplicate;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution sol=new Solution();
        var res=sol.findDuplicate(List.of(1, 3, 2, 3, 1));
        System.out.println(res);

    }
}
