#include<iostream>
#include<vector>
#include<bits/stdc++.h>
using namespace std;


void display(vector<int>&arr){
    for (int i = 0; i < arr.size(); i++)
    {
        cout<<arr[i]<<" ";
    }
    cout<<endl;
    
}


//this approach takes o(n2) time
int optimised(vector<int>&nums){

    int ans =0;
    

}


 int sol(vector<int>&nums,vector<int>&ans,int idx,int k){
        if(ans.size()==2){
         display(ans);
         return 1;
        }
        int c =0;
        
        for(int i=idx;i<nums.size();i++){
            if(i==idx||nums[i-1]!=nums[i]){
            if(ans.size()==0){
                ans.push_back(nums[i]);
                c+=sol(nums,ans,i+1,k);
                ans.erase(ans.begin()+ans.size()-1);
            }else{
                int rvt=ans[0];
                if(abs(rvt-nums[i])==k){
                ans.push_back(nums[i]);
                c+=sol(nums,ans,i+1,k);
                ans.erase(ans.begin()+ans.size()-1);
                }
                
            }
            }
        }
        
        return c;
    }

int main(){
    vector<int> arr={3,1,4,1,5};
    sort(arr.begin(),arr.end());
    int k =2;
    vector<int> ans;
    cout<<sol(arr,ans,0,k)<<endl;
    return 0;
}