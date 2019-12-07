package com.nexem.serve;

import java.time.LocalDateTime;
import java.util.*;

//Problem Statement
//
//        You are given three numbers: a, b, and c. You need to generate three arrays A, B, C of lengths a, b, c using the pseudocode given below:
//
//        A[0] = 33
//        A[1] = 42
//        for i = 2 to a-1:
//        A[i] = (5*A[i-1] + 7*A[i-2]) modulo 1000000007 + 1
//
//        B[0] = 13
//        for i = 1 to b-1:
//        B[i] = (11*B[i-1]) modulo 1000000007 + 1
//
//        C[0] = 7
//        C[1] = 2
//        for i = 2 to c-1:
//        C[i] = (5*C[i-1] + 7*C[i-2]) modulo 1000000007 + 1
//        Now that you have 3 arrays A , B and C, you can perform three types of moves:
//
//        Remove one element each from arrays A and B. The cost of this operation is (x + the sum of elements you removed).
//        Remove one element each from arrays B and C. The cost of this operation is (y + the sum of elements you removed).
//        Remove one element each from arrays A and C. The cost of this operation is (z + the sum of elements you removed).
//        You need to minimize the sum of elements remaining in these arrays after performing above mentioned operations any number of times. If there are multiple ways to obtain the minimum sum, you need to minimize the cost of doing so.
//
//        Return an array of two integers containing the minimum sum (at index 0) and minimum cost of obtaining the minimum sum (at index 1).
//
//
//        Definition
//
//        Class:	DeleteArrays
//        Method:	doDelete
//        Parameters:	int, int, int, long, long, long
//        Returns:	long[]
//        Method signature:	long[] doDelete(int a, int b, int c, long x, long y, long z)
//        (be sure your method is public)
//
//
//        Notes
//        -	The input format is only chosen to keep the input size small. The reference solution does not depend on any properties of these arrays A, B, C, it would work correctly for any arrays of the given length.
//        -	Watch out for integer overflows, both when generating the input arrays and when calculating the return values.
//        -	The elements of arrays can be removed in any order.
//
//        Constraints
//        -	Each of a, b and c will be between 2 and 10^5, inclusive.
//        -	Each of x, y and z will be between 1 and 10^9, inclusive.
//
//        Examples
//        0)
//
//        2
//        2
//        2
//        2
//        3
//        4
//        Returns: {0, 250 }
//        The arrays are:
//
//        A = {33, 42}
//
//        B = {13, 144}
//
//        C = {7, 2}
//
//        We can remove first elements from arrays A and B with cost (2 + 33 + 13) = 48.
//
//        Next we remove the remaining element from A and the first element of C with cost (4 + 42 + 7) = 53.
//
//        Finally, we remove the remaining elements from B and C with cost (3 + 144 + 2) = 149.
//
//        Sum of Elements remaining = 0, which is clearly optimal. Cost = 48 + 53 + 149 = 250.
//        1)
//
//        3
//        2
//        2
//        3
//        2
//        1
//        Returns: {2, 688 }
//        The arrays are:
//
//        A = {33, 42, 442}
//
//        B = {13, 144}
//
//        C = {7, 2}
//
//        One optimal solution:
//        Remove 33 from A and 13 from B, cost = (3 + 33 + 13) = 49.
//        Remove 442 from A and 144 from B, cost = (3 + 442 + 144) = 589.
//        Remove 42 from A and 7 from C, cost = (1 + 42 + 7) = 50.
//        Sum of remaining elements = 2. Total cost = 49 + 589 + 50 = 688.
//
//        2)
//
//        4
//        4
//        4
//        5
//        6
//        7
//        Returns: {0, 22620 }
//        3)
//
//        100000
//        5
//        8
//        424242
//        474747
//        123456789
//        Returns: {50097960828195, 13989929548 }
//        This problem statement is the exclusive and proprietary property of TopCoder, Inc. Any unauthorized use or reproduction of this information without the prior written consent of TopCoder, Inc. is strictly prohibited. (c)2010, TopCoder, Inc. All rights reserved.
public class Main {
    public static void main(String[] args) {

        deleteArr(
                100000,
                5,
                8,
                424242,
                474747,
                123456789);
    }

    public static void deleteArr(int a, int b, int c, long x, long y, long z) {
//
        LocalDateTime time = LocalDateTime.now();
        System.out.println(time);
        char[] arr = {'1','1','2','3','9','8','u','2','1','0','1','3'};
        System.out.println(Arrays.toString(arr));
        System.out.println(LocalDateTime.now());
        System.out.println("112398u21013");
        System.out.println(LocalDateTime.now());



    }
}