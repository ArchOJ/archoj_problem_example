# A+B

## Description

*"Hello World" for any online judge system.*

Input 2 numbers, then output the sum.

## Language Requirement

Java

## Input & Output

Input: 2 Integers

Output: an Integer

(The sum won't exceed the range of Integer.)

## Examples

| Input   | Output |
| ------- | ------ |
| 1 2     | 3      |
| 100 200 | 300    |

## Example Program

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        System.out.println(a+b);
    }
}

```

