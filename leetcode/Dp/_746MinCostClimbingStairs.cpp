#include <iostream>
#include <vector>
using namespace std;

int minCostClimbing(int curr, vector<int> cost, vector<int> &dp)
{

    if (dp[curr] != -1)
        return dp[curr];

    if (curr == cost.size())
    {
        dp[curr] = 0;
        return 0;
    }

    int ans = INT32_MAX;

    for (int i = 1; i <= 2; i++)
    {
        if (curr + i <= cost.size())
        {
            int rec = minCostClimbing(curr + i, cost, dp);
            ans = min(ans, rec + cost[curr]);
        }
    }
    dp[curr] = ans;
    return ans;
}

int minCostClimbingDp(vector<int> cost)
{

    vector<int> dp(cost.size() + 1, -1);
    dp[cost.size()] = 0;

    for (int i = dp.size() - 1; i >= 0; i--)
    {

        if (i == cost.size()) continue;
        
        int ans = INT32_MAX;

        for (int k = 1; k <= 2; k++)
        {
            if (i + k <= cost.size())
            {
                int rec = dp[i+k];
                ans = min(ans, rec + cost[i]);
            }
        }
        dp[i] = ans;
    }
    return min(dp[0],dp[1]);

}

int main()
{

    vector<int> cost = {10, 15, 20};
    vector<int> dp(cost.size() + 1, -1);

   // cout << minCostClimbing(0, cost, dp) << endl;
    //cout << minCostClimbing(1, cost, dp) << endl;
    cout<<minCostClimbingDp(cost)<<endl;
    return 0;
}