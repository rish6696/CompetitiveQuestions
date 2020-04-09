#include<iostream>
#include<vector>
using namespace std;


void reverseEngneering(int idx,int target,vector<vector<bool>>&arr,vector<int>&nums,string ans) {

    if(target==arr[0].size()-1){
        cout<<ans<<endl;
        return ;
    }

    //select
    if(target+nums[idx]<=arr[0].size()-1 &&  arr[idx+1][target+nums[idx]]){
       reverseEngneering(idx,target+nums[idx],arr,nums,ans+to_string(nums[idx])+" ");
    }

    //not select 
    if(arr[idx+1][target]){
        reverseEngneering(idx+1,target,arr,nums,ans);
    }

}


void display2D(vector<vector<bool>>&arr){

    for(int i =0;i<arr.size();i++){
        for(int j =0;j<arr[0].size();j++){
            cout<<arr[i][j]<<" ";
        }
        cout<<endl;
    }
}


bool subset(vector<int>&arr,int target){
    vector< vector<bool> > dp ( arr.size()+1,   vector<bool>(target+1,false));
    
    for(int idx=dp.size()-1;idx>=0;idx--){
        for(int t =dp[0].size()-1;t>=0;t-- ){
            
            if(t==target){
                dp[idx][t]=true;
                continue;
            }
            
            if(idx==arr.size()) continue;
            bool left =false;
            bool right =false;
            // select 
            
            if(t+arr[idx]<=target){
                left = dp[idx][t+arr[idx]];
            }
            
            //not select 
            right = dp[idx+1][t];
            dp[idx][t] = left || right ? true :false;
        }
    }
    //display2D(dp);
   reverseEngneering(0,0,dp,arr,"");
    return dp[0][0];
}
int main(){ 

    vector<int> arr ={1,2,3,4,5,6,7};
    int target = 8;
    cout<<subset(arr,target)<<endl;
    return 0; 
}