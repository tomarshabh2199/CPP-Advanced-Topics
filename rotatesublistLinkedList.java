/*
 * Rotate the sub-list of a linked list from position M to N
 *  to the right by K places
 */
import java.util.*;

class Solution{
    
    //Definition of node of linked-list
    static class ListNode{
        int data;
        ListNode next;
    }

   // This function take head pointer of list,start and
   // end points of sub-list that is to be rotated and the
   // number k and rotate the sub-list to right by k places.

   static void rotateSubList(ListNode A, int m, int n, int k)
   {
    int size=n-m+1;

    // If k is greater than size of sub-list then
    // we will take its modulo with size of sub-list

    if(k>size){
        k=k%size;
    }
    
    // If k is zero or k is equal to size or k is
    // a multiple of size of sub-list then list 
    // remains intact
    if(k==0 || k==size){
        ListNode head=A;
        while(head!=null){
            System.out.println(head.data);
            head=head.next;
        }
        return;
    }
    
    ListNode link=null; //m-th node
    if(m==1){
        link=A;
    }
     // This loop will traverse all node till
    // end node of sub-list.


    ListNode c=A; // Current traversed node
    int count=0;  // Count of traversed nodes
    ListNode end=null;
    ListNode pre=null; // Previous of m-th node
    while(c!=null){
        count++;

         // We will save (m-1)th node and later
        // make it point to (n-k+1)th node

        if(count==m-1){
            pre=c;
            link=c.next;
        }
        if(count==n-k){
            if(m==1){
                end=c;
                A=c.next;
            }
            else{
                end=c;
                // That is how we bring (n-k+1)th
                // node to front of sub-list.

                pre.next=c.next;

            }
        }
        // This keeps rest part of list intact.
        if(count==n){
            ListNode d=c.next;
            c.next=link;
            end.next=d;
            ListNode head=  A;
            while(head!=null){
                System.out.println(head.data+"");
                head=head.next;
            }
            return;
        }
        c=c.next;
    }
   }
   // Function for creating and linking new nodes
   static ListNode push(ListNode head, int val){
    ListNode new_node=new ListNode();
    new_node.data=val;
    new_node.next=(head);
    (head)=new_node;
    return head;
   }

   //Driver code
   public static void main(String args[])
   {
    ListNode head=null;
    head=push(head,70);
    head=push(head,60);
    head=push(head,50);
    head=push(head,40);
    head=push(head,30);
    head=push(head,20);
    head=push(head,10);
    ListNode tmp=head;
    System.out.print("Given List:");
    while(tmp!=null){
        System.out.print(tmp.data+" ");
        tmp=tmp.next;
    }
    System.out.println();

    int m=3,n=6, k=2;
    System.out.print("After rotation of sub-list:");
    rotateSubList(head,m,n,k);
   }
}

//Given List: 10 20 30 40 50 60 70 
//After rotation of sub-list: 10 20 50 60 30 40 70


/*
 * Complexity Analysis:

Time complexity: O(N) where N is the size of the given linked list
Auxiliary Space: O(1)  
 */