// Java Program Illustrating How to Check if a Thread Holds
// Lock on a Particular Object
 
// Importing the libraries

import java.io.*;
import java.util.*;


//Main class

class GFG{

    //Creating the constructor
    GFG()
    {
        //Checking the status of the lock on the object
        System.out.println(Thread.holdsLock(this));

        //Synchronizing the thread
        synchronized(this)
        {
           // Checking the status of the lock on the object
            // using holdsLock() method over
            // same thread using this keyword
            System.out.println((Thread.holdsLock(this));
        }
    }

    //Main driver method
    public static void main(String[] args)
    {
        // Creating a Thread class object
        Thread ob=new Thread(){
            // run() method for this thread which
            // is invoked as start() method is invoked

            public void run()
            {
              // run() method for this thread which
              // is invoked as start() method is invoked  
            }
        };
        // Starting the thread with
        // the help of start() method
        ob.start();
    }
}