// C++ code demonstrating the use 
// of cend() function in deque
// to print elements in reverse
// order


/* cend() Function in C++ */
#include<iostream>
#include<deque>
using namespace std;

// Driver code
int main(){
//Initialising the deque
deque<int>d={1,2,3,4,5};

// C++ code demonstrating the use 
// of cend() function in deque
// to print elements in reverse
// order

for(auto it=d.cend()-1;it>=d.cbegin();--it)
  cout<<*it<<" ";
  cout<<endl;
  return 0;
}
/*
Output
Elements of deque in reverse order: 
5 4 3 2 1 
*/