/*
Nuts & Bolts Problem (Lock & Key problem) using Hashmap
*/


/*
Given a set of n nuts of different sizes and n bolts of different sizes.
There is a one-one mapping between nuts and bolts. Match nuts and bolts efficiently. 
Constraint: Comparison of a nut to another nut or a bolt to another bolt is not allowed. It means nut can only be compared with bolt and bolt can only be compared with a nut to see which one is bigger/smaller.
*/

/*
Examples: 

Input : nuts[] = {'@', '#', '$', '%', '^', '&'}
        bolts[] = {'$', '%', '&', '^', '@', '#'}
Output : Matched nuts and bolts are-
        $ % & ^ @ # 
        $ % & ^ @ #  
*/


/*In this post, hashmap based approach is discussed. 

Traverse the nuts array and create a hashmap
Traverse the bolts array and search for it in hashmap.
If it is found in the hashmap of nuts then this means bolts exist for that nut.
*/

//Hashmap based solution to solve

import java.util.HashMap;
class GFG{

    //function to match nuts and bolts
    static void nutboltmatch(char nuts[],char bolts[],int n)
    {
        HashMap<Character,Integer>hash=new HashMap<>();

        //creating a hashmap for nuts
        for(int i=0;i<n;i++)
        hash.put(nuts[i],i);

        //searching for nuts for each bolt in hash map
        for(int i=0;i<n;i++)
          hash.put(nuts[i],i);

        //searching for nuts for each bolt in hashmap
        for(int i=0;i<n;i++)
        if(hash.containsKey(bolts[i]))
          nuts[i]=bolts[i];

        //print the result
        System.out.println("matched nuts and bolts are-");
        for(int i=0;i<n;i++)
          System.out.print(nuts[i]+"");
        System.out.println();
        for(int i=0;i<n;i++)
          System.out.print(bolts[i]+" ");
    }

    //Driver code
    public static void main(String[] args)
    {
        char nuts[]={ '@', '#', '$', '%', '^', '&' };;
        char bolts[]={ '$', '%', '&', '^', '@', '#' };
        int n=nuts.length;
        nutboltmatch(nuts,bolts,n);
    }
}

/*
 * Output
matched nuts and bolts are-
$ % & ^ @ # 
$ % & ^ @ # 
 */
