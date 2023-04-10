//Print all subsequences of a string
/*
 * Given a string, we have to find out all its subsequences of it. A String is a subsequence of a given String, that is generated by deleting some character of a given string without changing its order.

Examples: 

Input : abc
Output : a, b, c, ab, bc, ac, abc

Input : aaa
Output : a, a, a, aa, aa, aa, aaa
 */

import java.util.*;
class GFG{
    //Declare a global list
    static List<String>al=new ArrayList<>();
    // Creating a public static Arraylist such that
    // we can store values
    // IF there is any question of returning the
    // we can directly return too// public static
    // ArrayList<String> al = new ArrayList<String>();

    public static void main(String[] args)
    {
        String s="abcd";
        findsubsequences(s,"");//calling a function
        System.out.println(al);
    }

    private static void findsubsequences(String s,String ans)
    {
        if(s.length()==0){
            al.add(ans);
            return;
        }
        // We add adding 1st character in string
        findsubsequences(s.substring(1),ans+s.charAt(0));

        // Not adding first character of the string
        // because the concept of subsequence either
        // character will present or not
        findsubsequences(s.substring(1),ans);
    }
}