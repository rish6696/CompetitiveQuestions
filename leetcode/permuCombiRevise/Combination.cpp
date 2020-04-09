#include <iostream>
#include <vector>
#include <iomanip>
using namespace std;

int combination(int idx, int sum, int finalsum, vector<int> &coins, string ans)
{

    if (sum == finalsum)
    {
        cout << ans << " ";
        return 1;
    }
    if (idx >= coins.size())
        return 0;

    int count = 0;
    for (int i = idx; i < coins.size(); i++)
    {
        if (sum + coins[i] <= finalsum)
        {
            count += combination(i, sum + coins[i], finalsum, coins, ans + to_string(coins[i]));
        }
    }
    return count;
}

int combinationSubsequenceWay(int idx, int sum, int finalSum, vector<int> coins, string ans)
{

    if (sum == finalSum)
    {
        cout << ans << " ";
        return 1;
    }
    if (idx >= coins.size())
        return 0;

    int count = 0;
    //select
    if (sum + coins[idx] <= finalSum)
        count += combinationSubsequenceWay(idx, sum + coins[idx], finalSum, coins, ans + to_string(coins[idx]) + " ");

    //not select
    count += combinationSubsequenceWay(idx + 1, sum, finalSum, coins, ans);
    return count;
}

int combinationDp(int finalSum, vector<int> coins)
{

    vector<vector<int>> dp(finalSum + 1, vector<int>(coins.size() + 1, 0));

    for (int sum = dp.size() - 1; sum >= 0; sum--)
    {

        for (int coin = dp[0].size() - 1; coin >= 0; coin--)
        {

            if (coin == dp[0].size() - 1)
                continue;
            if (sum == dp.size() - 1)
            {
                dp[sum][coin] = 1;
                continue;
            }

            int count = 0;
            //select
            if (sum + coins[coin] <= finalSum)
                count += dp[sum+coins[coin]][coin]; 

            //not select
            count += dp[sum][coin+1]; 
            dp[sum][coin] = count;
        }
    }
    return dp[0][0];
}

int combinationSubsequenceWayMemoization(int idx, int sum, int finalSum, vector<int> coins, string ans, vector<vector<int>> &dp)
{

    if (sum == finalSum)
    {
        dp[sum][idx] = 1;
        return 1;
    }

    if (idx >= coins.size())
        return 0;

    if (dp[sum][idx] != -1)
    {
        cout << "returned from dp" << endl;
        return dp[sum][idx];
    }

    int count = 0;
    //select
    if (sum + coins[idx] <= finalSum)
        count += combinationSubsequenceWayMemoization(idx, sum + coins[idx], finalSum, coins, ans + to_string(coins[idx]) + " ", dp);

    //not select
    count += combinationSubsequenceWayMemoization(idx + 1, sum, finalSum, coins, ans, dp);

    dp[sum][idx] = count;
    return count;
}

void display(vector<vector<int>> dp)
{

    for (int i = 0; i < dp.size(); i++)
    {
        for (int j = 0; j < dp[0].size(); j++)
        {
            cout << setw(5) << dp[i][j];
        }
        cout << endl;
    }
}

int main()
{
    int sum = 10;
    vector<int> coins = {2,3,5,7};
    cout<<combinationDp(sum,coins)<<endl;
    // vector<vector<int>> dp(sum + 1, vector<int>(coins.size(), -1));
    // //  cout<<combinationSubsequenceWay(0,0,sum,coins,"")<<endl;
    // cout << combinationSubsequenceWayMemoization(0, 0, sum, coins, "", dp) << endl;
    // display(dp);
    return 0;
}