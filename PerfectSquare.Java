import java.util.*;
public class Solution{
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n=sc.nextInt();

        for(int i=0;i<n;i++){
            int sqr=i*i;
            if(sqr==n){
                System.out.println("true");
            }
        }
        
    }
}