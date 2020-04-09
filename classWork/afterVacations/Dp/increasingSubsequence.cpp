#include<iostream>
#include<vector>
using namespace std;


int longestIncsubsequence(vector<int>&arr,int idx,int lastIndex,vector< vector<int> >&dp){

    if(idx==arr.size()) return 0;

    if(dp[idx][lastIndex]!=-1){
        cout<<"returned from dp"<<endl;
       return dp[idx][lastIndex];
    } 

    int ans =INT32_MIN;
    //select
    if( lastIndex==0||arr[idx]>arr[lastIndex-1]){
        ans=max(ans,longestIncsubsequence(arr,idx+1,idx+1,dp)+1);
    }

    //not select 
    ans =max(ans,longestIncsubsequence(arr,idx+1,lastIndex,dp));

    dp[idx][lastIndex]=ans;
    return ans;

}


int main(){
    vector<int> arr ={10, 22, 9, 33, 21, 50, 41, 60, 80};

    vector< vector<int> > dp(arr.size()+1,vector<int>(arr.size()+1,-1));
    cout<<longestIncsubsequence(arr,0,0,dp)<<endl;
    return 0;
}