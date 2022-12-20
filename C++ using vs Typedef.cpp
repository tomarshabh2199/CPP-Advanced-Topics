// Using in C++ STL
// The using keyword in C++ is used to bring a specific member or all members into the current scope and bring base class variables/methods into the derived class’s scope.

// Syntax:

// typedef <current_name> <new_name>
// Example:

// typedef std::vector<int> vInt;


// Syntax:

// using <member_name> 
// Example:

// using std::cout;


#include<bits/stdc++.h>
using namespace std;

int main(){

    // Now we can make more vectors by using vInt
    using vInt=std::vector<int>;

    //vec1 is a vectorof type int

    vInt v;
    v.push_back(190);
    v.push_back(180);
    v.push_back(90);
    v.push_back(100);
    v.push_back(110);
    v.push_back(120);

    for (auto X : v) {
        cout << X << " ";
    }
    
    return 0;
}


typedef with pointers: typedef will also work with the pointer in C/C++ language like renaming existing keywords. In case of pointers * binds in the right not the left side.

// int* x, y;
// In the above syntax, we are actually declaring x as a pointer of type int, whereas y will be declared as a plain integer But if we use typedef then we can declare any number of pointers in a single statement like below.


// typedef int* IntPtr ;
// IntPtr x, y, z;
// typedef can be used for :

// typedef can provide a simple name for a complicated type cast
// typedef can also be used to give names to unnamed types. In such cases, the typedef will be the only name for said type