
/*Count Sub-array of size K in given Array with given LCM */

/* Given an array arr[] of length N, the task is to find the number of subarrays where the least common multiple (LCM) 
of the sub-array is equal to K and the size of that subarray is S.*/


/*Examples:

 Input: arr[] = {1, 2, 3, 4, 5, 6}, K = 6, S = 2
Output: 1
Explanation: {1, 2, 3 }, {2, 3}, {6}
There are 3 sub-arrays that can be generated from the main array with each having its LCM as 6. Out of which only {2, 3} is the length of 2. 

Input: arr[] = {3, 6, 2, 8, 4}, K = 6, S = 2
Output: 2
Explanation: {3, 6}, {6, 2}
There are only 2 sub-arrays having LCM as 6 and length as 2. */



/*
 * Approach: Implement the idea below to solve the problem

Maintain two loops, so as to calculate LCM starting from each index of arr[]. When the LCM get’s equal to K, check the length of the subarray.   

Steps were taken to solve the problem:

Initialize count = 0, to count the number of sub-arrays.
Maintain a loop to iterate through each index of array arr[].
Initialize LCM = arr[i], then again start a loop from that index to the end of array arr[].
Find the LCM of the lcm calculated till now for the current sub-array and arr[j] as LCM =( a * b ) / GCD(a, b).
When LCM gets equal to given K and the size of the sub-array is equal to S, increment in count variable by 1.
Whenever LCM gets greater than k, Break the inner loop. As the LCM is going to increase or stay same, it is never going to decrease.
 */


import java.io.*;

class GFG{
     // Function to calculate GCD
     static int gcd(int a, int b){
        return b==0 ?a:gcd(b,a%b);
     }


      // Function to calculate GCD
      static int LCM(int a,int b){
        int prod=a*b;
        return prod/gcd(a,b);
      }

    // Function to calculate number of sub-arrays
    // where LCM is equal to k and
    // size of sub-array is S

    static int subarrayEqualsLCMSize(int[] arr,int k, int S,int N)
    {
        // Initialize variable to store number of sub-arrays
        int count=0;

        // Generating all sub-arrays
        for(int i=0;i<N;i++){
            int lcm=arr[i];
            for(int j=i;j<N;j++){
                // Function call to calculate lcm
                lcm=LCM(lcm,arr[j]);

                // Check the conditions given
                if(lcm==k && j-i+1==S)
                {
                    count++;
                }
                // If LCM becomes larger than k,
                // break as LCM is never going to
                // decrease

                if(lcm>k){
                    break;
                }
            }
        }
        // Return the count of sub-arrays
        return count;
    }

    public static void main(String[] args){
        int[] arr={3,2,6,8,4};
        int N=arr.length;
        int K=6,S=2;

        //Function call
        System.out.print(subarrayEqualsLCMSize(arr, K, S, N));
    }
}


/*
 * Output
     2
   Time Complexity: O(N2 * Log N)
   Auxiliary Space: O(1)
 */