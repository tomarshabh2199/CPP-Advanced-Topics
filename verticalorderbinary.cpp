
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

#define rep(i,a,b) for(int i=a;i<b;i++)

using namespace std;

struct Node{
    int key;
    Node *left, *right;
};

Node* newNode(int key)
{
    Node* node = new Node;
    node->key = key;
    node->left = node->right = NULL;
    return node;
}

void getVerticalOrder(Node* root, int hdis, map<int,vi>&m)
{
    if(root==NULL)
       return;
    m[hdis].push_back(root->key);
    getVerticalOrder(root->left,hdis-1,m);
    getVerticalOrder(root->right,hdis+1,m);
}

signed main(){
    Node* root= newNode(10);
    root->left= newNode(7);
    root->right= newNode(1);
    root->left->left= newNode(3);
    root->left->right= newNode(11);
    root->right->left=newNode(14);
    root->right->right=newNode(6);
    
    map<int,vector<int>> m;
    int hdis=0;

    getVerticalOrder(root,hdis,m);
    map<int,vi>::iterator it;

    for(it=m.begin();it!=m.end();it++){
        for(int i=0;i<(it->ss).size();i++){
            cout<<(it->ss)[i]<<"";
        }
        cout<<endl;
    }
    return 0;
}