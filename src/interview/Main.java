package interview;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main  {
    public static void main(String[] args) {
        // prime numbers using stream

        var res=IntStream.range(1,100).filter(i->i>1 && IntStream.range(2,i-1).noneMatch(j->i%j==0)).toArray();
        System.out.println(Arrays.toString(res));
    }

}
