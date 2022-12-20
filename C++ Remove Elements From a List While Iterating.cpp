// Removing Element using Single Iterator
// Iterating in for loop:

#include<iostream>
#include<list>
using namespace std;


// Function to print elements from list while iterating

void print(list<int> & li)
{
    auto it=li.begin();
    if(it==li.end()){
        cout<<"List is Empty"<<endl;
    }

    for(it; it!=li.end(); it++){
        cout<<*it<<" ";
    }
    cout<<endl;
}

// Function to delete elements from the list while 
// Iterating 

void solve(list<int>& li)
{
    list<int>:: iterator it;

    // Before Deletion
    cout<<"Before Deletion:"<<endl;
    cout<<"Size of list:"<< li.size()<<endl;
    print(li);

    //Deleting element from list while iterating through it--

    for (auto it=li.begin();it!=li.end();it++){
        if(*it%3==0){
            it=li.erase(it);
            it--;
        }
    }

    //After Deletion
    cout<<"\nAfter Deletion:"<<endl;
    cout<<"Size of list:"<< li.size()<<endl;
    print(li);
}

// Driver code

int main(){
    list<int> li={1,2,3,4,5,6,7,8};
    solve(li);
    return 0;
}


Output
Before Deletion: 
Size of List: 6
1 2 3 5 4 6 

After Deletion: 
Size of List: 4
1 2 5 4 
