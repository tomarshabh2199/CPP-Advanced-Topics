#include<iostream>
using namespace std;


int setBit(int n, int pos){
	return ((n & (1<<pos))!=0);
}

void unique(int arr[], int n){
	int xorsum=0;

	// Doing xor for all the array elements of array.
	for(int i=0; i<n; i++){
		xorsum=xorsum^arr[i];
	}
	int tempxor=xorsum;
	int setBit=0;  // initialization
	int pos=0; //finding and iterating pos

	while(setBit!=1){
		setBit=xorsum & 1;
		pos++; //next position
		xorsum=xorsum >> 1; //right shift the value by 1
	}
	int newxor=0;
	for(int i=0; i<n; i++){
		if(setBit(arr[i], pos-1)){
			newxor=newxor^arr[i];
		}
	}

	cout<<newxor<<endl;  // first unique
	cout<<(tempxor^newxor)<<endl; // second uniue element
}

int main(){
	int arr=[1,2,1,3,2,4,3,5,7]
	cout<<unique(arr,9)<<endl;
	return 0;
}
