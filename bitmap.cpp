#include<iostream>
using namespace std;

//<< left shit operator

int getBit(int n, int pos){
    return ((n & (1<<pos))!0);
}


//set bit
int setBit(int n, int pos){
    return (n |(1<<pos));
}

//clear bit marking bit as 0 and keep 1 as it is
int clearBit(int n, int pos){
    int mask=~(1<<pos);
    return (n&mask);
}

//update Bit
int updateBit(int n, int pos,int value){
     int mask=~(1<<pos);
     n=n&mask;
     return (n| (value<<pos));

}

int main(){
    cout<<setBit(5,1)<<endl;
    cout<<clearBit(5,2)<<endl;
    cout<<updateBit(5,1,1)<<endl;
    cout<<getBit(5,2)<<endl;
    return 0;
}