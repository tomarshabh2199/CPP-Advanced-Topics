import java.util.*;
public class Solution{
     public static void main(String[] args) {
      Scanner sc=new Scanner(System.in);
       
      String st=sc.nextLine();
      String str=st.toLowerCase();
      int vowel=0, cons=0;

      for(int i=0;i<str.length();i++){
        char ch=str.charAt(i);
        if(ch=="a"|| ch=="e" || ch=="i" || ch=="o"|| ch="u"){
            vowel++;
        }
        else if(ch>'a' && ch<'z'){
            cons++;
        }
      }
      System.out.println("no of vowels"+vowel);
      System.out.println("no of consonant"+cons);
    }
}