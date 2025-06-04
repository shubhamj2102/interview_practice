package practice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PracticeTest {


    @BeforeEach
    void init(){
        System.out.println("Inside init method");
    }

    @Test
    void test(){
        assertEquals("Java","Java");
    }

    @Test
    void test2(){
        assertEquals("Java","Java");
    }


}
