#include<iostream>
#include<vector>
using namespace std;


int bellTriangle(int n){
    vector<vector<int>> dp (n,vector<int>(n,0));
    dp[0][0]=1;

    for(int i =1;i<dp.size();i++){
        for(int j =0;j<dp[0].size();j++){

            if(j==0){
               dp[i][j]=dp[i-1][i-1];
               continue;
            }

            dp[i][j]=dp[i][j-1]+dp[i-1][j-1];
        }
    }

    return dp[dp.size()-1][dp[0].size()-1];
}

int main(){
int n =12;
cout<<bellTriangle(n)<<endl;
return 0; 
}