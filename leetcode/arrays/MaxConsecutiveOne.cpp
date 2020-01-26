#include<iostream>
#include<vector>
using namespace std;


int maxOne(vector<int>&arr){
    int ans=-1;
    int tempans =0;
    for (int i = 0; i < arr.size(); i++)
    {
        if(arr[i]==0){
           ans=max(ans,tempans);
           tempans=0;
        }else{
          tempans++;
        }
    }

    return max(ans,tempans);
    

}
int main(){ 
    vector<int> arr={1,1,0,1,1,1};
    cout<<maxOne(arr)<<endl;
    return 0;
}
