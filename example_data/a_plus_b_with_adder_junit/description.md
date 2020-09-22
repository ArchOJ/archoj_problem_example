# A+B With Adder (JUnit)

Using JUnit with multi-file support is also very simple. In this problem, you're required to implement 2 classes: `WorkingAdder` and `BrokenAdder`. Then there will be JUnit cases to test your implementation. (Might be very slow. Allow for more than 20s for the results.)

## Requirements

For `WorkingAdder`, it will use the default constructor, and includes a method with the following signature:

- `public int add(int a, int b)`

For `BrokenAdder`, it will use a constructor taking an `int` value `n`, and the `add` method will always return `n`, no matter the input. The `add` method's signature in `BrokenAdder` is the same as the one in `WorkingAdder`.

## Example

`BrokenAdder.java`

```java
public class BrokenAdder {
    int n;
    public BrokenAdder(int n) {
        this.n = n;
    }
    
    public int add(int a, int b){
        return n;
    }
}
```

`WorkingAdder.java` 

```java
public class WorkingAdder {
    public int add(int a, int b){
        return a+b;
    }
}
```