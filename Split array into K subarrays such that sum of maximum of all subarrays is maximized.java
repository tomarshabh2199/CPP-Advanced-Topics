import java.util.*;
public class GFG{
    // Function to split the array into K
    // sub-arrays such that the sum of
    // maximum of each sub-array is maximized

/*
 * Given an array arr[] of size N and a number K, the task is to partition the given array into K contiguous subarrays such that the sum of the maximum of each subarray is the maximum possible. If it is possible to split the array in such a manner, then print the maximum possible sum. Otherwise, print “-1“.

Examples:

Input: arr[] = {5, 3, 2, 7, 6, 4}, N = 6, K = 3
Output: 18
              5
              3 2 7
              6 4
Explanation:
One way is to split the array at indices 0, 3 and 4.
Therefore, the sub-arrays formed are {5}, {3, 2, 7} and {6, 4}.
Therefore, sum of the maximum of each sub-array = 5 + 7 + 6 =18 ( which is the maximum possible).

Input: arr[] = {1, 4, 5, 6, 1, 2}, N = 6, K = 2 
Output: 11

 */
    static void partitionIntoKSegments(int arr[], int N, int K)
    {
        //If N is less than K
        if(N<K)
        {
            System.out.println(-1);
            return;
        }
        // Map to store the K
        // largest elements
        HashMap<Integer,Integer>mp=new HashMap<Integer,Integer>();

        // Auxiliary array to
        // store and sort arr[]

        Integer []temp=new Integer[N];

        //Stores the maximum sum
        int ans=0;

        // Copy arr[] to temp[]
        for(int i=0;i<N;i++)
        {
            temp[i]=arr[i];
        }

        // Sort array temp[] in
        // descending order

        Arrays.sort(temp, Collections.reverseOrder());
        //Array.Reverse(temp);

        //Iterate in the range[0,k-1]
        for(int i=0;i<K;i++)
        {
            //Iterate in the range [0,K-1]
            for(int i=0;i<K;i++)
            {
                //Increment sum by temp[i]
                ans+=temp[i];
               
                 // Increment count of
                 // temp[i] in the map mp
                 
                 if(mp.containsKey(temp[i]))
                   mp.get(temp[i]++);
                else
                   mp.put(temp[i],1);
            }
             // Stores the partitions
             ArrayList<ArrayList<Integer>>P=new ArrayList<ArrayList<Integer>>();

             // Stores temporary subarrays
             ArrayList<Integer>V =new ArrayList<Integer>();

             //Iterate over the range[0,N-1]
             for(int i=0;i<N;i++)
             {
                V.add(arr[i]);
                // If current element is
                // one of the K largest
                if(mp.containsKey(arr[i]) && mp.get(arr[i])>0)
                {
                    mp.get(arr[i]--);
                    K--;
                    if(K==0)
                    {
                        i++;

                        while(i<N)
                        {
                            V.add(arr[i]);
                            i++;
                        }
                    }

                    if(V.size()>0)
                    {
                        P.add(new ArrayList<Integer>(V));
                        V.clear();
                    }
                }

             }
             //Print the ans
             System.out.println(ans);

             //Print the partition
             for(ArrayList<Integer>subList:P)
             {
                for(Integer item:subList)
                {
                    System.out.println(item+" ");
                }
                System.out.println();
             }

        }


        //Driver code
        public static void main(String[] args)
        {
            //Input
            int []A={5,3,2,7,6,4};
            int N=A.length;
            int K=3;

            //Function call
            partitionIntoKSegments(A,N,K);
        }
    }
}

/*
Output: 
18
5 
3 2 7 
6 4
 

Time Complexity: O(N*log(N))
Auxiliary Space: O(N)
*/