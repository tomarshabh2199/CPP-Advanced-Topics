#include<iostream>
using namespace std;

int countPathMaze(int n, int i, int j){

    //Base case to reach end
    if(i==n-1 && j==n-1){
        return 1;
    }
    
    // when out of range
    if(i>=n || j>=n){
        return 0;
    }

    return countPathMaze(n,i+1,j)+countPathMaze(n,i,j+1);
}

int main(){
    cout<<countPathMaze(3,0,0)<<endl;
    return 0;
}
