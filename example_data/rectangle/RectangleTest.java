import org.junit.jupiter.api.Test;
import java.time.Duration;
import java.util.Arrays;
import java.util.Comparator;
import static org.junit.jupiter.api.Assertions.*;

public class RectangleTest {
    final static int waitTime = 5;

    @Test
    public void testConstructorWithWrongPointPair1(){
        assertTimeoutPreemptively(Duration.ofSeconds(waitTime),()->{
            assertThrows(IllegalArgumentException.class, () -> {
                new Rectangle(new Point2D(1,1), new Point2D(1,0));
            });
        });
    }

    @Test
    public void testConstructorWithWrongPointPair2(){
        assertTimeoutPreemptively(Duration.ofSeconds(waitTime),()->{
            assertThrows(IllegalArgumentException.class, () -> {
                new Rectangle(new Point2D(1,1), new Point2D(2,1));
            });
        });
    }

    @Test
    public void testConstructorWithPoints(){
        assertTimeoutPreemptively(Duration.ofSeconds(waitTime),()->{
            Rectangle rectangle = new Rectangle(new Point2D(0,1), new Point2D(2,0));
            assertNotNull(rectangle);
        });
    }

    @Test
    public void testConstructorWithWrongWidth(){
        assertTimeoutPreemptively(Duration.ofSeconds(waitTime),()->{
            assertThrows(IllegalArgumentException.class, () -> {
                new Rectangle(new Point2D(1,1), 0, 1);
            });
        });
    }

    @Test
    public void testConstructorWithWrongHeight(){
        assertTimeoutPreemptively(Duration.ofSeconds(waitTime),()->{
            assertThrows(IllegalArgumentException.class, () -> {
            new Rectangle(new Point2D(1,1), 1, 0);
            });
        });
    }

    @Test
    public void testConstructorWithWidthHeight(){
        assertTimeoutPreemptively(Duration.ofSeconds(waitTime),()->{
            Rectangle rectangle = new Rectangle(new Point2D(1,1), 1, 1);
            assertNotNull(rectangle);
        });
    }

    @Test
    public void testCalculatePerimeter(){
        assertTimeoutPreemptively(Duration.ofSeconds(waitTime),()->{
            Rectangle rectangle = new Rectangle(new Point2D(-1,2), 2, 4);
            assertEquals(12, rectangle.calPerimeter());
        });
    }

    @Test
    public void testCalculateArea(){
        assertTimeoutPreemptively(Duration.ofSeconds(waitTime),()->{
            Rectangle rectangle = new Rectangle(new Point2D(-1,2), 2, 4);
            assertEquals(8, rectangle.calArea());
        });
    }

    @Test
    public void testVertexes(){
        assertTimeoutPreemptively(Duration.ofSeconds(waitTime),()->{
            Rectangle rectangle = new Rectangle(new Point2D(-1,2), 2, 4);
            Point2D[] check = rectangle.getVertexes();
            Point2D[] aim = new Point2D[]{new Point2D(-1,2), new Point2D(1,2), new Point2D(-1,-2), new Point2D(1,-2)};
            Comparator<Point2D> comparator = (o1, o2) -> (int) (Math.abs(o1.getX() - o2.getX()) <= 1e-6 ? o1.getY() - o2.getY() : o1.getX() - o2.getX());
            Arrays.sort(check, comparator);
            Arrays.sort(aim, comparator);
            assertArrayEquals(aim, check);
            aim = new Point2D[]{new Point2D(-1,2), new Point2D(-1,2), new Point2D(-1,-2), new Point2D(1,-2)};
            Arrays.sort(aim, comparator);
            assertFalse(Arrays.equals(aim, check));
        });
    }

    @Test
    public void testContain(){
        assertTimeoutPreemptively(Duration.ofSeconds(waitTime),()->{
            Rectangle rectangle = new Rectangle(new Point2D(-1,2), 2, 4);
            assertTrue(rectangle.contains(new Point2D(-1,2)));
            assertTrue(rectangle.contains(new Point2D(1,-2)));
            assertTrue(rectangle.contains(new Point2D(0,0)));
            assertTrue(rectangle.contains(new Point2D(-1,0)));
            assertFalse(rectangle.contains(new Point2D(-1.1,2)));
            assertFalse(rectangle.contains(new Point2D(-1,2.1)));
        });
    }

    @Test
    public void testGetter(){
        assertTimeoutPreemptively(Duration.ofSeconds(waitTime),()->{
            Rectangle rectangle = new Rectangle(new Point2D(-1,2), 2, 4);
            assertEquals(2, rectangle.getWidth());
            assertEquals(4, rectangle.getHeight());
            assertEquals(new Point2D(-1, 2), rectangle.getTopLeft());
        });
    }

    @Test
    public void testSetterNonpositiveWidth(){
        assertTimeoutPreemptively(Duration.ofSeconds(waitTime),()->{
            Rectangle rectangle = new Rectangle(new Point2D(-1,2), 2, 4);
            assertFalse(rectangle.setWidth(0));
        });
    }

    @Test
    public void testSetterNonpositiveHeight(){
        assertTimeoutPreemptively(Duration.ofSeconds(waitTime),()->{
            Rectangle rectangle = new Rectangle(new Point2D(-1,2), 2, 4);
            assertFalse(rectangle.setHeight(0));
        });
    }

    @Test
    public void testSetterValid(){
        assertTimeoutPreemptively(Duration.ofSeconds(waitTime),()->{
            Rectangle rectangle = new Rectangle(new Point2D(-1,2), 2, 4);
            assertTrue(rectangle.setHeight(123));
            assertEquals(123, rectangle.getHeight());
            assertTrue(rectangle.setWidth(234));
            assertEquals(234, rectangle.getWidth());
            rectangle.setTopLeft(new Point2D(-123,123));
            assertEquals(new Point2D(-123,123), rectangle.getTopLeft());
        });
    }
}
