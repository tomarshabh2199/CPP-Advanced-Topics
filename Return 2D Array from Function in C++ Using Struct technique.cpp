
// Return 2D Array from Function in C++
// Using Struct technique


#include<iostream>
using namespace std;
const int N=3;

//structure of array

struct ArrStruct{
   int arr[N][N];
};

//function for display array

void printArray(ArrStruct var)
{
    for(int i=0; i<N; ++i){
        for(int j=0; j<N; ++j){
            cout<<var.arr[i][j]<<"";
        }
        cout<<endl;
    }
}

// Function to initialize and returning array

ArrStruct getArray()
{
    ArrStruct var;
    for(int i=0; i<N;++i){
        for(int j=0;j<N;++j){
            var.arr[i][j]=i+j;
        }
    }
    return var;
}

// Driver code

int main(){
    ArrStruct arr;
    arr=getArray();
    printArray(arr);
    return 0;
}

Output
0 1 2 
1 2 3 
2 3 4 