/*Form a Rectangle from boundary elements of Matrix using Linked List */

/*Given a Matrix grid[][] of size NxM where N is number of rows and M is number of columns. 
The task is to form a rectangle from boundary elements of grid[][] using linked list having four pointers namely prev, next, top and bottom.
 Print the final linked list. */

 /*Input: A = [[1, 2, 3]
                  [8, 9, 4]
                 [7, 6, 5]]
Output: 1 2 3 4 5 6 7 8 */


/*Approach: This problem can be solved by Performing boundary traversal of matrix and creating nodes for each element and link them using next, prev, bottom or top and create a linked list. 

Follow the steps below:

Step 1: Make grid[0][0] as the head of the Linked list and initialize temp as the head.
Step 2: Traverse through the first row from j=1 to j=m-1 where i=0 and create a node for each element and link them through the next pointer.
Step 3: Traverse through the last column from i=0 to i=n-1 where j=m-1 and create a node for each element and link them through a bottom pointer.
Step 4: Traverse through the last row from j=m-1 to j=0 where i=n-1 and create a node for each element and link them through the prev pointer.
Step 5: Traverse through the first column from i=n-1 to i=0 where j=0 and create a node for each element and link them through the top pointer.
Step 6: Step 2, 3, 4, 5 is repeated till temp.top becomes equal to head.
Step 7: Print the required Linked List. */



// Node Class
class Node{
    int data;
    Node next;
    Node prev;
    Node top;
    Node bottom;
    
    // Constructor to initialize the node object
    Node(int data)
    {
        this.data=data;
        next=null;
        prev=null;
        top=null;
        bottom=null;
    }
}

class GFG{
    //Initialize head

    public Node head=null;

     // function to form square linked list of matrix.
     public void Quad(int[][] grid,int n, int m)
     {
        // initialising A[0][0] as head.
        head=new Node(grid[0][0]);

        //head is assigned to head
        Node temp=head;

        //i is row index, j is column index
        int i=0;
        int j=1;
        
         // loop till temp.top become equal to head.
         while (temp.top != head) {
            // as we iterating over boundary
            // of matrix so we will iterate
            // over first(0) and last(n-1) row
            // and first(0) and last(m-1) column.
 
            // iterating over first i.e 0th row
            // and connecting node.

            if(j<m && i==0){
                temp.next=new Node(grid[i][j]);
                temp=temp.next;
                j+=1;
            }
           
            // iterating over last i.e (m-1)th
            // column and connecting Node.
            else if(j==m && i<n-1){
                i=i+1;
                temp.bottom=new Node(grid[i][j-1]);
                temp=temp.bottom;
            }

            // iterating over last i.e (n-1)th row
            // and connecting Node.
            else if(i==n-1 && j<=m && j>=1){
                if(j==m){
                    j=j-1;
                }
                j=j-1;
                temp.prev=new Node(grid[i][j]);
                temp=temp.prev;
            }
            
            // iterating over first i.e 0th column
            // and connecting Node.
            else if(i<=n-1 && j==0){
                i=i-1;
                temp.top=new Node(grid[i][j]);
                temp=temp.top;
                if(i==1){
                    temp.top=head;
                }
            }
     }
}

//function to print Linked List
public void printList(Node root)
{
    Node temp=root;

    //printing head of linked list
    System.out.print(temp.data+" ");

    // loop till temp.top
    // become equal to head

    while(temp.top!=root){
        //printing the node
        if(temp.next!=null){
            System.out.print(temp.next.data+" ");
            temp=temp.next;
        }
        if(temp.prev!=null){
            System.out.print(temp.prev.data+ " ");
            temp=temp.prev;
        }
        if(temp.bottom!=null){
            System.out.print(temp.bottom.data + " ");
        }

        if(temp.top!=null){
            System.out.print(temp.top.data+ " ");
            temp=temp.top;
        }
    }
}

public static void main(String[] args)
{
    int[][] grid=new int[][] { { 13, 42, 93, 88 },
    { 26, 38, 66, 42 },
    { 75, 63, 78, 12 } };

    // n is the number of rows
    int n=grid.length;

    //m is the no of columns
    int m=grid[0].length;

    GFG l=new GFG();
    
    // Call Quad method to create Linked List.
    l.Quad(grid, n, m);
 
    // Call Quad method to create Linked List.
    l.printList(l.head);

}
/*
Output
13 42 93 88 42 12 78 63 75 26 
Time Complexity: O(N*M) 
Auxiliary Space: O(N*M)
 */