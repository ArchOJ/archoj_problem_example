# Flat a Sub-Matrix and Sort it

**CHOOSE Java (JUnit5) to submit for this problem!**

**CHOOSE Java (JUnit5) to submit for this problem!**

**CHOOSE Java (JUnit5) to submit for this problem!**

## Description

Definition for Sub-matrix:

Given a $m\times n$ matrix $X$ ($m\times n$ means $m$ rows and $n$ columns), and given two elements $X_{x_1,y_1}$ and $X_{x_2,y_2}$ ($0\leq x_1 \leq x_2 < m, 0\leq y_1 \leq y_2 <n$). Please write a program to sort all the integers in the sub-matrix determined by the two elements.

A sub-matrix means a matrix inside of the origin matrix $X$ whose upper-left element is $X_{x_1,y_2}$ and bottom right element is $X_{x_2,y_2}$ .

Here is an example:

Matrix $X_{4\times 5}$: 

```
  1  2  3  9  5 
  6  7  8 11 10
 11 12 13 14 15
 16 17 18 19 20
```

Sub-matrix $S$, from $X_{0,2}$ to $X_{1,4}$, is: 

```
  3  9  5 
  8 11 10
```

Flat a sub-matrix $S$ line by line (with the `flatSubMatrix` method) into an array `A`.

Array `A` (as the return value of `flatSubMatrix` method): 

```
3 9 5 8 11 10 
```

Then sort array `A` (with `Sort` method) and output **sorted `A`** (as the return value of `Sort` method): 

```
3 5 8 9 10 11 
```

In this question you must design 2 methods:

1. Method to flat the sub-matrix:

```java
// Inputs are Matrix X and the indexs of elements X[x1][y1] and X[x2][y2]. 
// Return the flated array A. 
public static int[] flatSubMatrix(int[][] matrix, int x1, int x2, int y1, int y2) 
```

2. Method to sort the array:

```java
// Inputs is the flated array A.
// Return the sorted array.
public static int[] Sort(int[] array).
```

### Note:

The required method must be implemented, otherwise it will affect your score.

## Input

**Using** `System.in`

There are $m+2$ lines in total.

The first line contains two integers $m, n$, denoting the matrix has $m$ rows and $n$ columns. $0<m<250, 0<n<250$.

The following $m$ lines have $n$ integers each line, denoting the elements of the matrix.

The last line have four integers $x_1, x_2, y_1, y_2$ ($0\leq x_1 \leq x_2 < m, 0 \leq y_1 \leq y_2<n)$, denoting indexes of upper-left element $X_{x_1,y_1}$ and bottom-right element $X_{x_2,y_2}$.

## Output

The sorted array.

## Sample Input

```
4 5
1 2 3 9 5 
6 7 8 11 10
11 12 13 14 15
16 17 18 19 20
0 1 2 4
```

## Sample Output

```
3 5 8 9 10 11
```

## Hint

You can use bubble sort to sort the array. Search "Bubble sort" on the Internet and implement it by yourself.
