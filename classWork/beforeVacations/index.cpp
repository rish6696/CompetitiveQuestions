#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;



void display(vector<int> &arr,int start){
  if(start==arr.size())return;
  cout<<arr[start]<<" ";
  display(arr,start+1);
}

bool find(vector<int> arr,int val,int start){
    if(start==arr.size())return false;
    if(arr[start]==val)return true;
    return find(arr,val,start+1);
}
int maximum(vector<int> &arr,int start){
    if(start==arr.size()-1)return arr[arr.size()-1];
    int recans=maximum(arr,start+1);
    return max(recans,arr[start]);
}
int minimum(vector<int> &arr,int start){
    if(start==arr.size()-1)return arr[arr.size()-1];
    int recans=minimum(arr,start+1);
    return min(recans,arr[start]);
}

int lastIndex(vector<int> &arr,int vindex,int val){
    if(vindex==-1)return -1;
    if(arr[vindex]==val)return vindex;
    return lastIndex(arr,vindex-1,val);
}

int lastIndexFromStart(vector<int> &arr,int start,int val){
    if(start==arr.size())return -1;
    int recAns=lastIndexFromStart(arr,start+1,val);
    if(recAns==-1){
        if(arr[start]==val) return start;
        return -1;
    }
    return recAns;
}


void solve(){
  vector<int> arr={10,6,8,10,4,5,5,6,8,-3,2,12,8,3};
 // display(arr,0);
 //cout<<"ans is ";
  //cout<<find(arr,4,0);
  //cout<<maximum(arr,0);
  //cout<<lastIndex(arr,arr.size()-1,49);
 // cout<<minimum(arr,0);
 cout<<lastIndexFromStart(arr,0,98);
}


int main(int args,char** argsv){ 
    solve();
    return 0;
 }