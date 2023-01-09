// Set to Vector in C++
// There are 4 methods to Convert a set into a vector:

// Using Range Constructor
// Using Push_back()
// Using Copy function
// Using vector::assign function 

#include<bits/stdc++.h>
using namespace std;

int main(){

    //Set  declared
    set<int>st={1,2,3,4,5,6};
    cout<<"Original Set elements\n";
    for(auto i:st)
       cout<<i<<"";

    // range constructor from
    // st.begin() to st.end()
    // vector declared with values

    vector<int> vc(st.begin(), st.end());

    cout<<"Printing Vector after conversion\n";
    for (int i:vc)
       cout<<i<<"";
    cout<<endl;

    return 0;
}


Output
Original Set elements
1 2 3 5 7 9 
Printing Vector after conversion
1 2 3 5 7 9


// C++ program to Convert Set To Vector
// using push_back()
#include <bits/stdc++.h>
using namespace std;
 
int main()
{
    // Set declared
    set<int> st = { 1, 2, 3, 7, 9, 5 };
 
    cout << "Original Set elements\n";
    for (int i : st)
        cout << i << " ";
    cout << endl;
 
    // vector declared
    vector<int> vc;
 
    // Inserting elements into vector using
    // push_back function
    for (auto& it : st) {
        vc.push_back(it);
    }
 
    cout << "Printing Vector after conversion\n";
    for (int i : vc)
        cout << i << " ";
    cout << endl;
 
    return 0;
}