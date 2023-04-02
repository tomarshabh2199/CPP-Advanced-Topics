// Java Implementation of the approach
//Check whether all the rotations of a given number is greater than or
// equal to the given number or not

class GFG
{
    static void CheckKCycles(int n, String s)
    {
        boolean ff=true;
        int x=0;
        for(int i=1;i<n;i++){

            //Splitting the number at index i
            // and adding to the front
            x=(s.substring(i)+s.substring(0,i)).length();

            //checking if the value is greater than
            // or equal to the given value

            if(x=>s.length())
            {
                continue;
            }
            ff=false;
            break;
        }
         if (ff)
        {
            System.out.println("Yes");
        }
        else
        {
            System.out.println("No");
        }
    }

    // Driver code

    public static void main(String[] args){
        int n=3;
        String s="123";
        CheckKCycles(n,s);
    }
}