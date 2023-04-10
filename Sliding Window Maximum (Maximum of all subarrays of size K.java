//Sliding Window Maximum (Maximum of all subarrays of size K)
/*
 * Examples : 

Input: arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6}, K = 3 
Output: 3 3 4 5 5 5 6
Explanation: Maximum of 1, 2, 3 is 3
                       Maximum of 2, 3, 1 is 3
                       Maximum of 3, 1, 4 is 4
                       Maximum of 1, 4, 5 is 5
                       Maximum of 4, 5, 2 is 5 
                       Maximum of 5, 2, 3 is 5
                       Maximum of 2, 3, 6 is 6

Input: arr[] = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13}, K = 4 
Output: 10 10 10 15 15 90 90
Explanation: Maximum of first 4 elements is 10, similarly for next 4 
                       elements (i.e from index 1 to 4) is 10, So the sequence 
                       generated is 10 10 10 15 15 90 90
 */


public class GFG{
    // Method to find the maximum for
    // each and every contiguous
    // sub-array of size K.
    static void printKMax(int arr[],int N, int K)
    {
        int j, max;
        for(int i=0;i<=N-K;i++){
            max=arr[i];
            for(j=1;j<K;j++){
                if(arr[i+j]>max)
                  max=arr[i+j];
            }
            System.out.print(max+" ");
        }
    }
 
    //Driver code
    public static void main(String args[])
    {
        int arr[]={1,2,3,4,5,6,7,8,9,10};
        int K=3;

        //Function call
        printKMax(arr,arr.length,K);
    }
}

/*
 * Output
3 4 5 6 7 8 9 10 
Time Complexity: O(N * K), The outer loop runs N-K+1 times and the inner loop runs K times for every iteration of the outer loop. So time complexity is O((n-k+1)*k) which can also be written as O(N * K)
Auxiliary Space: O(1)
 */