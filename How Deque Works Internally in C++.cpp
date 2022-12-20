// Practical Applications of Deque
// Deque’s ability to insert and delete from both sides makes it one of the most useful containers in STL. Real-world applications are mentioned below:

// Applied as both stack and queue, as it supports both operations.
// Storing a web browser’s history.
// Storing a software application’s list of undo operations.
// Job scheduling algorithm





// Time Complexity:
// Accessing Elements- O(1)
// Insertion or removal of elements- O(N)
// Insertion or removal of elements at start or end- O(1)


#include<iostream>
#include<deque>

using namespace std;

int main(){

    deque<int>d={1,2,3};

    d.push_back(4);
    d.push_front(0);

    cout<<"Elements in Deque:"<<endl;

    for(int i :d)
      cout<<i<<"";
    cout<<endl;

    d.pop_back();

    cout << "\n"
         << "Elements in Deque after pop_back(): " << endl;
  
    for (int i : d)
        cout << i << " ";
    cout << endl;

    cout << "\n"
         << "Elements in Deque after pop_front(): " << endl;
  
    d.pop_front();

      for (int i : d)
        cout << i << " ";
    cout << endl;
  
    cout << "\n"
         << "Element in front of deque: " << d.front()
         << endl;
    cout << "Element in back of deque: " << d.back()
         << endl;


    cout << "Item at 1th Index: " << d.at(1) << endl;
  
    cout << "Size of deque: " << d.size() << endl;
    cout << "Is deque empty: " << d.empty() << endl;
  
    cout << "\n"
         << "After deleting all elements of deque:"
         << "\n\n";
  
    d.erase(d.begin(), d.end());
  
    cout << "Size of deque: " << d.size() << endl;
    cout << "Is deque empty: " << d.empty() << endl;
}





Output
Elements in Deque: 
0 1 2 3 4 

Elements in Deque after pop_back(): 
0 1 2 3 

Elements in Deque after pop_front(): 
1 2 3 

Element in front of deque: 1
Element in back of deque: 3
Item at 1th Index: 2
Size of deque: 3
Is deque empty: 0

After deleting all elements of deque:

Size of deque: 0
Is deque empty: 1