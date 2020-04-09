#include <iostream>
#include <vector>
using namespace std;

int rodCuttingDp(vector<int> &nums)
{

    vector<int> dp(nums.size() + 1, 0);
    for (int target = 0; target <dp.size(); target++)
    {

        if (target == 0)
            continue;
        int ans = -1;
        for (int i = 1; i <= target; i++)
        {
            ans = max(ans, nums[i - 1] + dp[target - i]);
        }
        dp[target] = ans;
    }

    return dp[nums.size()];
}

int rodCuttingMemo(int target, vector<int> &nums, vector<int> &dp)
{

    if (dp[target] != -1)
        return dp[target];
    if (target == 0)
        return 0;
    int ans = -1;
    for (int i = 1; i <= target; i++)
    {
        ans = max(ans, nums[i - 1] + rodCuttingMemo(target - i, nums, dp));
    }
    dp[target] = ans;
    return ans;
}

int rodCutting(int target, vector<int> &nums)
{
    if (target == 0)
        return 0;
    int ans = -1;
    for (int i = 1; i <= target; i++)
    {
        ans = max(ans, nums[i - 1] + rodCutting(target - i, nums));
    }

    return ans;
}

int main()
{
    vector<int> nums = {2,5,9,6};
    vector<int> dp(nums.size() + 1, -1);
    cout << rodCutting(nums.size(), nums) << endl;
    cout << rodCuttingMemo(nums.size(), nums, dp) << endl;
    cout<<rodCuttingDp(nums)<<endl;
    return 0;
}
