#include<iostream>
#include<vector>
using namespace std;

int totalAttacks(vector<int>&arr,int k){
    int ans =k;
    int poisedTill =arr[0]+k;
    for ( int i=1 ;i<arr.size();i++){
        if(arr[i]<poisedTill){
            ans+=arr[i]+k-poisedTill;
            poisedTill=arr[i]+k;
            
        }else{
            ans+=k;
            poisedTill=arr[i]+k;
        }
    }

    return ans ;
    
}

int main(){
    vector<int> arr={1,2};
    cout<<totalAttacks(arr,2)<<endl;
    return 0;
}