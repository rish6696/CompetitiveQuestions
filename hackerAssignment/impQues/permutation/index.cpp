#include <iostream>
#include<vector>
#include<string>
using namespace std;


int CoinChangepermutation(vector<int>&arr,int target,string ans){
    if (target==0)
    {
        cout<<ans<<endl;
        return 1;
    }
    int count=0;
    for(int i=0;i<arr.size();i++){
       if(target-arr[i]>=0){
          count+=CoinChangepermutation(arr,target-arr[i],ans+to_string(arr[i]));
       }
    }
    return count;
}

int coinchangeCombination(vector<int> &arr,int idx,int target,string ans){
    if(target==0){
        cout<<ans<<endl;
        return 1;
    }
    int count=0;
    for(int i=idx;i<arr.size();i++){
        if(target-arr[i]>=0){
          count+=coinchangeCombination(arr,i,target-arr[i],ans+to_string(arr[i]));
        }
    }
    return count;
}

int coinchangeCombinationOneCoinOnce(vector<int> &arr,int idx,int target,string ans){
    if(target==0){
        cout<<ans<<endl;
        return 1;
    }
    int count=0;
    for(int i=idx;i<arr.size();i++){
        if(target-arr[i]>=0){
          count+=coinchangeCombinationOneCoinOnce(arr,i+1,target-arr[i],ans+to_string(arr[i]));
        }
    }
    return count;
}

int coinchangePermutationOneCoinOnce(vector<int> &arr,int target,string ans,vector<bool>&isDone){
    if(target==0){
        cout<<ans<<endl;
        return 1;
    }
    int count=0;
    for(int i=0;i<arr.size();i++){
        if(!isDone[i]&&target-arr[i]>=0){
          isDone[i]=true;
          count+=coinchangePermutationOneCoinOnce(arr,target-arr[i],ans+to_string(arr[i]),isDone);
          isDone[i]=false;
        }
    }
    return count;
}

int coinchangeCombinationSubWay(vector<int>&arr,int idx,int target,string ans){
    if(target==0||idx==arr.size()){
        if(target==0){
           cout<<ans<<endl;
           return 1;
        }
        return 0;
    }
    int count=0;
    if(target-arr[idx]>=0){
         count+=coinchangeCombinationSubWay(arr,idx,target-arr[idx],ans+to_string(arr[idx]));
    }
    count+=coinchangeCombinationSubWay(arr,idx+1,target,ans);
    return count;
}


int coinchangePermutationSubWay(vector<int>&arr,int idx,int target,string ans){
    if(target==0||idx==arr.size()){
        if(target==0){
           cout<<ans<<endl;
           return 1;
        }
        return 0;
    }
    int count=0;
    if(target-arr[idx]>=0){
         count+=coinchangePermutationSubWay(arr,0,target-arr[idx],ans+to_string(arr[idx]));
    }
    count+=coinchangePermutationSubWay(arr,idx+1,target,ans);
    return count;
}


void coinChangeSeries(){
    vector<int> arr={2,4,6,8};
    vector<bool> isDone(4,false);
    // cout<<CoinChangepermutation(arr,10,"")<<endl;
    // cout<<"******************************************************"<<endl;
   // cout<<coinchangeCombination(arr,0,10,"")<<endl;
    // cout<<"******************************************************"<<endl;
    // cout<<coinchangeCombinationOneCoinOnce(arr,0,10,"")<<endl;
    //  cout<<"******************************************************"<<endl;
    // cout<<coinchangePermutationOneCoinOnce(arr,10,"",isDone)<<endl;
    // cout<<"******************************************************"<<endl;
     cout<<coinchangeCombinationSubWay(arr,0,8,"")<<endl;

    // cout<<"******************************************************"<<endl;
    //cout<<coinchangePermutationSubWay(arr,0,10,"")<<endl;
}

int queenSitOneDCombination(int qloc,int qtp,int tnq,int boxeSize,string ans){
    if(qtp==tnq+1||qloc==boxeSize+1){
        if(qtp==tnq+1){
            cout<<ans<<endl;
            return 1;
        }
        return 0;
    }
    int count =0;
    for(int i=qloc;i<=boxeSize;i++){
        count+=queenSitOneDCombination(i+1,qtp+1,tnq,boxeSize,ans+"b"+to_string(i)+"q"+to_string(qtp)+" ");
    }
    return count;
}

int queenSitOneDPermutation(int qtp,int tnq,int boxeSize,string ans,vector<bool>&isDone){
    if(qtp==tnq+1){
       cout<<ans<<endl; 
       return 1;
    }
    int count =0;
    for(int i=1;i<=boxeSize;i++){
        if(!isDone[i-1]){
         isDone[i-1]=true;
         count+=queenSitOneDPermutation(qtp+1,tnq,boxeSize,ans+"b"+to_string(i)+"q"+to_string(qtp)+" ",isDone);
         isDone[i-1]=false;
       }
    }
    return count;
}


int queenSitOneDCombinationSubWay(int loc,int qtp,int toq,int boxSize,string ans){
   if(qtp==toq+1||loc==boxSize+1){
       if(qtp==toq+1){
           cout<<ans<<endl;
           return 1;
       }
       return 0;
   }
   int count =0;
   count+=queenSitOneDCombinationSubWay(loc+1,qtp+1,toq,boxSize, ans+"b"+to_string(loc)+"q"+to_string(qtp)+" ");
   count+=queenSitOneDCombinationSubWay(loc+1,qtp,toq,boxSize,ans);
   return count;
}

int queenSitOneDPermutationSubWay(int loc,int qtp,int toq,int boxSize,string ans,vector<bool>&isDone){
   if(qtp==toq+1||loc==boxSize+1){
       if(qtp==toq+1){
           cout<<ans<<endl;
           return 1;
       }
       return 0;
   }
   int count =0;
   if(!isDone[loc]){
     isDone[loc]=true;
     count+=queenSitOneDPermutationSubWay(1,qtp+1,toq,boxSize, ans+"b"+to_string(loc)+"q"+to_string(qtp)+" ",isDone);
     isDone[loc]=false;
   }
   count+=queenSitOneDPermutationSubWay(loc+1,qtp,toq,boxSize,ans,isDone);
   return count;
}
bool isValidTopLaceQueen(vector<vector<bool>>&boxes,int x,int y){
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

int queenSitTwoDCombinationSubWay(int loc,int qtp,int toq,vector<vector<bool>> &boxes,string ans){
   int boxSize=boxes.size()*boxes[0].size();
   if(qtp==toq+1||loc==boxSize+1){
       if(qtp==toq+1){
           cout<<ans<<endl;
           return 1;
       }
       return 0;
   }
   int count =0;
   int row=((loc-1)/(boxes.size()))+1;
   int col =((loc-1)%(boxes.size()))+1;
   if(isValidTopLaceQueen(boxes,row,col)){
    boxes[row-1][col-1]=true;
    count+=queenSitTwoDCombinationSubWay(loc+1,qtp+1,toq,boxes, ans+"row="+to_string(row)+"col="+to_string(col)+" q"+to_string(qtp)+" ");
    boxes[row-1][col-1]=false;
   }
   count+=queenSitTwoDCombinationSubWay(loc+1,qtp,toq,boxes,ans);
   return count;
}



void queenSeries(){
  //cout<<queenSitOneDCombination(1,1,3,7,"");
   //vector<bool> isDone(5,false);
   //cout<<queenSitOneDPermutation(1,3,3,"",isDone);
   vector<vector<bool>> isDone(4,vector<bool>(4,false));
   cout<<queenSitTwoDCombinationSubWay(1,1,4,isDone,"");
  
}

int main(){
    
     queenSeries();
    return 0;
}
