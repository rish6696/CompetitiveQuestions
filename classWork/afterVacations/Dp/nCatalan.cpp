#include <iostream>
#include <vector>
using namespace std;

int nthCatalanDp(int num)
{

    vector<int> dp(num + 1, 0);

    for (int n = 0; n < dp.size(); n++)
    {
        if (n == 0 || n == 1)
        {
            dp[n] = 1;
            continue;
        }

        int ans = 0;
        for (int i = 1; i <= n; i++)
        {
            int a = dp[i - 1];
            int b = dp[n - i];
            ans += a * b;
        }
        dp[n] = ans;
    }
    return dp[num];
}

int nthCatalanMemo(int n, vector<int> &dp)
{

    if (dp[n] != 0)
        return dp[n];
    if (n == 0 || n == 1)
    {
        dp[n] = 1;
        return 1;
    }

    int ans = 0;
    for (int i = 1; i <= n; i++)
    {
        int a = nthCatalanMemo(i - 1, dp);
        int b = nthCatalanMemo(n - i, dp);
        ans += a * b;
    }
    dp[n] = ans;
    return ans;
}

int nthCatalan(int n)
{
    if (n == 0 || n == 1)
        return 1;

    int ans = 0;
    for (int i = 1; i <= n; i++)
    {
        int a = nthCatalan(i - 1);
        int b = nthCatalan(n - i);
        ans += a * b;
    }

    return ans;
}

int main()
{
    int n = 23;
    vector<int> dp(n + 1, 0);
    //cout<<nthCatalan(n)<<endl;
    cout << nthCatalanMemo(n, dp) << endl;
    cout<<nthCatalanDp(n)<<endl;
    return 0;
}
