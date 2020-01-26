using namespace std;
#include<iostream>
#include<vector>



bool isValidIndex(vector<vector<int>> &matrix,int x,int y){
    if(x<0||y<0||x>=matrix.size()||y>=matrix[0].size())return false;
    return true;
}


void game( vector<vector<int>> &matrix){
    vector< vector<int>> directions  ={{1,0},{0,1},{-1,0},{0,-1},{-1,-1},{1,1},{1,-1},{-1,1}};
    for(int i=0;i<matrix.size();i++){
        for (int j = 0; j < matrix[0].size(); j++)
        {
            int liveNeighbours=0;
            for(int d=0;d<directions.size();d++){
                int x= i+directions[d][0];
                int y= j+directions[d][1];
                if(isValidIndex(matrix,x,y)){
                    if(matrix[x][y]==1||matrix[x][y]==-1){
                    liveNeighbours++;
                 }
                }
            }
            int deadNeighbours = 8-liveNeighbours;
            if(matrix[i][j]==1){
                if(liveNeighbours<2 || liveNeighbours > 3 ){
                    matrix[i][j]=-1;
                }   
            }
            if(matrix[i][j]==0){
                if(liveNeighbours==3){
                    matrix[i][j]=2;
                }
            }
        }
        
    }

    for(int i=0;i<matrix.size();i++){
        for(int j=0;j<matrix[0].size();j++){
            if(matrix[i][j]==2){
                matrix[i][j]=1;
            }
            if(matrix[i][j]==-1){
                matrix[i][j]=0;
            }
        }
    }

}
int main(){
    vector< vector<int> > matrix ={
  {0,1,0},
  {0,0,1},
  {1,1,1},
  {0,0,0}
};
        game(matrix);
       for(int i=0;i<matrix.size();i++){
        for(int j=0;j<matrix[0].size();j++){
            cout<<matrix[i][j]<<" ";
        }
        cout<<endl;
    }
    
}