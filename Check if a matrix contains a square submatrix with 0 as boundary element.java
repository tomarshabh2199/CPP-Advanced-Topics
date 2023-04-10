// Check if a matrix contains a square submatrix with 0 as boundary element
// Given an N*N binary matrix arr[][], the task is to check if the matrix contains a square of at least size 2 x 2 whose boundaries are made up of only 0s.

// Examples:  

// Input: 
// arr[][] = { 
// {1, 1, 1, 0, 1, 0}, 
// {0, 0, 0, 0, 0, 1}, 
// {0, 1, 1, 1, 0, 1}, 
// {0, 0, 0, 1, 0, 1}, 
// {0, 1, 1, 1, 0, 1}, 
// {0, 0, 0, 0, 0, 1} 
// } 
// Output: True 
// Explanation: 
// Since, arr[][] contains square matrix with all 0’s at boundary, so answer is True. 
// { 
// {  ,  ,  ,  ,  , }, 
// {0,   0,   0,   0,   0, }, 
// {0,  ,  ,  ,   0, }, 
// {0,  ,  ,  ,   0, }, 
// {0,  ,  ,  ,  0, }, 
// {0,   0,   0,   0,   0, } 
// }


// Approach:  

// A square is defined by its topmost and bottommost rows and by its leftmost and rightmost columns.
// Given a pair of rows and a pair of columns that form a valid square, you can easily determine if the relevant square is a square of zeroes with two for loops.
// It is required to iterate over every valid square in the input matrix, arr[][].
// We can start iterating from the outermost square and recursively go inwards in the matrix.
// On moving inward, from (r1, c1) and (r2, c2) we have 5 options, which will generate square matrix:- 
// a) (r1 + 1, c1 + 1), (r2 – 1, c2 – 1) 
// b) (r1, c1 + 1), (r2 – 1, c2) 
// c) (r1 + 1, c1), (r2, c2 – 1) 
// d) (r1 + 1, c1 + 1), (r2, c2) 
// e) (r1, c1), (r2 – 1, c2 – 1)
// Since, the problem has many overlapping sub-problem, so we need to use cache/memoization to avoid duplicate computations.

import java.io.*;
import java.util.*;

 class GFG{
    // Function checks if square
    // with all 0's in boundary
    // exists in the matrix
    static int squareOfZeroes(int[][] matrix)
    {
        int lastIdx=matrix.length-1;
        Map<String,Boolean>cache=new HashMap<String,Boolean>();
        return (hasSquareOfZeroes(matrix,0,0,lastIdx,lastIdx,cache))?1:0;
    }
    
    // Function iterate inward in
    // the matrix and checks the
    // square obtained and memoize/cache
    // the result to avoid duplicate computation
    
    // r1 is the top row,
    // c1 is the left col
    // r2 is the bottom row,
    // c2 is the right

    static boolean hasSquareOfZeroes(int[][] matrix,int r1,int c1,int r2, int c2, Map<String, Boolean>cache)
    {
        if(r1>=r2 || c1>=c2)
           return false;
        String key= r1 + "-" + c1 + "-"+ r2 + "-" + c2;

        if(cache.containsKey(key))
           return cache.get(key);

           cache.put(
            key,
            isSquareOfZeroes(matrix, r1, c1, r2, c2)
                || hasSquareOfZeroes(matrix, r1 + 1, c1 + 1,
                                     r2 - 1, c2 - 1, cache)
                || hasSquareOfZeroes(matrix, r1, c1 + 1,
                                     r2 - 1, c2, cache)
                || hasSquareOfZeroes(matrix, r1 + 1, c1, r2,
                                     c2 - 1, cache)
                || hasSquareOfZeroes(matrix, r1 + 1, c1 + 1,
                                     r2, c2, cache)
                || hasSquareOfZeroes(matrix, r1, c1, r2 - 1,
                                     c2 - 1, cache));

            return cache.get(key);
    }
    // Function checks if the
    // boundary of the square
    // consists of 0's

    static boolean isSquareOfZeroes(int[][] matrix,
                                    int r1, int c1,
                                    int r2, int c2)
    {
        for (int row = r1; row < r2 + 1; row++)
        {
            if (matrix[row][c1] != 0
                || matrix[row][c2] != 0)
                return false;
        }
        for (int col = c1; col < c2 + 1; col++)
        {
            if (matrix[r1][col] != 0
                || matrix[r2][col] != 0)
                return false;
        }
        return true;
    }

    // Driver Code
    public static void main(String[] args)
    {
        int[][] matrix = {
            { 1, 1, 1, 0, 1, 0 }, { 0, 0, 0, 0, 0, 1 },
            { 0, 1, 1, 1, 0, 1 }, { 0, 0, 0, 1, 0, 1 },
            { 0, 1, 1, 1, 0, 1 }, { 0, 0, 0, 0, 0, 1 }
        };
        int ans;
        ans = squareOfZeroes(matrix);
 
        if (ans == 1)
        {
            System.out.println("True");
        }
        else
        {
            System.out.println("False");
        }
    }
}

/*Output: 
True */

/*Time Complexity: O(N^4), as we are using nested loops for traversing N^4 times.
Space Complexity: O(N^3), as we are using extra space. */