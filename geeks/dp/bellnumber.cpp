#include<iostream>
#include<vector>
using namespace std;



int maximumSumSubsequnece(vector<int> &arr)
{
    vector<int> dp(arr.size(), 1);
    dp[0]= arr[0];
    int max_ = INT32_MIN;
    for (int i = 1; i < arr.size(); i++)
    {
        dp[i] = arr[i];
        for (int j = 0; j < i; j++) // har ek j cell uss tak ka maximum increasing subsequence store krke apne pass rakhta hai.
        {
            if (arr[i] >= arr[j]) // agar i cell j se bada hoga to length ek se increase hojayegi.
            {
                dp[i] = max(dp[i], dp[j] + arr[i]);
            }
        }
        max_ = max(max_, dp[i]);
    }

    // cout << max_ << endl;
    return max_;
}


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
vector<int> arr ={2,3,1,5,2,4};
cout<<maximumSumSubsequnece(arr)<<endl;
return 0; 
}