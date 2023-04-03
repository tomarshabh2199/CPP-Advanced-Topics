/*
What is Size Limited Queue?
Size limited queue is the same as a normal queue but it has the special property that at any time queue can store at max N element, if we try to push more than N elements in the queue then accordingly the elements added at the starting will be removed from the queue means size will remain to fix i.e. N. 
*/

import java.util.LinkedList;
import java.util.Queue;

class GFG{
    // Class SizeLimitedQueue which extends
    // LinkedList

    // SizeLimitedQueue class is
    // implementation of Limited-Size Queue

    public static class SizeLimitedQueue<E> extends LinkedList<E>{
        // Variable which store the
        // SizeLimitOfQueue of the queue

        private int SizeLimitOfQueue;

        // Constructor method for initializing
        // the SizeLimitOfQueue variable
        
        public SizeLimitedQueue(int SizeLimitOfQueue)
        {
            this.SizeLimitOfQueue=SizeLimitOfQueue;
        }
        // Override the method add() available
        // in LinkedList class so that it allow
        // addition  of element in queue till
        // queue size is less than
        // SizeLimitOfQueue otherwise it remove
        // the front element of queue and add
        // new element
        
        @Override
        public boolean add(E o)
        {
            // If queue size become greater
            // than SizeLimitOfQueue then
            // front of queue will be removed

            while(this.size()==SizeLimitOfQueue){
                super.remove();
            }
            super.add(o);
            return true;
        }
    }

    //Driver Code
    public static void main(String[] args)
    {
        // Create queue with size
        // SizeLimitOfQueue as 3

        Queue<Integer>q=new SizeLimitedQueue<>(3);

        // Adds elements {0, 1, 2, 3, 4} to
        // the queue
        for(int i=0;i<5;i++)
         q.add(i);
         // So now queue is [2, 3, 4] as [0, 1]
        // removed due to size
        // SizeLimitOfQueue of 3

        // To view Size of the queue
        int size=q.size();
        System.out.println("Size of queue-" + size);

        // Display contents of the queue.
        System.out.println("Elements of queue " + q);

         // To remove the head of queue.
        int removedele = q.remove();
        System.out.println("Removed element-" + removedele);
  
        // Add elements {5, 6} to
        // the queue
        for (int i = 5; i < 7; i++)
            q.add(i);
  
        // Display contents of the queue.
        System.out.println("Elements of queue " + q);
  
        // To view the head of queue
        int head = q.peek();
        System.out.println("Head of queue-" + head);
  
        // To view Size of the queue
        size = q.size();
  
        System.out.println("Size of queue-" + size);
    }
}

/*
Output
Size of queue-3
Elements of queue [2, 3, 4]
Removed element-2
Elements of queue [4, 5, 6]
Head of queue-4
Size of queue-3
*/