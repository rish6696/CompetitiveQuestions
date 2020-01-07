#include <iostream>
#include <string>
#include <vector>
#include <unordered_set>
using namespace std;

void printSubsequence(string str, string result)
{
    if (str.length() == 0)
    {
        cout << result << " ";
        return;
    }
    string ros = str.substr(1);
    char cc = str.at(0);
    printSubsequence(ros, result + cc);
    printSubsequence(ros, result);
}

void compress(string str, string result, int count, int i)
{
    if (i == str.length())
    {
        if (count == 1)
        {
            cout << result;
        }
        else
        {
            cout << result + to_string(count);
        }
        return;
    }

    if (str.at(i) == str.at(i - 1))
    {
        compress(str, result, count + 1, i + 1);
    }
    else
    {
        if (count == 1)
        {
            compress(str, result + str.at(i), 1, i + 1);
        }
        else
        {
            compress(str, result + to_string(count) + str.at(i), 1, i + 1);
        }
    }
}

void mazePath(int cr, int cc, int er, int ec, string result)
{
    if (cr == er && cc == ec)
    {
        cout << result << " ";
        return;
    }
    vector<vector<int>> directions = {{0, 1}, {1, 0}};
    vector<char> dirName = {'H', 'V'};
    for (int i = 0; i < directions.size(); i++)
    {
        int x = cr + directions[i][0];
        int y = cc + directions[i][1];
        if (x >= 0 && x <= er && y >= 0 && y <= ec)
        {
            mazePath(x, y, er, ec, result + dirName[i]);
        }
    }
}

void removeHi(string str, int i, string result)
{
    if (i >= str.length())
    {
        cout << result << " ";
        return;
    }
    char cc = str.at(i);
    if (cc == 'h')
    {
        char nxt = str.at(i + 1);
        if (nxt == 'i')
        {
            removeHi(str, i + 2, result);
            return;
        }
        else
        {
            removeHi(str, i + 1, result + 'h');
            return;
        }
    }
    else
    {
        removeHi(str, i + 1, result + cc);
        return;
    }
}

void printPermutation(string str, string result)
{
    if (str.length() == 0)
    {
        cout << result + " ";
        return;
    }
    for (int i = 0; i < str.length(); i++)
    {
        string ros = str.substr(0, i) + str.substr(i + 1);
        char cc = str.at(i);
        printPermutation(ros, result + cc);
    }
}

void boardPAth(int start, int end, string ans)
{
    if (start == end)
    {
        cout << ans + " ";
        return;
    }
    if (start > end)
    {
        return;
    }
    for (int i = 1; i <= 6; i++)
    {
        boardPAth(start + i, end, ans + to_string(i));
    }
}

void printPermutationNoRepeat(string str, string result)
{
    if (str.length() == 0)
    {
        cout << result + " ";
        return;
    }
    int a = 0;
    for (int i = 0; i < str.length(); i++)
    {
        int m = str.at(i) - 'a';
        if ((a & (1 << m)) == 0)
        {
            a = a | (1 << m);
            string ros = str.substr(0, i) + str.substr(i + 1);
            char cc = str[i];
            printPermutationNoRepeat(ros, result + cc);
        }
    }
}

int coinChangePermutation(vector<int> &arr, int target, string ans)
{
    if (target == 0)
    {
        cout << ans << " ";
        return 1;
    }
    int count = 0;

    for (int i = 0; i < arr.size(); i++)
    {
        int a = arr[i];
        if (target - a >= 0)
        {
            count += coinChangePermutation(arr, target - a, ans + to_string(a));
        }
    }
    return count;
}

int coinChangePermutationNORepeat(vector<int> &arr, int target, string ans, vector<bool> &includedIndex)
{
    if (target == 0)
    {
        cout << ans << " ";
        return 1;
    }
    int count = 0;

    for (int i = 0; i < arr.size(); i++)
    {
        int a = arr[i];
        if (target - a >= 0 && !includedIndex[i])
        {
            includedIndex[i] = true;
            count += coinChangePermutationNORepeat(arr, target - a, ans + to_string(a), includedIndex);
            includedIndex[i] = false;
        }
    }
    return count;
}

int coinChangeCombination(vector<int> &arr, int target, string ans, int start)
{
    if (target == 0)
    {
        cout << ans << " ";
        return 1;
    }
    int count = 0;
    for (int i = start; i < arr.size(); i++)
    {
        int a = arr[i];
        if (target - a >= 0)
        {
            count += coinChangeCombination(arr, target - a, ans + to_string(a), i);
        }
    }
    return count;
}

bool allIncluded(vector<bool> &arr)
{
    for (int i = 0; i < arr.size(); i++)
    {
        if (!arr[i])
        {
            return false;
        }
        return true;
    }
}

bool isSumEqaul(string f, string s)
{
    int sf = 0;
    for (int i = 0; i < f.size(); i++)
    {
        sf += f.at(i) - '0';
    }
    int ss = 0;
    for (int i = 0; i < s.size(); i++)
    {
        ss += s.at(i) - '0';
    }
    if (sf == ss)
    {
        return true;
    }
    return false;
}

void EqualSum(vector<int> &arr, int start, string first, string sec, vector<bool> isIncluded, int set1, int set2)
{

    if (start == arr.size())
    {
        if (set1 == set2)
        {
            cout << first << "====";
            cout << sec << "======";
            cout << endl;
            return;
        }
        return;
    }
    EqualSum(arr, start + 1, first + to_string(arr[start]) + " ", sec, isIncluded, set1 + arr[start], set2);
    EqualSum(arr, start + 1, first, sec + to_string(arr[start]) + " ", isIncluded, set1, set2 + arr[start]);
}

void coinChangePermutationtargetDecide(vector<int> &arr, int target, string ans)
{
    if (target == 0)
    {
        cout << ans << " ";
        return;
    }

    for (int i = 0; i < arr.size(); i++)
    {
        if (target - arr[i] >= 0)
        {
            coinChangePermutationtargetDecide(arr, target - arr[i], ans + to_string(arr[i]));
        }
        coinChangePermutationtargetDecide(arr, target, ans);
    }
}

int sitQueenPermutation(int count, int k, int size, string ans, vector<bool> &isDone)
{
    if (count == k)
    {
        cout << ans << endl;
        return 1;
    }
    int val = 0;

    for (int i = 0; i <= size; i++)
    {
        if (!isDone[i])
        {
            isDone[i] = true;
            val += sitQueenPermutation(count + 1, k, size, ans + "b" + to_string(i) + "q" + to_string(count) + " ", isDone);
            isDone[i] = false;
        }
    }
    return val;
}

int sitQueenCombination(int idx, int count, int k, int size, string ans)
{
    if (count == k)
    {
        cout << ans << endl;
        return 1;
    }
    int val = 0;

    for (int i = idx + 1; i <= size; i++)
    {
        val += sitQueenCombination(i, count + 1, k, size, ans + "b" + to_string(i) + "q" + to_string(count) + " ");
    }
    return val;
}

int sitQueenCombinationSubWay(int idx, int count, int k, int size, string ans)
{
    if (count == k + 1 || idx > size)
    {
        if (count == k + 1)
        {
            cout << ans << endl;
            return 1;
        }
        return 0;
    }
    int val = 0;
    val += sitQueenCombinationSubWay(idx + 1, count + 1, k, size, ans + "b" + to_string(idx) + "q" + to_string(count) + " ");
    val += sitQueenCombinationSubWay(idx + 1, count, k, size, ans);
    return val;
}

int sitQueenPermutationSubWay(int idx, int count, int k, int size, string ans, vector<bool> &isDone)
{
    if (count == k + 1 || idx > size)
    {
        if (count == k + 1)
        {
            cout << ans << endl;
            return 1;
        }
        return 0;
    }
    int val = 0;
    if (!isDone[idx - 1])
    {
        isDone[idx - 1] = true;
        val += sitQueenCombinationSubWay(0, count + 1, k, size, ans + "b" + to_string(idx) + "q" + to_string(count) + " ");
        isDone[idx = 1] = false;
    }
    val += sitQueenCombinationSubWay(idx + 1, count, k, size, ans);
    return val;
}

// void printPermutationNoRepeat(string str,string result){
//     if(str.length()==0){
//         cout<<result+" ";
//         return ;
//     }
//     //bool included[256];
//     unordered_set<char> included;
//     for(int i=0;i<str.length();i++){
//         if(included.empty() || included.find(str[i]) == included.end() ){
//                included.insert(str[i]);
//                string ros=str.substr(0,i)+str.substr(i+1);
//                char cc=str[i];
//                printPermutationNoRepeat(ros,result+cc);
//         }
//     }
// }

int CoinChangepermutation(vector<int> &arr, int target, string ans)
{
    if (target == 0)
    {
        cout << ans << endl;
        return 1;
    }
    int count = 0;
    for (int i = 0; i < arr.size(); i++)
    {
        if (target - arr[i] >= 0)
        {
            count += CoinChangepermutation(arr, target - arr[i], ans + to_string(arr[i]));
        }
    }
    return count;
}

int coinchangeCombination(vector<int> &arr, int idx, int target, string ans)
{
    if (target == 0)
    {
        cout << ans << endl;
        return 1;
    }
    int count = 0;
    for (int i = idx; i < arr.size(); i++)
    {
        if (target - arr[i] >= 0)
        {
            count += coinchangeCombination(arr, i, target - arr[i], ans + to_string(arr[i]));
        }
    }
    return count;
}

int coinchangeCombinationOneCoinOnce(vector<int> &arr, int idx, int target, string ans)
{
    if (target == 0)
    {
        cout << ans << endl;
        return 1;
    }
    int count = 0;
    for (int i = idx; i < arr.size(); i++)
    {
        if (target - arr[i] >= 0)
        {
            count += coinchangeCombinationOneCoinOnce(arr, i + 1, target - arr[i], ans + to_string(arr[i]));
        }
    }
    return count;
}

int coinchangePermutationOneCoinOnce(vector<int> &arr, int target, string ans, vector<bool> &isDone)
{
    if (target == 0)
    {
        cout << ans << endl;
        return 1;
    }
    int count = 0;
    for (int i = 0; i < arr.size(); i++)
    {
        if (!isDone[i] && target - arr[i] >= 0)
        {
            isDone[i] = true;
            count += coinchangePermutationOneCoinOnce(arr, target - arr[i], ans + to_string(arr[i]), isDone);
            isDone[i] = false;
        }
    }
    return count;
}

int coinchangeCombinationSubWay(vector<int> &arr, int idx, int target, string ans)
{
    if (target == 0 || idx == arr.size())
    {
        if (target == 0)
        {
            cout << ans << endl;
            return 1;
        }
        return 0;
    }
    int count = 0;
    if (target - arr[idx] >= 0)
    {
        count += coinchangeCombinationSubWay(arr, idx, target - arr[idx], ans + to_string(arr[idx]));
    }
    count += coinchangeCombinationSubWay(arr, idx + 1, target, ans);
    return count;
}

int coinchangePermutationSubWay(vector<int> &arr, int idx, int target, string ans)
{
    if (target == 0 || idx == arr.size())
    {
        if (target == 0)
        {
            cout << ans << endl;
            return 1;
        }
        return 0;
    }
    int count = 0;
    if (target - arr[idx] >= 0)
    {
        count += coinchangePermutationSubWay(arr, 0, target - arr[idx], ans + to_string(arr[idx]));
    }
    count += coinchangePermutationSubWay(arr, idx + 1, target, ans);
    return count;
}

void coinChangeSeries()
{
    vector<int> arr = {2, 4, 6, 8};
    vector<bool> isDone(4, false);
    // cout<<CoinChangepermutation(arr,10,"")<<endl;
    // cout<<"******************************************************"<<endl;
    // cout<<coinchangeCombination(arr,0,10,"")<<endl;
    // cout<<"******************************************************"<<endl;
    // cout<<coinchangeCombinationOneCoinOnce(arr,0,10,"")<<endl;
    //  cout<<"******************************************************"<<endl;
    // cout<<coinchangePermutationOneCoinOnce(arr,10,"",isDone)<<endl;
    // cout<<"******************************************************"<<endl;
    cout << coinchangeCombinationSubWay(arr, 0, 8, "") << endl;

    // cout<<"******************************************************"<<endl;
    //cout<<coinchangePermutationSubWay(arr,0,10,"")<<endl;
}

int queenSitOneDCombination(int qloc, int qtp, int tnq, int boxeSize, string ans)
{
    if (qtp == tnq + 1 || qloc == boxeSize + 1)
    {
        if (qtp == tnq + 1)
        {
            cout << ans << endl;
            return 1;
        }
        return 0;
    }
    int count = 0;
    for (int i = qloc; i <= boxeSize; i++)
    {
        count += queenSitOneDCombination(i + 1, qtp + 1, tnq, boxeSize, ans + "b" + to_string(i) + "q" + to_string(qtp) + " ");
    }
    return count;
}

int queenSitOneDPermutation(int qtp, int tnq, int boxeSize, string ans, vector<bool> &isDone)
{
    if (qtp == tnq + 1)
    {
        cout << ans << endl;
        return 1;
    }
    int count = 0;
    for (int i = 1; i <= boxeSize; i++)
    {
        if (!isDone[i - 1])
        {
            isDone[i - 1] = true;
            count += queenSitOneDPermutation(qtp + 1, tnq, boxeSize, ans + "b" + to_string(i) + "q" + to_string(qtp) + " ", isDone);
            isDone[i - 1] = false;
        }
    }
    return count;
}

int queenSitOneDCombinationSubWay(int loc, int qtp, int toq, int boxSize, string ans)
{
    if (qtp == toq + 1 || loc == boxSize + 1)
    {
        if (qtp == toq + 1)
        {
            cout << ans << endl;
            return 1;
        }
        return 0;
    }
    int count = 0;
    count += queenSitOneDCombinationSubWay(loc + 1, qtp + 1, toq, boxSize, ans + "b" + to_string(loc) + "q" + to_string(qtp) + " ");
    count += queenSitOneDCombinationSubWay(loc + 1, qtp, toq, boxSize, ans);
    return count;
}

int queenSitOneDPermutationSubWay(int loc, int qtp, int toq, int boxSize, string ans, vector<bool> &isDone)
{
    if (qtp == toq + 1 || loc == boxSize + 1)
    {
        if (qtp == toq + 1)
        {
            cout << ans << endl;
            return 1;
        }
        return 0;
    }
    int count = 0;
    if (!isDone[loc])
    {
        isDone[loc] = true;
        count += queenSitOneDPermutationSubWay(1, qtp + 1, toq, boxSize, ans + "b" + to_string(loc) + "q" + to_string(qtp) + " ", isDone);
        isDone[loc] = false;
    }
    count += queenSitOneDPermutationSubWay(loc + 1, qtp, toq, boxSize, ans, isDone);
    return count;
}
bool isValidTopLaceQueen(vector<vector<bool>> &boxes, int x, int y)
{
    x--;
    y--;
    int dir[4][2] = {{0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};
    for (int d = 0; d < 4; d++)
    {

        for (int rad = 1; rad < boxes[0].size(); rad++)
        {
            int r = x + rad * dir[d][0];
            int c = y + rad * dir[d][1];
            if (r >= 0 && c >= 0 && r < boxes.size() && c < boxes[0].size() && boxes[r][c])
            {
                return false;
            }
        }
    }

    return true;
}

int queenSitTwoDCombinationSubWay(int loc, int qtp, int toq, vector<vector<bool>> &boxes, string ans)
{
    int boxSize = boxes.size() * boxes[0].size();
    if (qtp == toq + 1 || loc == boxSize + 1)
    {
        if (qtp == toq + 1)
        {
            cout << ans << endl;
            return 1;
        }
        return 0;
    }
    int count = 0;
    int row = ((loc - 1) / (boxes.size())) + 1;
    int col = ((loc - 1) % (boxes.size())) + 1;
    if (isValidTopLaceQueen(boxes, row, col))
    {
        boxes[row - 1][col - 1] = true;
        count += queenSitTwoDCombinationSubWay(loc + 1, qtp + 1, toq, boxes, ans + "row=" + to_string(row) + "col=" + to_string(col) + " q" + to_string(qtp) + " ");
        boxes[row - 1][col - 1] = false;
    }
    count += queenSitTwoDCombinationSubWay(loc + 1, qtp, toq, boxes, ans);
    return count;
}

int queenSitTwoDPermutationSubWay(int loc, int qtp, int toq, vector<vector<bool>> &boxes, string ans)
{
    int boxSize = boxes.size() * boxes[0].size();
    if (qtp == toq + 1 || loc == boxSize + 1)
    {
        if (qtp == toq + 1)
        {
            cout << ans << endl;
            return 1;
        }
        return 0;
    }
    int count = 0;
    int row = ((loc - 1) / (boxes.size())) + 1;
    int col = ((loc - 1) % (boxes.size())) + 1;
    if (isValidTopLaceQueen(boxes, row, col))
    {
        boxes[row - 1][col - 1] = true;
        count += queenSitTwoDPermutationSubWay(1, qtp + 1, toq, boxes, ans + "row=" + to_string(row) + "col=" + to_string(col) + " q" + to_string(qtp) + " ");
        boxes[row - 1][col - 1] = false;
    }
    count += queenSitTwoDPermutationSubWay(loc + 1, qtp, toq, boxes, ans);
    return count;
}

int getNumforCrypto(string str, vector<int> &arr)
{
    int num = 0;
    for (int i = 0; i < str.size(); i++)
    {
        int idx = str.at(i) - 'a';
        num = num * 10 + arr[idx];
    }
    return num;
}
int isValidCrypto(string f, string s, string t, vector<int> &arr)
{
    int fval = getNumforCrypto(f, arr);
    int sval = getNumforCrypto(s, arr);
    int tval = getNumforCrypto(t, arr);
    if (fval + sval == tval)
    {
        return true;
    }
    return false;
}
// int cryptoCode(string f,string s,string resultString,vector<int> &arr,int fi,int si){

//     if(fi==f.size()&& si==s.size()){
//         int fsum=getSum(f,arr);
//         int ssum=getSum(s,arr);
//         int ressum=getSum(resultString,arr);
//         if(fsum+ssum==ressum){
//             return 1;
//         }
//         return 0;

//     }

//     int count=0;

//     for(int i=fi;i<f.size();i++ ){
//         int idp=f.at(i)-97;
//         if(arr[idp]!=-1){
//              for(int j=0;j<=9;j++){
//              arr[idp]=j;
//              count+=cryptoCode(f,s,resultString,arr,fi+1,si);
//              arr[idp]=-1;
//         }
//     }

//   }

//     for(int i=si;i<s.size();i++ ){
//         int idp=s.at(i)-97;
//         if(arr[idp]==-1){
//              for(int j=0;j<=9;j++){
//              arr[idp]=j;
//              count+=cryptoCode(f,s,resultString,arr,fi,si+1);
//              arr[idp]=-1;
//         }
//    }

//     }
//     return count;
// }

void printArray(vector<int> &arr)
{
    for (int i = 0; i < arr.size(); i++)
    {
        cout << arr[i] << " ";
    }

    cout << endl;
}

int crypto(string str, int idx, vector<int> &mapper, vector<bool> &numUsed, string f, string s, string t)
{

    if (idx == str.size())
    {
        //cout<<"hellworldd";
        if (isValidCrypto(f, s, t, mapper))
        {
            for (int i = 0; i < mapper.size(); i++)
            {
                if (mapper[i] != -1)
                {
                    char cc = char(i + 'a');
                    cout << cc << ":" << mapper[i] << " ";
                }
            }
            cout << endl;
            return 1;
        }
        return 0;
    }
    int count = 0;

    int iv = str.at(idx) - 97;
    for (int i = 0; i <= 9; i++)
    {
        if (!numUsed[i])
        {
            numUsed[i] = true;
            mapper[iv] = i;
            count += crypto(str, idx + 1, mapper, numUsed, f, s, t);
            numUsed[i] = false;
            mapper[iv] = -1;
        }
    }
    return count;
}
vector<string> dictionary = {"a","aa","aaa","aaaa","aaaaa"};

bool isWordPresent(string word)
{
    for (string s : dictionary)
    {
        if (s.compare(word) == 0)
        {
            return true;
        }
    }
    return false;
}

int wordbreak(string word, string ans)
{
    if (word.size() == 0)
    {
        cout << ans << endl;
        return 1;
    }
    string temp = "";
    int count = 0;
    for (int i = 0; i < word.size(); i++)
    {
        temp += word.at(i);
        if (isWordPresent(temp))
        {
            count += wordbreak(word.substr(i + 1), ans + " " + temp);
        }
    }
    return count;
}

vector<int> rowForSudoku(9,0);
vector<int> colForSudoku(9,0);
vector<vector<int>> matrixForSudoku(3,vector<int>(3,0));

void populateSudoku(vector<vector<int>> board){
    for(int i=0;i<board.size();i++){
        for(int j=0;j<board[0].size();j++){
            if(board[i][j]!=0){
                int val=board[i][j];
                int mask=1<<val;
                rowForSudoku[i]|=mask;
                colForSudoku[j]|=mask;
                matrixForSudoku[i/3][j/3]|=mask;

            }
        }
    }
}

bool isValidSudoku(vector<vector<int>> board, int row, int col, int num)
{
    //row
    for (int i = 0; i < board[row].size(); i++)
    {
        if (board[row][i] == num)
        {
            return false;
        }
    }
    //col
    for (int i = 0; i < board.size(); i++)
    {
        if (board[i][col] == num)
        {
            return false;
        }
    }
    //matrix
    int vr = (row / 3) * 3;
    int vc = (col / 3) * 3;
    for (int i = 0; i < 3; i++)
    {
        for (int j = 0; j < 3; j++)
        {
            if (board[vr + i][vc + j] == num)
                return false;
        }
    }

    return true;
}

int sudokuSolver(vector<vector<int>> board, int counter)
{
    if (counter == board.size() * board.size())
    {
        for (vector<int> ar : board)
        {
            for (int ele : ar)
            {
                //System.out.print(ele+" ");
                cout << ele << " ";
            }
            cout << endl;
        }
        cout << "**************************" << endl;
        return 1;
    }
    int count = 0;
    int row = counter / 9;
    int col = counter % 9;
    if (board[row][col] != 0)
    {
        count += sudokuSolver(board, counter + 1);
    }
    else
    {
        for (int i = 1; i <= 9; i++)
        {
            if ( (rowForSudoku[row]&(1<<i))==0 && (colForSudoku[col]&(1<<i))==0 && (matrixForSudoku[row/3][col/3]&(1<<i))==0 )
            {
                int mask=1<<i;
                board[row][col] = i;
                rowForSudoku[row]|=mask;
                colForSudoku[col]|=mask;
                matrixForSudoku[row/3][col/3]|=mask;
                count += sudokuSolver(board, counter + 1);
                board[row][col] = 0;
                rowForSudoku[row]&=(~mask);
                colForSudoku[col]&=(~mask);
                matrixForSudoku[row/3][col/3]&=(~mask);
            }
        }
    }
    return count;
}

int getLeftNonBurst(vector<int>&arr,vector<bool>&isDone,int i){
    for(int j=i-1;j>=0;j--){
        if(!isDone[j]){
            return arr[j];
        }   
    }
    return -1;
}

int getRightNonBurst(vector<int>&arr,vector<bool>&isDone,int i){
    for(int j=i+1;j<arr.size();j++){
        if(!isDone[j]){
            return arr[j];
        }   
    }
    return arr.size();
}

int  ballonBurst(vector<int>&arr,vector<bool>&isDone,int tempProfit,int counter){
   if(counter==arr.size()){
     return tempProfit;
   }
   int maxAns=INT16_MIN;
  
   for(int i=0;i<arr.size();i++){
       if(!isDone[i]){
       isDone[i]=true;
       int cc =arr[i];
       int leftVal=getLeftNonBurst(arr,isDone,i)==-1?1:getLeftNonBurst(arr,isDone,i);
       int rightVal=getRightNonBurst(arr,isDone,i)==arr.size()?1:getRightNonBurst(arr,isDone,i);
       int score=cc*leftVal*rightVal;
       int recAns=ballonBurst(arr,isDone,score+tempProfit,counter+1);
       isDone[i]=false;
       maxAns=max(maxAns,recAns);

       }
   }
   return maxAns;

}


// void  ballonBurst(vector<int>&arr,vector<bool>&isDone,int tempProfit,vector<int>&maxtillnow,int counter){
//    if(counter==arr.size()){
//        maxtillnow[0]=max(maxtillnow[0],tempProfit);
//        return ;
//    }
  
//    for(int i=0;i<arr.size();i++){
//        if(!isDone[i]){
//        isDone[i]=true;
//        int cc =arr[i];
//        int leftVal=getLeftNonBurst(arr,isDone,i)==-1?1:getLeftNonBurst(arr,isDone,i);
//        int rightVal=getRightNonBurst(arr,isDone,i)==arr.size()?1:getRightNonBurst(arr,isDone,i);
//        int max=cc*leftVal*rightVal;
//        ballonBurst(arr,isDone,max+tempProfit,maxtillnow,counter+1);
//        isDone[i]=false;
//        }
//    }

// }


int main()
{
//     vector<int> arr={3,1,5,8};
//     vector<bool>isDone(4,false);
//     vector<int> maxtillnow(1,INT16_MIN);
//     cout<<ballonBurst(arr,isDone,0,0);
//    // cout<<maxtillnow[0];


     cout << wordbreak("aaaaa", "");

    // //  vector<int> arr (26,-1);
    // //  vector<bool> brr(10,false);
    // //  int a=crypto("sendmory",0,arr,brr,"send","more","money");
    // //  cout<<a;
    // vector<vector<int>> board = {{3, 0, 6, 5, 0, 8, 4, 0, 0},
    //                              {0, 0, 0, 0, 0, 0, 0, 0, 0},
    //                              {4, 8, 7, 0, 0, 0, 0, 3, 1},
    //                              {0, 0, 3, 0, 1, 0, 0, 8, 0},
    //                              {9, 0, 0, 8, 6, 3, 0, 0, 5},
    //                              {0, 5, 0, 0, 9, 0, 6, 0, 0},
    //                              {1, 3, 0, 0, 0, 0, 2, 5, 0},
    //                              {0, 0, 0, 0, 0, 0, 0, 7, 4},
    //                              {0, 0, 5, 2, 0, 6, 3, 0, 0}};
    //                             populateSudoku(board);
    // cout << sudokuSolver(board, 0);
    return 0;
}