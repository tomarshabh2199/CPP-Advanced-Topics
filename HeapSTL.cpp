#include<iostream>
using namespace std;


#include<string>
#define ff first;
#define ss second
#define vi vector<int>
#define pii pair<int,int>
#define vii vector<pii>
#define setBits(x) builtin_popcount(x)

#define rep(i,a,b) for(int i=a;i<b;i++)

signed main(){
   
    // max heap declaration
    priority_queue<int, vector<int>> pq;
    pq.push(2);
    pq.push(1);
    pq.push(3);


    cout<<pq.top()<<"";
    pq.pop();
    cout<<pq.top()<<"";
     priority_queue<int, vector<int>, greater<int>> pqm;
     pqm.push(2);
     pqm.push(1);
     pqm.push(3);
     cout<<pqm.top()<<endl;
     pqm.pop();
     cout<<pqm.top()<<endl;
     return 0;

}