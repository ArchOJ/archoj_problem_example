import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.io.*;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class AdderTest {

    @Test
    void workingAdderTest1(){
        WorkingAdder adder = new WorkingAdder();
        assertEquals(2, adder.add(1,1));
    }

    @Test
    void workingAdderTest2(){
        WorkingAdder adder = new WorkingAdder();
        assertEquals(3, adder.add(1,2));
    }

    @Test
    void workingAdderTest3(){
        WorkingAdder adder = new WorkingAdder();
        assertEquals(10, adder.add(5,5));
    }

    @Test
    void brokenAdderTest1(){
        int n = 1;
        BrokenAdder adder = new BrokenAdder(n);
        assertEquals(n, adder.add(5,5));
    }

    @Test
    void brokenAdderTest2(){
        int n = 2;
        BrokenAdder adder = new BrokenAdder(n);
        assertEquals(n, adder.add(5,5));
    }

    @Test
    void brokenAdderTest3(){
        int n = 3;
        BrokenAdder adder = new BrokenAdder(n);
        assertEquals(n, adder.add(5,5));
    }
}
