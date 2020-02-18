 #include<iostream>
 #include<vector>
 using namespace std;

 
 int countServers(vector<vector<int>>& grid) {
    int count=0;
    int n=grid.size();
    int m=grid[0].size();
    vector<int> r(n,0);
    vector<int> c(m,0);
    
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            if(grid[i][j]==1){ 
                r[i]++;
                c[j]++;
            }
        }
    }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    if(r[i]>1 || c[j]>1)
                    count++;
                }
            }
        }


        return count;
        
}
        



int main(){
    vector< vector<int>> grid ={{1,1,0,0},{0,0,1,0},{0,0,1,0},{0,0,0,1}};
    cout<<countServers(grid)<<endl;
    return 0;

}