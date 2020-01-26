#include<iostream>
#include<vector>
#include<queue>
using namespace std;


class Edge{
    public:
    int v=0;
    int w=0;

    Edge(int v,int w){
      this->v=v;
      this->w=w;
    }

};

int Sizegraph= 4;





vector< vector<Edge *> > graph (Sizegraph, vector<Edge * >() );
void addEdge(int u,int v,int w){
    if(u < 0 || v < 0 || u >=graph.size() ||v>=graph.size())return ;
    graph[u].push_back(new Edge(v,w));
    graph[v].push_back(new Edge(u,w));
}

int  findShortestDistance(int source,int destination){
    queue <int> q;
    vector<bool> visited(Sizegraph,false);
    q.push(source);
    int level =0;
    while(!q.empty()){
        int size =q.size();
        while(size>0){
            size--;
            int rvtx =q.front();
            q.pop();
            if(rvtx==destination){
               return level;
            }
            visited[rvtx]=true;
            for(Edge* e:graph[rvtx]){
                if(!visited[e->v]){
                    q.push(e->v);
                }
            }
        }
        level++;
    }
}


int calCycles(int source){
    queue <int> q;
    int cycles =0;
    vector<bool> visited(Sizegraph,false);
    q.push(source);
    while(!q.empty()){
      int rvtx =q.front();
      q.pop();
      if(visited[rvtx]){
        cout<<"cycles is at "<<rvtx<<endl;
        cycles++;
      }else{
        visited[rvtx]=true;
        for(Edge * e:graph[rvtx]){
            if(!visited[e->v]){
              q.push(e->v); 
            }
        }
      }
    }
    return cycles;

}

void removeEdge(int u,int v){
    int w=0;
    for(int i=0;i<graph[u].size();i++){
        Edge * e=graph[u][i];
        if(e->v==v){
            graph[u].erase(graph[u].begin()+i);
            break;
        }
    }
    for(int i=0;i<graph[v].size();i++){
        Edge * e=graph[v][i];
        if(e->v==u){
            graph[v].erase(graph[v].begin()+i);
            break;
        }
    }   
}

void removeEdge2(int u,int v){
    vector <Edge *>& indexList = graph[u];
    vector <Edge *>& m = graph[v];

    cout<<&indexList<<endl;
    int w=0;
    for(int i=0;i<indexList.size();i++){
        Edge * e=indexList[i];
        if(e->v==v){
            indexList.erase(indexList.begin()+i);
            break;
        }
    }
   
    
    for(int i=0;i<m.size();i++){
        Edge * e=m[i];
        if(e->v==u){
            m.erase(m.begin()+i);
            break;
        }
    }   
}




void constructGraph(){
        addEdge(0, 1, 5);
        addEdge(1, 2, 10);
        addEdge(2, 3, 20);
      
        // addEdge(0, 1, 5);
        // addEdge(1, 2, 7);
        // addEdge(2, 3, -8);
        // addEdge(3, 4, 10);
        // addEdge(4, 5, 1);
        // addEdge(5, 6, 2);
        // addEdge(6, 7, 9);
        // addEdge(2, 5, -1);
        // addEdge(1, 6, 3);
        // addEdge(3, 5, 9);
        // addEdge(1, 5, 5);
        // addEdge(0, 6, 11);
        // addEdge(1, 7, 6);

    // addEdge(0, 1, 10);
    // addEdge(0, 3, 10);
    // addEdge(1, 2, 10);
    // addEdge(2, 3, 40);
    // addEdge(3, 4, 2);
    // addEdge(4, 5, 2);
    // addEdge(4, 6, 3);
    // addEdge(5, 6, 8);
    
    
}

void display(){
    for(int i=0;i<graph.size();i++){
        cout<<i<<"->";
        vector<Edge *> &indexList=graph[i];
        for(int j=0;j<indexList.size();j++){
            cout<<"("<<indexList[j]->v<<","<<indexList[j]->w<<")";
        }
        cout<<endl;
    }
}

void basicBFS(int source){
    queue <int> q;
    vector<bool> visited (7,false);
    while (!q.empty())
    {
        int rtvx=q.front();
        q.pop();
        visited[rtvx]=true;
        for(Edge* e:graph[rtvx]){
            if(!visited[rtvx]){
                q.push(e->v);
            }
        }
    }
    
}


void BFS(int source,int destination){
    queue <int> q;
    vector<bool> visited (7,false);
    q.push(source);
    q.push(-1);
    int level =0;
    int cycle=0;
    while (q.size()!=1)
    {
        int front = q.front();
        q.pop();

        // if(front==destination){
        //     cout<<"shortest distance is "<<level;
        // }

        if(visited[front]){
          cycle++;
          continue;
        }
        visited[front]=true;
        for(int i=0;i<graph[front].size();i++){
            Edge * e=graph[front][i];
            if(!visited[e->v]){
                q.push(e->v);
            }
        }
        front =q.front();
        if(front==-1){
            level++;
            q.pop();
            q.push(-1);
        }
    }


    cout<<"number of cycles are"<<cycle<<endl;
    

}


void BFS2(int source ,int destination){
    queue <int> q;
    vector<bool> visited (7,false);
    q.push(source);
    int level =1;
    int cycle =0;
    while(!q.empty()){
        int size =q.size();
        while(size >0){
            
            int front =q.front();
            q.pop();
            if(front==destination){
                cout<<"shortest path is from "<<level<<endl;
            }
            if(visited[front]){
                cycle++;  
            }
            else
            {
                visited[front]=true;
                for(int i=0;i<graph[front].size();i++){
                 Edge * e=graph[front][i];
                  if(!visited[e->v]){
                   q.push(e->v);
                }
            }
         }
         size--; 

        }
        level++;

    }


    cout<<"total cycles are "<<cycle<<endl;
}






int main(){
    constructGraph();
    display();
    cout<<findShortestDistance(0,2)<<endl;
    cout<<calCycles(0)<<endl;    
}