/* Print Kth boundary of a Matrix /*

/*Given a square matrix mat[][] and a positive integer K.
 The task is to print the Kth boundary of mat[][]. */


 /*Examples: 

Input: mat[][] = {{1,  2,   3,   4,  5},     K = 1
                {6,   7,   8,   9,  10}
                {11, 12, 13, 14, 15}
                {16, 17, 18, 19, 20}
                {21, 22, 23, 24, 25}}
Output:  1 2 3 4 5
        6         10
        11         15
        16         20
        21 22 23 24 25 
Explanation: The first boundary of mat[][] is above.

Input: mat[][] = {{1, 2, 3}, K = 2
                {4, 5, 6}
                {7, 8, 9}}
Output:  5 
*/



/*Approach: This problem is implementation-based. 
Traverse the matrix and check for every element if that element lies on the Kth boundary or not.
If yes then print the element else print space character. 
Follow the steps below to solve the given problem. 

for i in from 0 to N
for j in from 0 to N
if((i == K – 1 or i == N – K) and (j >= K – 1 and j <= N – K))
print mat[i][j]
else if (j == K – 1 or j == N – K) and (i >= K – 1 and i <= N – K):
print mat[i][j]
This will give the required Kth border of mat[][]
Below is the implementation of the above approach.  */

// Java Program to implement
// the above approach

import java.util.*;
public class GFG{
    // Function to print Kth border of a matrix
    static void printKthBorder(int [][]mat,int N, int K)
    {
        for(int i=0;i<N;i++)
        {
            System.out.println();
            for(int j=0;j<N;j++)
            {
                // To keep track of which element to skip
                int flag=0;
                if((i==K-1 || i==N-K) && (j>=K-1 && j<=N-K)){
                    //print the element
                    System.out.print(mat[i][j]+" ");

                    flag=1;
                }

                else if((j==K-1 || j==N-K) && (i>=K-1 && i<=N-K)){
                    // Print the element
                    System.out.print(mat[i][j] + " ");
    
                    flag = 1;
                }
                if(flag==0)
                  System.out.print(" ");
            }
        }
    }

    //Driver code
    public static void main(String args[]){
        int N=5;
        int K=1;

        int[][] mat={{1, 2, 3, 4, 5},
                    {6, 7, 8, 9, 10},
                    {11, 12, 13, 14, 15},
                    {16, 17, 18, 19, 20},
                    {21, 22, 23, 24, 25}};
        
        printKthBorder(mat,N,K);
    }
}

/* Output
1   2  3  4  5 
6           10 
11          15 
16          20 
21 22 23 24 25 
Time Complexity: O(N^2) 
Space Complexity: O(1)*/