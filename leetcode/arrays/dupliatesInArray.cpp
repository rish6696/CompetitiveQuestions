#include<iostream>
#include<vector>
#include<cstdlib>
using namespace std;

 vector<int> findDuplicates(vector<int>& arr) {
        vector<int> ans;
        for(int i=0;i<arr.size();i++){
            int val=abs(arr[i]);
            if(arr[val-1]<0){
                ans.push_back(val);
            }else{
                arr[val-1]=-arr[val-1];
            }
        }
        return ans;
        
        
        
    }
int main(){
    vector<int> arr={4,3,2,7,8,2,3,1};
     vector<int> ans =findDuplicates(arr);
     for (int i = 0; i < ans.size(); i++)
     {
         cout<<ans[i]<<" ";
     }
     cout<<endl;
     
     return 0;
}