import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.io.*;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class TestCases {

    @Test
    void testFlatSubMatrix1() throws Exception {
        assertTimeoutPreemptively(Duration.ofMillis(2000), () -> testFlatSubMatrix("data_1_1.txt", "data_1_1_out.txt"));
    }

    @Test
    void testFlatSubMatrix2() throws Exception {
        assertTimeoutPreemptively(Duration.ofMillis(2000), () -> testFlatSubMatrix("data_1_2.txt", "data_1_2_out.txt"));
    }

    @Test
    void testFlatSubMatrix3() throws Exception {
        assertTimeoutPreemptively(Duration.ofMillis(2000), () -> testFlatSubMatrix("data_1_3.txt", "data_1_3_out.txt"));
    }

    @Test
    void testSort1() throws Exception {
        assertTimeoutPreemptively(Duration.ofMillis(2000), () -> testSort("data_2_1.txt", "data_2_1_out.txt"));
    }

    @Test
    void testSort2() throws Exception {
        assertTimeoutPreemptively(Duration.ofMillis(2000), () -> testSort("data_2_2.txt", "data_2_2_out.txt"));
    }

    @Test
    void testSort3() throws Exception {
        assertTimeoutPreemptively(Duration.ofMillis(2000), () ->testSort("data_2_3.txt", "data_2_3_out.txt"));
    }

    @Test
    void testMain1() throws Exception {
        assertTimeoutPreemptively(Duration.ofMillis(2000), () -> testMain("data_3_1.txt", "data_3_1_out.txt"));
    }

    @Test
    void testMain2() throws Exception {
        assertTimeoutPreemptively(Duration.ofMillis(2000), () -> testMain("data_3_2.txt", "data_3_2_out.txt"));
    }

    @Test
    void testMain3() throws Exception {
        assertTimeoutPreemptively(Duration.ofMillis(5000), () -> testMain("data_3_3.txt", "data_3_3_out.txt"));
    }

    @Test
    void testMain4() throws Exception {
        assertTimeoutPreemptively(Duration.ofMillis(5000), () -> testMain("data_3_4.txt", "data_3_4_out.txt"));
    }

    void testMain(String dataFile, String ansFile) throws Exception {
        System.setIn(new FileInputStream(dataFile));
        ByteArrayOutputStream bytes = new ByteArrayOutputStream(65535);
        System.setOut(new PrintStream(bytes));
        Main.main(null);
        Scanner in = new Scanner(new FileInputStream(ansFile));
//        assertEquals(in.nextLine().trim(), bytes.toString().trim());
        assertTrue(in.nextLine().trim().equals(bytes.toString().trim()));
    }

    void testSort(String dataFile, String ansFile) throws Exception {
        Class<Main> clazz = Main.class;
        Method method;
        try {
            method = clazz.getDeclaredMethod("sort", int[].class);
        } catch (NoSuchMethodException e){
            method = clazz.getDeclaredMethod("Sort", int[].class);
        }

        Scanner in = new Scanner(new FileInputStream(dataFile));
        int n = in.nextInt();
        int[] original = new int[n];
        for (int i = 0; i < n; i++)
            original[i] = in.nextInt();
        int[] actual = (int[]) method.invoke(null, original);
        in = new Scanner(new FileInputStream(ansFile));
        for (int i = 0; i < n; i++)
            assertEquals(in.nextInt(), actual[i]);
    }

    void testFlatSubMatrix(String dataFile, String ansFile) throws Exception {
        Class<Main> clazz = Main.class;
        Method method = clazz.getDeclaredMethod("flatSubMatrix", int[][].class, int.class, int.class, int.class, int.class);
        assertNotNull(method);
        String[] fileNames = {"data_1_3"};
        Scanner in = new Scanner(new FileInputStream(dataFile));
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = in.nextInt();
            }
        }
        int x1 = in.nextInt();
        int x2 = in.nextInt();
        int y1 = in.nextInt();
        int y2 = in.nextInt();
        in = new Scanner(new FileInputStream(ansFile));
        String[] expected = in.nextLine().split(" ");
        int[] actual = (int[]) method.invoke(null, matrix, x1, x2, y1, y2);
        assertEquals(expected.length, actual.length);
        for (int i = 0, len = actual.length; i < len; i++) {
            assertEquals(Integer.parseInt(expected[i]), actual[i]);
        }
    }

}