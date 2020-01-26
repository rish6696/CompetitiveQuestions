#include<iostream>
#include<vector>
using namespace std;

void setmax(vector<int> &maxarray,int val,vector<int> &found){
  if(val>=maxarray[0]){
    if(val==maxarray[0]){
          if(val==INT32_MIN)found[0]++;
          return ;
      }
    found[0]++;
    maxarray[2]=maxarray[1];
    maxarray[1]=maxarray[0];
    maxarray[0]=val;
  }
  else if(val>=maxarray[1] ){
      if(val==maxarray[1]){
          if(val==INT32_MIN)found[0]++;
          return ;
      }
      found[0]++;
      maxarray[2]=maxarray[1];
      maxarray[1]=val;
  }
  else if(val>=maxarray[2] ){
       if(val==maxarray[2]){
          if(val==INT32_MIN)found[0]++;
          return ;
      }
      found[0]++;
      maxarray[2]=val;
  }
   
}


int thirdmax(vector<int> &arr){
  
  vector<int> max(3,INT32_MIN);
  vector<int> found(1,0);
  for (int i = 0; i < arr.size(); i++)
  {
    setmax(max,arr[i],found);
  }
  if(found[0]<3){
      return max[0];
  }
  return max[2];
  
}
int main(){ 
    vector<int> arr={INT32_MIN,2,1};
    cout<<thirdmax(arr)<<endl;
    return 0;
    
 }