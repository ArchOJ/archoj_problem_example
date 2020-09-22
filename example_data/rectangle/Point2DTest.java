import org.junit.jupiter.api.Test;
import java.time.Duration;
import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;

public class Point2DTest {
    private final Point2D point2D = new Point2D(-Math.PI,Math.PI);

    @Test
    public void testConstructorWithPoint(){
        assertTimeoutPreemptively(Duration.ofSeconds(5), () -> {
            Point2D tmp = new Point2D(point2D);
            assertNotNull(tmp);
            assertEquals(point2D.getX(), tmp.getX());
            assertEquals(point2D.getY(), tmp.getY());
        });
    }

    @Test
    public void testGetter(){
        assertTimeoutPreemptively(Duration.ofSeconds(5), () -> {
            assertEquals(-Math.PI, point2D.getX());
            assertEquals(Math.PI, point2D.getY());
        });
    }

    @Test
    public void testSetter(){
        assertTimeoutPreemptively(Duration.ofSeconds(5), () -> {
            point2D.setX(123.456);
            point2D.setY(456.123);
            assertEquals(123.456, point2D.getX());
            assertEquals(456.123, point2D.getY());
        });
    }

    @Test
    public void testUnequal(){
        Point2D test = new Point2D(point2D.getX() - 0.01, point2D.getY() + 0.01);
        assertFalse(test.equals(point2D));
    }

    @Test
    public void testEqual(){
        Point2D test = new Point2D(point2D);
        assertTrue(test.equals(point2D));
    }

    @Test
    public void testEqualSelf(){
        assertTrue(point2D.equals(point2D));
    }

    @Test
    public void testEqualNull(){
        assertFalse(point2D.equals(null));
    }

    @Test
    public void testEqualDiffClass(){
        assertFalse(point2D.equals(new Vector()));
    }
}
