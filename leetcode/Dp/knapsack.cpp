#include <iostream>
#include <vector>
using namespace std;



void display(vector< vector<int> >&dp){
   for (int i = 0; i < dp.size(); i++)
   {
       for (int j = 0; j < dp[0].size(); j++)
       {
           cout<<dp[i][j]<<" ";
       }

       cout<<endl;
       
   }
   
}





int knapSack(int idx, int wsf, vector<int> values, vector<int> weights)
{

    if (idx == weights.size() || wsf == 0)
    return 0;

    int select = 0;
    int notSelect = 0;

    //select
    if (wsf >= weights[idx])
    {
        select = values[idx] + knapSack(idx + 1, wsf - weights[idx], values, weights);
    }

    //not select
    notSelect = knapSack(idx + 1, wsf, values, weights);
    return max(select, notSelect);
}

int knapSackDp(int w, vector<int> &values, vector<int> &weights)
{
    vector<vector<int>> dp(weights.size()+1, vector<int>(w + 1, 0));
    for (int idx = dp.size() - 1; idx >= 0; idx--)
    {
        for (int wsf = dp[0].size() - 1; wsf >= 0; wsf--)
        {
            if (idx == weights.size() || wsf == 0)
                continue;

            int select = 0;
            int notSelect = 0;

            //select
            if (wsf >= weights[idx])
            {
                select = values[idx] + dp[idx + 1][wsf - weights[idx]];
            }

            //not sele
            notSelect = dp[idx + 1] [wsf];
            int ans = max(select, notSelect);
            dp[idx][wsf] = ans;
        }
    }

   // display(dp);
    return dp[0][w];
}

int knapSackMemo(int idx, int wsf, vector<int> &values, vector<int> &weights, vector<vector<int>> &dp)
{

    if (idx == weights.size() || wsf == 0)
        return 0;

    if (dp[idx][wsf] != -1)
    {
        cout << "returned from dp" << endl;
        return dp[idx][wsf];
    }

    int select = 0;
    int notSelect = 0;

    //select
    if (wsf >= weights[idx])
    {
        select = values[idx] + knapSackMemo(idx + 1, wsf - weights[idx], values, weights, dp);
    }

    //not select
    notSelect = knapSackMemo(idx + 1, wsf, values, weights, dp);
    int ans = max(select, notSelect);
    dp[idx][wsf] = ans;
    return ans;
}

int main()
{

    vector<int> weights = {10,20,30};
    vector<int> values = {60,100,120};
    int w = 50;

    vector<vector<int>> dp(weights.size(), vector<int>(w + 1, -1));
    cout << knapSackMemo(0, w, values, weights, dp) << endl;

    cout<<knapSackDp(w,values,weights)<<endl;
    return 0;
}