#include<iostream>
#include<queue>
using namespace std;


bool detectCycle(vector<int> &arr){
    vector<int> graph (arr.size(),0);
    vector<bool> visited (arr.size(),false);

    for (int i = 0; i < arr.size(); i++) graph[i]= (i+arr[i])%graph.size();
    queue <int> q;
    q.push(0);
    while(!q.empty()){
       int front =q.front();
       q.pop();
       if(visited[front])return true;
       visited[front]=true;
       if(!visited[graph[front]]) q.push( graph[front] );
      
    }


    return false;
    
    
}

bool cycleInDirected(int source,vector<int>&graph,vector<int>&arr,vector<bool>&visited,vector<bool>&inStack,bool forward,bool isFirst){
    visited[source]=true;
    inStack[source]=true;

    int go=graph[source];
    int valAt =arr[source];
    if(isFirst){
        bool tosend=arr[source]>0?true:false;
        bool recAns =cycleInDirected(go,graph,arr,visited,inStack,tosend,false);
        if(recAns)return true;
    }else{
       if(!visited[go]){
        if(valAt<0 && !forward ||valAt>0&&forward ){
           bool recAns =cycleInDirected(go,graph,arr,visited,inStack,forward,false);
           if(recAns)return true;
        }
       }else{
           if(inStack[go] && source!=go){

               if(valAt<0 && !forward ||valAt>0&&forward )return true;
           }
       }
    }
    inStack[source]=false;
    return false;

}


int main(){ 
   vector<int> arr={-1,-2,-3,-4,-5};
   vector<int> graph (arr.size(),0);
   for (int i = 0; i < graph.size(); i++)
   { 
       int a=arr[i];
       int b=graph.size();
       int val=a+i;
       val %=b;
       if(val<0) val+=graph.size();
       graph[i]=val;
   }
   vector<bool> visited ( arr.size(),false);
   vector<bool> inStack (arr.size(),false);
   bool tosend = arr[0]<0?false:true;
   for(int i=0;i<visited.size();i++){
       if(!visited[i]){
           bool ans =cycleInDirected(i,graph,arr,visited,inStack,false,true);
           if(ans){
               cout<< (boolalpha) <<ans<<endl;
               return ;
           }
          
       }
   }


   cout<<"false";



   return 0;

}