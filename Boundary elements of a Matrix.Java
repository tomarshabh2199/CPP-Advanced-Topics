/*Boundary elements of a Matrix
*/
/*
1. Printing Boundary Elements of a Matrix:
Given a matrix of size n x m. Print the boundary elements of the matrix. Boundary elements are those elements that are not surrounded by elements in all four directions, i.e. elements in the first row, first column, last row, and last column

Examples: 

Input:  1 2 3 4  
        5 6 7 8
        1 2 3 4
        5 6 7 8

Output : 


         1 2 3 4 
         5       8 
         1       4 
         5 6 7 8

Input:
             1 2 3   
             5 6 7 
             1 2 3 

Output: 

        1 2  3
        5    7
        1 2 3
        
        Approach: To solve the problem follow the below idea: 

The idea is simple. Traverse the matrix and check for every element if that element lies on the boundary or not,
 if yes then print the element else print space character

Follow the given steps to solve the problem:

Traverse the array from start to end
Assign the outer loop to point to the row and the inner row to traverse the elements of row
If the element lies in the boundary of matrix, then print the element, i.e. if the element lies in 1st row, 1st column, last row, last column
If the element is not a boundary element print a blank space
 */

 // JAVA Code for Boundary elements of a Matrix

 import java.io.*;
 public class GFG{

    public static void printBoundary(int a[][],int m, int n){
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0)
                  System.out.print(a[i][j]+" ");
                else if (i==m-1)
                  System.out.println(a[i][j]+" ");
                else if(j==0)
                  System.out.print(a[i][j]+" ");
                else if (j==n-1)
                  System.out.print(a[i][j]+" ");
                else 
                  System.out.print("");
            }
            System.out.print("");
        }
    }
    //Driver code
    public static void main(String[] args)
    {
        int a[][]={ { 1, 2, 3, 4 },
                    { 5, 6, 7, 8 },
                    { 1, 2, 3, 4 },
                    { 5, 6, 7, 8 } };

        //Function call
        printBoundary(a,4,4);
    }
 }

 /*
  * Output
1 2 3 4 
5     8 
1     4 
5 6 7 8 
Time Complexity: O(N2), where N is the size of the array.
Auxiliary Space: O(1)
  */