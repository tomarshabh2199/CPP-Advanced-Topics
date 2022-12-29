//Program to check if a given number is a power of 2

//(n&n-1) has same bits as n except the rightmost set bit
 6      5                           8   7
0110 & 0101 = 0100              1000 & 0111 = 0000

// flip the rightmost digit to find the n-1 number in binary form

// n has only one set bit and n-1 will have all set bits after that position

#include<iostream>
using namespace std;

bool ispowerof2(int n){

    //base case if number will have 0, 0-1
	return (n && !(n & n-1));
}

int main(){
	cout<<ispowerof2(16)<<endl;
}