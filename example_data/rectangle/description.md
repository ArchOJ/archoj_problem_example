# Rectangle

## Description

Welcome to the world of geometry. Now you need implement a simple class `Point2D`, and use it to implement a simple abstract class `ConvexPolygon`, and also a normal class `Rectangle` extends it.

**Attention:** Only need consider **convex polygon**!

## Submission

Please select <font color=Red>Java(JUnit5)</font> as the judge environment when submitting.

You need submit at least `Point2D.java`, `ConvexPolygon.java` and `Rectangle.java` files. And, you are free to add other source files for java classes you used.

This part mainly check your implementation of `Point2D` and `Rectangle`.

Remember to edit the filename to keep consistent with the class name, and don't forget the `.java` filename extension.

## Requirements

### Point2D

- Private instance variables

  `x, y: double` : coordinate

- Constructor

  ```java
  public Point2D(double x, double y);
  public Point2D(Point2D point2D);//the same coordinate
  ```

- common getter and setter

  ```java
  getX(), getY(), setX(double), setY(double)
  ```

- Override method `equals` from superclass `Object`

  ```java
  @Override
  public boolean equals(Object obj);
  ```

  If `obj` is an object of `Point2D` with the same coordinate with caller object, return true, else return false.

- You are free to add more other variables or methods if you want.

### ConvexPolygon

```java
import java.util.Arrays;

public abstract class ConvexPolygon {
	//Calculate and return perimeter
    public abstract double calPerimeter();
    
    //Calculate and return area
    public abstract double calArea();
    
    //Return an array of all vertexes of the polygon
    public abstract Point2D[] getVertexes();
    
    //If the point in the convex polygon or on the side, return true
    public abstract Boolean contains(Point2D point);
    
    //If contain, return true. Also points on side considered as contained
    public Boolean contains(ConvexPolygon polygon){
        //Implementation
    }
}
```

You can simply copy the code, and only need implement `contains` method here.

You are free to add more other variables or methods if you want.

### Rectangle

- This class extends `ConvexPolygon`

- Private instance variables

  `topLeft : Point2D` : The top-left point of the rectangle

  `width, height : double` : The width and height of the rectangle

- Constructors

  ```java
  /**
   * Construct with top-left point and bottom-right point
   * @param topLeft The top-left point
   * @param bottomRight The bottom-right point
   * @throws IllegalArgumentException if {@code topLeft}  not on the upper left of 	    {@code bottomRight}
   */
  public Rectangle(Point2D topLeft, Point2D bottomRight) throws IllegalArgumentException;
  
  /**
   * Construct with top-left point, width and height
   * @param topLeft The top-left point
   * @param width The width
   * @param height The height
   * @throws IllegalArgumentException if {@code width <= 0} or {@code height <= 0}
   */
  public Rectangle(Point2D topLeft, double width, double height) throws IllegalArgumentException;
  ```

  You should complete the initialization of `topLeft`, `width` and `height` in constructor.

- Implement abstract methods from super class `ConvexPolygon`

  ```java
  //Implement abstract methods in superclass ConvexPolygon
  public double calPerimeter();
  public double calArea();
  public Point2D[] getVertexes();
  public Boolean contains(Point2D point);
  ```

- Getter and setter

  ```java
  public double getWidth();
  // if width <= 0, return false and dont change width
  public boolean setWidth(double width);
  public double getHeight();
  // if height <= 0, return false and dont change height
  public boolean setHeight(double height);
  public Point2D getTopLeft();
  public void setTopLeft(Point2D topLeft);
  ```

- You are free to add more other variables or methods if you want.