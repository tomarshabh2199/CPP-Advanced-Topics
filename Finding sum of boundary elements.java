/*
 * 2. Finding sum of boundary elements:
Given a matrix of size n x m. Find the sum of boundary elements of the matrix. Boundary elements are those elements which are not surrounded by elements in all four directions, i.e. elements in the first row, first column, last row, and last column

Examples:  

Input:  1 2 3 4  
        5 6 7 8
        1 2 3 4
        5 6 7 8

Output: 54
Explanation: The boundary elements of the matrix 

         1 2 3 4 
         5       8 
         1       4 
         5 6 7 8

Sum = 1+2+3+4+5+8+1+4+5+6+7+8 = 54

Input:  1 2 3
        5 6 7 
        1 2 3 

Output: 24
Explanation: The boundary elements of the matrix

        1 2 3   
        5   7 
        1 2 3  

Sum = 1+2+3+5+7+1+2+3 = 24
 */

 /*
  * 
To solve the problem follow the below idea: 

The idea is simple. Traverse the matrix and check for every element if that element lies on the boundary or not, if yes then add them to get the sum of all the boundary elements

Follow the given steps to solve the problem:

Create a variable to store the sum and Traverse the array from start to end
Assign the outer loop to point to the row and the inner row to traverse the elements of the row
If the element lies in the boundary of the matrix then add the element to the sum, i.e. if the element lies in the 1st row, 1st column, last row, and last column
Print the sum
  */
// JAVA Code for Finding sum of boundary elements
import java.io.*
public class GFG{

    public static long getBoundarySum(int a[][], int m, int n)
    {
        long sum=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0)
                  sum+=a[i][j];
                else if(i==m-1)
                   sum+=a[i][j];
                else if(j==0)
                  sum+=a[i][j];
                else if(j==n-1)
                  sum+=a[i][j];
            }
        }
        return sum;
    }
}


/*
 * Output
Sum of boundary elements is 54
Time Complexity: O(N2), where N is the size of the array
Auxiliary Space: O(1)
 */