
// 2. Return 2D Array from Function in C++
// Using Static Keyword




#include<iostream>
using namespace std;
const int N=3;

// function for display array
void printArray(int arr[][N])
{
    for (int i=0;i<N; ++i){
        for(int j=0; j<N; ++j){
            cout<<arr[i][j]<<"";
        }
        cout<<endl;
    }
}

//function to initialize and returning array

int (*(getArray)())[N]
{
    static int arr[N][N]={{0,1,2},{3,4,5},{6,7,8}};
    return arr;
}

//Driver Code
int main(){
    int(*arr)[N];
    arr=getArray();
    printArray(arr);
    return 0;
}


Output
0 1 2 
3 4 5 
6 7 8 