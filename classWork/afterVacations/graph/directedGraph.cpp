using namespace std;
#include<iostream>
#include<vector>
#include<queue>

int sizeGraph =10;

class Edge {

public :
    int v=0;
    int w=0;

    Edge(int v,int w){
       this->v=v;
       this->w=w;
    }

};

vector < vector<Edge *>  > graph (sizeGraph , vector<Edge *>() ); 
vector < vector<Edge *>  > inverseGraph (sizeGraph , vector<Edge *>() ); 



void addEdge(int u,int v,int w){
    if(u < 0 || v < 0 || u >=graph.size() ||v>=graph.size())return ;
    graph[u].push_back(new Edge(v,w));
    inverseGraph[v].push_back(new Edge(u,w));

}

Edge* removeEdge(int u,int v){
   Edge * rvt;
   for (int  i = 0; i < graph[u].size(); i++)
   {
      if(graph[u][i]->v==v){
        rvt =graph[u][i];
        graph[u].erase(graph[u].begin()+i);
      }
   }
    //remove from reverse graph
    for (int  i = 0; i < inverseGraph[v].size(); i++)
    {
      if(inverseGraph[v][i]->v==u){
        inverseGraph[v].erase(inverseGraph[v].begin()+i);
      }
    }


    return rvt;
   
}

void contructGraph(){
    addEdge(1,0,3);
    addEdge(0,6,3);
    addEdge(6,5,3);
    addEdge(5,6,3);
    addEdge(0,4,3);
    addEdge(2,0,3);
    addEdge(3,2,3);
    addEdge(4,3,3);
    addEdge(7,4,56);
    addEdge(7,3,3);
    addEdge(8,2,3);
    addEdge(8,7,3);
    addEdge(8,9,3);
    addEdge(9,1,3);
    addEdge(1,8,56);


}

void display(){
  for(int i=0;i<graph.size();i++){
      cout<<i<<"=>";
      for(Edge *e:graph[i]){
        cout<<"("<<e->v<<","<<e->w<<")";
      }
      cout<<endl;
  }
}

void displayInverse(){
  for(int i=0;i<inverseGraph.size();i++){
      cout<<i<<"=>";
      for(Edge *e:inverseGraph[i]){
        cout<<"("<<e->v<<","<<e->w<<")";
      }
      cout<<endl;
  }
}


void DFS(int source,vector<bool> & visited){
    visited[source]=true;
    cout<<source<<" ";
    for(Edge *e:graph[source]){
        if(!visited[e->v]){
            DFS(e->v,visited);
        }
    }
}

void dfsController(){
  vector<bool> visited (sizeGraph,false);
  for(int i=0;i<visited.size();i++){
      if(!visited[i]){
          DFS(i,visited);
      }
  }
}

void BFS(int source, vector<bool>& visited){
    queue<int> q;
    q.push(source);
    while(!q.empty()){
        int front =q.front();
        q.pop();
        if(visited[front]){
            cout<<"there is a cycle at "<<front;
        }else{
            cout<<front<<" ";
            visited[front]=true;
            for(Edge* e:graph[front]){
                if(!visited[e->v]){
                    q.push(e->v);
                }
            }
        }

    }
}


void bfsController(){
  vector<bool> visited (sizeGraph,false);
  for(int i=0;i<visited.size();i++){
      if(!visited[i]){
        BFS(i,visited);
      }
  }
}


void topoSort(int source,vector<bool>&visited,vector<int>&stack){
    visited[source]=true;
    for(Edge *e:graph[source]){
        if(!visited[e->v]){
            topoSort(e->v,visited,stack);
        }
    }
    stack.push_back(source);
   
}

void DFSinverse(int source,vector<bool> & visited){
    visited[source]=true;
    for(Edge *e:inverseGraph[source]){
        if(!visited[e->v]){
            DFSinverse(e->v,visited);
        }
    }
}


int totalSccComponent(){
    vector<bool> visited(sizeGraph,false);
    vector<int> stack;
    int ans =0;
    for (int i = 0; i < visited.size(); i++)
    {
        if(!visited[i]){
           topoSort(i,visited,stack);
        }
    }
    for (int i = 0; i < stack.size(); i++)
    {
        cout<<stack[i]<<" ";
    }
    cout<<endl;
    
    vector<bool> visitedNew(sizeGraph,false); 
    while(!stack.empty()){
       if(!visitedNew[stack.back()]){
          ans++;
          DFSinverse(stack.back(),visitedNew);
       }
        stack.pop_back();
    }
    return ans;


}






int main(){
    //cout <<"hello world"<<endl;
    contructGraph();
    display();
     cout<<"***************************************"<<endl;
    // dfsController();
    // cout<<"***************************************"<<endl;
    // bfsController();

    cout<<totalSccComponent()<<endl;
}
