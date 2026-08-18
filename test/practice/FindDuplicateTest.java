package practice;

import org.junit.jupiter.api.Test;
import practice.dsa.find_duplicate.Solution;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FindDuplicateTest {


    @Test
    public void testFindDuplicate(){
        Solution sol=new Solution();
        var expected=List.of(List.of(3,3),List.of(4,1));
        assertEquals(expected,sol.findDuplicate(List.of(1, 3, 2, 3, 1)));
    }
}
