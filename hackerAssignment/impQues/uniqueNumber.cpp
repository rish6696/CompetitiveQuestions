#include<iostream>
#include<vector>
using namespace std;

int  getUniqueNumber(vector<int>& arr,int k){
  vector<int> bitsArray(32,0);
  int ans=0;
  for(int bit=0;bit<32;bit++){
    int count=0;
    for(int in=0;in<arr.size();in++){
        int val=arr[in];
        if((val&(1<<bit))!=0){
            count++;
        }
    }
    if(count%k!=0){
        ans|=1<<bit;
    }
  }
  return ans;
}
int main(){ 
    vector<int> arr={2,3,2,4,3,2,3};
    cout<<getUniqueNumber(arr,3);
    return 0;
 }