#include <iostream>
#include <vector>
using namespace std;

void display(vector<int> &arr)
{
    for (int i = 0; i < arr.size(); i++)
    {
        cout << arr[i] << " ";
    }

    cout << endl;
}

void display2dBool(vector<vector<bool>> &dp)
{
    for (int i = 0; i < dp.size(); i++)
    {
        for (int j = 0; j < dp[0].size(); j++)
        {
            cout << dp[i][j] << " ";
        }

        cout << endl;
    }
}

void display2d(vector<vector<int>> &dp)
{
    for (int i = 0; i < dp.size(); i++)
    {
        for (int j = 0; j < dp[0].size(); j++)
        {
            cout << dp[i][j] << " ";
        }

        cout << endl;
    }
}
int stringOccursAsASubsequenceDP(string str, string seq)
{

    vector<vector<int>> dp(str.size() + 1, vector<int>(seq.size() + 1, -1));
    for (int i = dp.size() - 1; i >= 0; i--)
    {
        for (int j = dp[0].size() - 1; j >= 0; j--)
        {
            if (j == seq.size())
            {
                dp[i][j] = 1;
                continue;
            }

            if (i == str.size())
            {
                dp[i][j] = 0;
                continue;
            }

            int ans = 0;

            if (str.at(i) == seq.at(j))
            {
                ans = dp[i + 1][j] + dp[i + 1][j + 1];
            }
            else
            {
                ans = dp[i + 1][j];
            }

            dp[i][j] = ans;
        }
    }
    return dp[0][0];
}

int stringOccursAsASubsequence(string str, string seq, int i, int j, vector<vector<int>> &dp)
{

    if (j == seq.size() || i == str.size() && j == seq.size())
        return dp[i][j] = 1;
    if (i == str.size())
        return dp[i][j] = 0;

    int ans = 0;

    if (str.at(i) == seq.at(j))
    {
        ans = stringOccursAsASubsequence(str, seq, i + 1, j, dp) + stringOccursAsASubsequence(str, seq, i + 1, j + 1, dp);
    }
    else
    {
        ans = stringOccursAsASubsequence(str, seq, i + 1, j, dp);
    }

    dp[i][j] = ans;
    return ans;
}

int LCS_DP(string a, string b)
{

    vector<vector<int>> dp(a.size() + 1, vector<int>(b.size(), 0));
    for (int i = dp.size() - 1; i >= 0; i--)
    {
        for (int j = dp[0].size() - 1; j >= 0; j--)
        {

            if (i == a.size() || j == b.length())
            {
                dp[i][j] = 0;
                continue;
            }
            if (a.at(i) == b.at(j))
            {
                dp[i][j] = 1 + dp[i + 1][j + 1];
                continue;
            }
            dp[i][j] = max(dp[i + 1][j], dp[i][j + 1]);
        }
    }
    return dp[0][0];
}

int LCS_RECURSIVE(string a, string b, int i, int j)
{
    if (i == a.size() || j == b.length())
        return 0;
    if (a.at(i) == b.at(j))
        return 1 + LCS_RECURSIVE(a, b, i + 1, j + 1);
    return max(LCS_RECURSIVE(a, b, i + 1, j), LCS_RECURSIVE(a, b, i, j + 1));
}

int getSumInrange(vector<int> &prefix, int si, int ei)
{
    if (si == 0)
        return prefix[ei];
    else
        return prefix[ei] - prefix[si - 1];
}

int optimalBST_RECURSION(vector<int> &freq, vector<int> &values, vector<int> &prefixSum, int start, int end, vector<vector<int>> &dp)
{

    if (dp[start][end] != INT32_MAX)
        return dp[start][end];

    if (start == end)
    {
        dp[start][end] = freq[start];
        return dp[start][end];
    }

    int ans = INT32_MAX;
    for (int cut = start; cut <= end; cut++)
    {
        int left = 0;
        int right = 0;
        int myAns = 0;

        if (start <= cut - 1)
        {
            left = optimalBST_RECURSION(freq, values, prefixSum, start, cut - 1, dp);
        }
        if (cut + 1 <= end)
        {
            right = optimalBST_RECURSION(freq, values, prefixSum, cut + 1, end, dp);
        }
        myAns = left + right + getSumInrange(prefixSum, start, end);
        ans = min(ans, myAns);
    }
    dp[start][end] = ans;
    return ans;
}

int getBallonVal(int idx, vector<int> &arr)
{
    if (idx == -1 || idx == arr.size())
        return 1;
    return arr[idx];
}

int ballonBurstDp(vector<int> &nums)
{
    vector<vector<int>> dp(nums.size(), vector<int>(nums.size(), 0));

    for (int gap = 0; gap < nums.size(); gap++)
    {
        int start = 0;
        int end = gap;
        while (end < nums.size())
        {
            if (gap == 0)
            {
                dp[start][end] = getBallonVal(start - 1, nums) * getBallonVal(start, nums) * getBallonVal(start + 1, nums);
            }
            else
            {
                int ans = INT32_MIN;
                for (int cut = start; cut <= end; cut++)
                {
                    int myAns = 0;
                    int left = 0;
                    if (start <= cut - 1)
                    {
                        left = dp[start][cut - 1];
                    }
                    int right = 0;
                    if (cut + 1 <= end)
                    {
                        right = dp[cut + 1][end];
                    }
                    myAns = left + right + getBallonVal(start - 1, nums) * getBallonVal(cut, nums) * getBallonVal(end + 1, nums);
                    ans = max(ans, myAns);
                }
                dp[start][end] = ans;
            }
            start++;
            end++;
        }
    }

    display2d(dp);
    return dp[0][nums.size() - 1];
}

int ballonBurstRecursion(int start, int end, vector<int> &arr, vector<vector<int>> &dp)
{
    if (start == end)
    {
        int ans = getBallonVal(start - 1, arr) * getBallonVal(start, arr) * getBallonVal(start + 1, arr);
        dp[start][end] = ans;
        return ans;
    }

    if (dp[start][end] != -1)
        return dp[start][end];
    int ans = INT32_MIN;
    for (int cut = start; cut <= end; cut++)
    {
        int myAns = 0;
        int left = 0;
        if (start <= cut - 1)
        {
            left = ballonBurstRecursion(start, cut - 1, arr, dp);
        }
        int right = 0;
        if (cut + 1 <= end)
        {
            right = ballonBurstRecursion(cut + 1, end, arr, dp);
        }
        myAns = left + right + getBallonVal(start - 1, arr) * getBallonVal(cut, arr) * getBallonVal(end + 1, arr);
        ans = max(ans, myAns);
    }
    dp[start][end] = ans;
    return ans;
}

int minCutPallindromePartitionDP(string str, vector<vector<bool>> isPallin)
{

    vector<int> dp(str.size() + 1, 0);

    for (int idx = dp.size() - 1; idx >= 0; idx--)
    {
        if (idx == str.length())
        {
            dp[idx] = -1;
            continue;
        }
        int ans = INT32_MAX;
        for (int end = idx; end < str.length(); end++)
        {
            if (isPallin[idx][end] == true)
            {
                ans = min(ans, dp[end + 1]);
            }
        }
        dp[idx] = ans + 1;
    }

    return dp[0];
}

int minCutPallindromePartition(string str, int idx, vector<vector<bool>> &isPallin)
{
    if (idx >= str.size())
        return -1;

    int ans = INT32_MAX;
    for (int end = idx; end < str.size(); end++)
    {

        if (isPallin[idx][end] == true)
        {
            ans = min(ans, minCutPallindromePartition(str, end + 1, isPallin));
        }
    }

    return ans + 1;
}

int MCM_MEMO(vector<int> &arr, int s, int e, vector<vector<int>> &dp)
{
    if (e - s == 1)
    {
        dp[s][e] = 0;
        return 0;
    }
    if (dp[s][e] != INT32_MAX)
        return dp[s][e];

    int ans = INT32_MAX;

    for (int cut = s + 1; cut < e; cut++)
    {
        int left = MCM_MEMO(arr, s, cut, dp);
        int right = MCM_MEMO(arr, cut, e, dp);

        int myans = left + arr[s] * arr[cut] * arr[e] + right;
        ans = min(ans, myans);
    }
    dp[s][e] = ans;
    return ans;
}

int MCM_RECURSION(vector<int> &arr, int s, int e)
{
    if (e - s == 1)
        return 0;

    int ans = INT32_MAX;

    for (int cut = s + 1; cut < e; cut++)
    {
        int left = MCM_RECURSION(arr, s, cut);
        int right = MCM_RECURSION(arr, cut, e);

        int myans = left + arr[s] * arr[cut] * arr[e] + right;
        ans = min(ans, myans);
    }
    return ans;
}

int printIncreasingSubsequence(vector<int> &arr, int idx, string ans, int last)
{
    if (idx == arr.size())
    {
        cout << ans << endl;
        return 1;
    }

    int count = 0;

    //select the index
    if (arr[idx] > last)
    {
        count += printIncreasingSubsequence(arr, idx + 1, ans + to_string(arr[idx]) + " ", arr[idx]);
    }

    //not select the index
    count += printIncreasingSubsequence(arr, idx + 1, ans, last);
    return count;
}

int printAllSubsequence(vector<int> &arr, int idx, string ans)
{
    if (idx == arr.size())
    {
        cout << ans << endl;
        return 1;
    }

    int count = 0;

    //select the index
    count += printAllSubsequence(arr, idx + 1, ans + to_string(arr[idx]) + " ");
    //not select the index
    count += printAllSubsequence(arr, idx + 1, ans);
    return count;
}

vector<int> longestDecreasingSubsequence(vector<int> &arr)
{
    vector<int> dp(arr.size(), 1);
    int ans = -1;
    for (int i = arr.size() - 2; i >= 0; i--)
    {
        for (int j = i + 1; j < arr.size(); j++)
        {
            if (arr[j] < arr[i])
            {
                dp[i] = max(dp[i], dp[j] + 1);
            }
        }
        ans = max(ans, dp[i]);
    }
    return dp;
}

vector<int> longestIncreasingSubsequence(vector<int> &arr)
{
    vector<int> dp(arr.size(), 1);
    int ans = -1;
    for (int i = 1; i < arr.size(); i++)
    {
        for (int j = i - 1; j >= 0; j--)
        {
            if (arr[j] < arr[i])
            {
                dp[i] = max(dp[i], dp[j] + 1);
            }
        }
        ans = max(ans, dp[i]);
    }
    return dp;
}

int longestBiotonicSequence(vector<int> &arr)
{
    vector<int> li = longestIncreasingSubsequence(arr);
    vector<int> ld = longestDecreasingSubsequence(arr);

    int ans = -1;
    for (int i = 0; i < arr.size(); i++)
    {
        ans = max(ans, li[i] + ld[i] - 1);
    }

    return ans;
}

int longestPallindromeSubsequence(string str)
{

    vector<vector<int>> dp(str.length(), vector<int>(str.length(), 0));

    for (int gap = 0; gap < str.length(); gap++)
    {
        int i = 0;
        int j = gap;
        while (j < str.length())
        {
            if (gap == 0)
                dp[i][j] = 1;
            else
            {
                if (str.at(i) == str.at(j))
                {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                }
                else
                {
                    dp[i][j] = max(dp[i][j - 1], dp[i + 1][j]);
                }
            }
            i++;
            j++;
        }
    }

    return dp[0][str.length() - 1];
}

int countPallindromeSubsequence(string str)
{
    vector<vector<int>> dp(str.length(), vector<int>(str.length(), 0));
    for (int gap = 0; gap < str.length(); gap++)
    {
        int i = 0;
        int j = gap;
        while (j < str.length())
        {
            if (gap == 0)
            {
                dp[i][j] = 1;
                i++;
                j++;
                continue;
            }

            if (str.at(i) == str.at(j))
            {
                // asli me yahan pr
                // dp[i][j] = dp[i+1][j-1] + 1 + dp[i+1][j] + dp[i][j-1] -dp[i+1][j-1];
                dp[i][j] = dp[i + 1][j] + dp[i][j - 1] + 1;
            }
            else
            {
                dp[i][j] = dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1];
            }
            i++;
            j++;
        }
    }
    return dp[0][str.length() - 1];
}
string longestPalindrome(string str)
{

    vector<vector<int>> dp(str.size(), vector<int>(str.size(), 0));
    int ans = -1;
    int s = 0;
    int e = 0;
    for (int gap = 0; gap < str.length(); gap++)
    {
        int i = 0;
        int j = gap;
        while (j < dp.size())
        {
            if (gap == 0)
                dp[i][j] = 1;
            else
            {
                if (str.at(i) == str.at(j))
                {
                    if (gap == 1)
                        dp[i][j] = 2;
                    else if (dp[i + 1][j - 1] != 0)
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    else
                        dp[i][j] = 0;
                }
                else
                {
                    dp[i][j] = 0;
                }
            }
            if (dp[i][j] > ans)
            {
                s = i;
                e = j;
                ans = dp[i][j];
            }
            i++;
            j++;
        }
    }

    return str.substr(s, e);
}

vector<vector<bool>> isPallindrome(string str)
{
    vector<vector<bool>> dp(str.size(), vector<bool>(str.size(), false));
    int ans = -1;
    for (int gap = 0; gap < str.length(); gap++)
    {
        int i = 0;
        int j = gap;
        while (j < dp.size())
        {
            if (gap == 0)
                dp[i][j] = true;
            else
            {
                if (str.at(i) == str.at(j))
                {
                    if (gap == 1)
                        dp[i][j] = true;
                    else if (dp[i + 1][j - 1] == true)
                        dp[i][j] = true;
                    else
                        dp[i][j] = false;
                }
                else
                {
                    dp[i][j] = false;
                }
            }
            i++;
            j++;
        }
    }
    return dp;
}

int longestPallindromeSubstring(string str)
{
    vector<vector<int>> dp(str.size(), vector<int>(str.size(), 0));
    int ans = -1;
    for (int gap = 0; gap < str.length(); gap++)
    {
        int i = 0;
        int j = gap;
        while (j < dp.size())
        {
            if (gap == 0)
                dp[i][j] = 1;
            else
            {
                if (str.at(i) == str.at(j))
                {
                    if (gap == 1)
                        dp[i][j] = 2;
                    else if (dp[i + 1][j - 1] != 0)
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    else
                        dp[i][j] = 0;
                }
                else
                {
                    dp[i][j] = 0;
                }
            }
            ans = max(ans, dp[i][j]);
            i++;
            j++;
        }
    }
    display2d(dp);
    return ans;
}

int permutationCoinChangeDp(vector<int> &coins, int target)
{

    vector<int> dp(target + 1, 0);
    dp[target] = 1;
    for (int t = target - 1; t >= 0; t--)
    {
        for (int coin = 0; coin < coins.size(); coin++)
        {
            if (t + coins[coin] <= target)
            {
                dp[t] += dp[t + coins[coin]];
            }
        }
    }
    display(dp);
    return dp[0];
}

int combinationCoinChangeDp(vector<int> &coins, int target)
{

    vector<int> dp(target + 1, 0);
    dp[target] = 1;
    for (int coin = 0; coin < coins.size(); coin++)
    {
        for (int t = target - 1; t >= 0; t--)
        {
            if (t + coins[coin] <= target)
            {
                dp[t] += dp[t + coins[coin]];
            }
        }
    }
    display(dp);
    return dp[0];
}

int binomial(int ni, int k)
{
    vector<vector<int>> dp(ni + 1, vector<int>(k + 1, 0));
    for (int n = 0; n < dp.size(); n++)
    {
        for (int r = 0; r <= n; r++)
        {
            if (n == r || r == 0)
            {
                dp[n][r] = 1;
                continue;
            }
            if (r == 1)
            {
                dp[n][r] = n;
                continue;
            }
            int a = dp[n - 1][r - 1];
            a %= 10000000007;
            int b = dp[n - 1][r];
            b %= 1000000007;
            int ans = a + b;
            ans %= 1000000007;
            dp[n][r] = ans;
        }
    }

    return dp[ni][k];
}

int tilingFloorgeeksDp(int r, int c)
{

    vector<int> dp(r + 1, 0);
    for (int row = 0; row < dp.size(); row++)
    {
        if (row == c)
        {
            dp[row] = 2;
            continue;
        }
        if (row < c)
        {
            dp[row] = 1;
            continue;
        }
        int ans = 0;
        ans += dp[row - 1];
        ans += dp[row - c];
        dp[row] = ans;
    }
    display(dp);

    return dp[r];
}

int tilingFloorgeeks(int row, int col, vector<int> &dp)
{

    if (dp[row] != 0)
        return dp[row];
    if (row == col)
    {
        dp[row] == 2;
        return 2;
    }
    if (row < col)
    {
        dp[row] = 1;
        return 1;
    }
    int ans = 0;
    ans += tilingFloorgeeks(row - 1, col, dp);
    ans += tilingFloorgeeks(row - col, col, dp);

    dp[row] = ans;
    return ans;
}

int ansMaxsubarray = INT32_MIN;

int countMaximumSizeSubArrayDp(vector<vector<int>> &arr)
{

    vector<vector<int>> dp(arr.size(), vector<int>(arr[0].size(), 0));

    int ans = 0;

    for (int row = dp.size() - 1; row >= 0; row--)
    {
        for (int col = dp[0].size() - 1; col >= 0; col--)
        {
            if (arr[row][col] == 0)
                continue;

            if (row == dp.size() - 1 || col == dp.size() - 1)
            {
                ans = max(ans, 1);
                dp[row][col] = 1;
                continue;
            }

            vector<vector<int>> dir = {{1, 0}, {0, 1}, {1, 1}};

            int minOfAll = INT32_MAX;
            for (int i = 0; i < dir.size(); i++)
            {
                int r = row + dir[i][0];
                int c = col + dir[i][1];

                if (r >= 0 && c >= 0 && r < arr.size() && c < arr[0].size())
                {
                    minOfAll = min(minOfAll, dp[r][c]);
                }
            }
            dp[row][col] = minOfAll + 1;
            ans = max(ans, minOfAll + 1);
        }
    }
    // display2d(dp);
    return ans;
}

int countMaximumSizeSubArray(vector<vector<int>> &arr, int row, int col)
{

    if (row == arr.size() - 1 && col == arr[0].size() - 1)
    {
        return arr[row][col] == 0 ? 0 : 1;
    }

    vector<vector<int>> dir = {{1, 0}, {0, 1}, {1, 1}};
    int minOfAll = INT32_MAX;

    for (int i = 0; i < dir.size(); i++)
    {
        int r = row + dir[i][0];
        int c = col + dir[i][1];

        if (r >= 0 && c >= 0 && r < arr.size() && c < arr[0].size())
        {
            minOfAll = min(minOfAll, countMaximumSizeSubArray(arr, r, c));
        }
    }
    int ans = 0;
    if (arr[row][col] != 0)
        ans = minOfAll + 1;
    ansMaxsubarray = max(ansMaxsubarray, ans);
    return ans;
}

int divideInkSubsetMemo(int n, int k, vector<vector<int>> &dp)
{

    if (k > n)
    {
        dp[n][k] = 0;
        return 0;
    }
    if (k == n || k == 1)
    {
        dp[n][k] = 1;
        return 1;
    }

    if (dp[n][k] != -1)
        return dp[n][k];

    int ans = 0;
    ans += divideInkSubsetMemo(n - 1, k - 1, dp);
    ans += divideInkSubsetMemo(n - 1, k, dp) * k;

    dp[n][k] = ans;
    return ans;
}

int divideInkSubsetDp(int num, int kval)
{

    vector<vector<int>> dp(num + 1, vector<int>(kval + 1, -1));

    for (int n = 0; n < dp.size(); n++)
    {

        for (int k = 0; k < dp[0].size(); k++)
        {
            if (n == 0 || k == 0)
            {
                dp[n][k] = 0;
                continue;
            }
            if (k > n)
            {
                dp[n][k] = 0;
                continue;
            }

            if (k == n || k == 1)
            {
                dp[n][k] = 1;
                continue;
            }

            int ans = 0;
            ans += dp[n - 1][k - 1];
            ans += dp[n - 1][k] * k;
            dp[n][k] = ans;
        }
    }
    return dp[num][kval];
}

int divideInkSubset(int n, int k)
{

    if (k > n)
        return 0;
    if (k == n || k == 1)
        return 1;

    int ans = 0;
    ans += divideInkSubset(n - 1, k - 1);
    ans += divideInkSubset(n - 1, k) * k;
    return ans;
}

int friendsParingDp(int n)
{
    vector<int> dp(n + 1, 0);
    dp[0] = 1;
    dp[1] = 1;
    for (int i = 2; i < dp.size(); i++)
    {

        int count = 0;
        count += dp[i - 1];
        count += dp[i - 2] * (i - 1);
        dp[i] = count;
    }
    return dp[n];
}

int friendspairing(int n, vector<int> &dp)
{

    if (dp[n] != 0)
        return dp[n];
    if (n <= 1)
    {
        dp[n] = 1;
        return 1;
    }
    int count = 0;
    count += friendspairing(n - 1, dp);
    count += friendspairing(n - 2, dp) * (n - 1);
    dp[n] = count;
    return count;
}

int boardPathRecursion(int start, int end, vector<int> &dp)
{

    if (dp[start] != -1)
        return dp[start];

    if (start == end)
    {
        dp[start] = 1;
        return 1;
    }
    int ans = 0;

    for (int i = 1; i <= 6; i++)
    {
        if (start + i <= end)
        {
            ans += boardPathRecursion(start + i, end, dp);
        }
    }
    dp[start] = ans;
    return ans;
}

int boardPathRecursionDp(int end)
{
    vector<int> dp(end + 1, 0);
    dp[end] = 1;

    for (int i = dp.size() - 1; i >= 0; i--)
    {
        if (i == end)
            continue;
        int ans = 0;
        for (int dice = 1; dice <= 6; dice++)
        {
            if (dice + i <= end)
            {
                ans += dp[dice + i];
            }
        }
        dp[i] = ans;
    }
    return dp[0];
}

int mazePathMultiMoveIterative(int er, int ec)
{

    vector<vector<int>> dp(er + 1, vector<int>(ec + 1, 0));

    dp[er][ec] = 1;
    for (int row = er; row >= 0; row--)
    {
        for (int col = ec; col >= 0; col--)
        {

            if (row == er && col == ec)
                continue;
            int count = 0;

            //horizontalmove
            for (int i = 1; i <= ec; i++)
            {
                int y = col + i;
                int x = row;
                if (x >= 0 && x <= er && y >= 0 && y <= ec)
                {
                    count += dp[x][y];
                }
            }

            //verticalmove
            for (int i = 1; i <= ec; i++)
            {
                int y = col;
                int x = row + i;
                if (x >= 0 && x <= er && y >= 0 && y <= ec)
                {
                    count += dp[x][y];
                }
            }

            // diagonal move
            for (int i = 1; i <= ec; i++)
            {
                int y = col + i;
                int x = row + i;
                if (x >= 0 && x <= er && y >= 0 && y <= ec)
                {
                    count += dp[x][y];
                }
            }
            dp[row][col] = count;
        }
    }

    return dp[0][0];
}

int mazePathMultiMoveMemo(int cr, int cc, int er, int ec, vector<int> &dp)
{

    int idx = cr * (ec + 1) + cc;

    if (dp[idx] != 0)
        return dp[idx];
    if (cr == er && cc == ec)
    {
        dp[idx] = 1;
        return 1;
    }
    int ans = 0;

    //horizontal jump;
    for (int i = 1; i <= ec; i++)
    {
        int y = cc + i;
        int x = cr;
        if (x >= 0 && x <= er && y >= 0 && y <= ec)
        {
            ans += mazePathMultiMoveMemo(x, y, er, ec, dp);
        }
    }

    //vertical jump;
    for (int i = 1; i <= ec; i++)
    {
        int y = cc;
        int x = cr + i;
        if (x >= 0 && x <= er && y >= 0 && y <= ec)
        {
            ans += mazePathMultiMoveMemo(x, y, er, ec, dp);
        }
    }

    dp[idx] = ans;
    return ans;
}

int mazePathMultiMove(int cr, int cc, int er, int ec)
{

    if (cr == er && cc == ec)
        return 1;
    int ans = 0;
    //horizontal jump;
    for (int i = 1; i <= ec; i++)
    {
        int y = cc + i;
        int x = cr;
        if (x >= 0 && x <= er && y >= 0 && y <= ec)
        {
            ans += mazePathMultiMove(x, y, er, ec);
        }
    }

    //vertical jump;
    for (int i = 1; i <= ec; i++)
    {
        int y = cc;
        int x = cr + i;
        if (x >= 0 && x <= er && y >= 0 && y <= ec)
        {
            ans += mazePathMultiMove(x, y, er, ec);
        }
    }

    return ans;
}

int mazePathIterative(int er, int ec)
{

    vector<vector<int>> dir = {{1, 0}, {0, 1}};
    vector<vector<int>> dp(er + 1, vector<int>(ec + 1, 0));

    dp[er][ec] = 1;

    for (int row = er; row >= 0; row--)
    {
        for (int col = ec; col >= 0; col--)
        {
            if (row == er && col == ec)
            {
                continue;
            }
            int ans = 0;
            for (int i = 0; i < dir.size(); i++)
            {
                int x = row + dir[i][0];
                int y = col + dir[i][1];

                if (x >= 0 && x <= er && y >= 0 && y <= ec)
                {
                    ans += dp[x][y];
                }
            }
            dp[row][col] = ans;
        }
    }

    return dp[0][0];
}

int mazePathMemo(int cr, int cc, int er, int ec, vector<int> &dp)
{

    int idx = cr * (ec + 1) + cc;
    if (dp[idx] != 0)
        return dp[idx];

    if (cr == er && cc == ec)
    {
        dp[idx] = 1;
        return 1;
    }
    int ans = 0;
    vector<vector<int>> dir = {{1, 0}, {0, 1}};
    for (int i = 0; i < dir.size(); i++)
    {
        int x = cr + dir[i][0];
        int y = cc + dir[i][1];

        if (x >= 0 && x <= er && y >= 0 && y <= ec)
        {
            ans += mazePathMemo(x, y, er, ec, dp);
        }
    }
    dp[idx] = ans;
    return ans;
}

int main()
{
    // int er = 2;
    //int ec = 2;
    //vector<int> dp((er + 1) * (ec + 1), 0);
    // cout << mazePathMemo(0, 0, er, ec,dp) << endl;
    // display(dp);
    //  cout << mazePathIterative(er, ec) << endl;
    // cout<<mazePathMultiMove(0,0,er,ec)<<endl;
    // cout<<mazePathMultiMoveMemo(0,0,er,ec,dp)<<endl;
    // display(dp);
    // cout<<mazePathMultiMoveIterative(er,ec)<<endl;

    //int end = 80;
    // cout << boardPathRecursionDp(end)<< endl;
    // vector<int> dp(end + 1, -1);
    // cout << boardPathRecursion(0, end, dp) << endl;
    // display(dp);
    // int n = 3;
    // int m = 2;
    // vector<int> dp(n + 1, 0);
    // cout << friendspairing(n, dp) << endl;
    // cout<<friendsParingDp(n)<<endl;
    //  display(dp);

    // int n = 3;
    // int k = 2;

    //vector<vector<int>> dp(n + 1, vector<int>(k + 1, -1));
    // cout << divideInkSubsetMemo(n, k, dp) << endl;
    // cout<<divideInkSubsetDp(n,k)<<endl;

    // vector<vector<int>> arr = {{0, 1, 0, 1, 0,1},
    //                            {1, 0,1, 0, 1,0},
    //                            {0, 1, 1, 1, 1,0},
    //                            {0, 0, 1, 1, 1,0},
    //                            {1, 1, 1, 1, 1,1},
    //                         };

    //vector<vector<int>> arr ={{0,1,1},{1,1,1},{0,0,0}};
    // cout << countMaximumSizeSubArray(arr, 0, 0) << endl;
    // cout << ansMaxsubarray << endl;
    // cout<<countMaximumSizeSubArrayDp(arr)<<endl;
    //  cout<<countMaximumSizeSubArray(arr,0,0)<<endl;

    //cout << tilingFloorgeeks(n, m, dp) << endl;
    //  cout << tilingFloorgeeksDp(n, m) << endl;
    //  cout<<binomial(n,m)<<endl;

    // vector<int> coins  = {1,2,3};
    // int target =4;
    // cout<<permutationCoinChangeDp(coins,target)<<endl;
    // cout<<combinationCoinChangeDp(coins,target)<<endl;

    //string str ="bpqb";
    //cout<<longestPallindromeSubstring(str)<<endl;
    //cout<<countPallindromeSubsequence(str)<<endl;
    //cout<<longestPalindrome(str)<<endl;
    //cout<<longestPallindromeSubsequence(str)<<endl;
    // vector<int> arr ={40, 20, 30, 10, 30};
    // vector<vector<int>> dp(arr.size(), vector<int>(arr.size(), INT32_MAX));
    // cout<<MCM_RECURSION(arr,0,arr.size()-1)<<endl;
    // cout<<MCM_MEMO(arr,0,arr.size()-1,dp)<<endl;
    //display2d(dp);

    //cout<<printAllSubsequence(arr,0,"")<<endl;
    // cout<<longestIncreasingSubsequence(arr)<<endl;
    // cout<<longestDecreasingSubsequence(arr)<<endl;
    //  cout<<printIncreasingSubsequence(arr,0,"",INT32_MIN)<<endl;

    //   string str ="abacdc";
    //   vector< vector<bool>> isP = isPallindrome(str);
    //  // display2dBool(isP);
    //   cout<<minCutPallindromePartition(str,0,isP)<<endl;
    //   cout<<minCutPallindromePartitionDP(str,isP)<<endl;
    // vector<int> values = {10, 12, 20};
    // vector<int> freq = {34, 8, 50};
    // vector<int> prefx(freq.size(), 0);
    // vector<vector<int>> dp(values.size(), vector<int>(values.size(), INT32_MAX));

    // prefx[0] = freq[0];
    // for (int i = 1; i < prefx.size(); i++)
    // {
    //     prefx[i] = prefx[i - 1] + freq[i];
    //     cout << prefx[i] << endl;
    // }

    // cout << optimalBST_RECURSION(freq, values, prefx, 0, freq.size() - 1, dp) << endl;
    // display2d(dp);
    //cout<<longestIncreasingSubsequence(arr)<<endl;
    // cout<<longestDecreasingSubsequence(arr)<<endl;
    // cout << ballonBurstRecursion(0, arr.size() - 1, arr, dp) << endl;
    // cout<<ballonBurstDp(arr)<<endl;
    //display2d(dp);
    string a = "geeksforgeeks";
    string b = "gks";
    vector<vector<int>> dp(a.size() + 1, vector<int>(b.size() + 1, -1));
    cout << stringOccursAsASubsequence(a, b, 0, 0, dp) << endl;
    cout<<stringOccursAsASubsequenceDP(a,b)<<endl;
    // cout<<LCS_RECURSIVE(a,b,0,0)<<endl;
    // cout<<LCS_DP(a,b)<<endl;
    return 0;
}
