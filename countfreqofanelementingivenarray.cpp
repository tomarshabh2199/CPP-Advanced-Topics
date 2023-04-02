#include<iostream>
#include<unordered_map>
#include<map>

#include<string>
#define ff first;
#define ss second
#define vi vector<int>
#define pii pair<int,int>
#define vii vector<pii>
#define setBits(x) builtin_popcount(x)
using namespace std;

signed main(){

    int n;
    cin>>n;
    vi a(n);

    for(int i=0;i<n;i++)
        cin>>a[i];
    unordered_map<int,int>freq;
    for (int i = 0; i <n; i++)
    {
        freq[a[i]]++;
    }
    unordered_map<int,int>::iterator it;
    for(it=freq.begin();it!=freq.end();it++)
    {
        cout<<it->ff<<" "<<it->ss<<endl;
    }
    return 0;
}