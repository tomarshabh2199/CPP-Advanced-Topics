// Java program to find median of every window of size k in
// an array


import java.util.*;

class GFG{
   // Function to find and return the median of every window of size k
   static void findMedian(int[] arr,int n, int k){
    //Traverse every window of size k
    for(int i=0;i<=n-k;i++){
        // Create a temporary array to store elements of the current window
        int[] temp=new int[k];

        for(int j=0;j<k;j++)
           temp[j]=arr[i+j];

        //sort the temporary array
        Arrays.sort(temp);

        // Print the median element
        // if k is odd, print k/2 th element
        
        if(k%2==1)
           System.out.print(temp[k/2]+" ");
        else // if k is even take average of k/2th and (k + 1) / 2 - 1th element
        System.out.print(((float)temp[k / 2] + (float)temp[(k + 1) / 2 - 1]) / 2 + " ");
    }
   }
   //Driver code
   public static void main(String[] args){
    //input array
    int[] arr={-1,5,13,8,2,3,3,1};
    int n=arr.length;
    int k=3;

    //Function Call
    findMedian(arr,n,k);
   }
}

/*
 * Output
5 8 8 3 3 3 
Time Complexity: O(N*KlogK) 
Auxiliary Space: O(K)
 */