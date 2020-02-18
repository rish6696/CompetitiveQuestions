using namespace std;
#include<iostream>
#include<vector>
#include<queue>





    void bfs(vector<vector<int>> &grid, queue<pair<int, int>> &lands, int &maxDistance) {
        while (!lands.empty()) {
            auto curLand = lands.front();
            lands.pop();
            pair<int, int> directions[4] = { {0, 1}, {0, -1}, {-1, 0}, {1, 0} };
            for (auto dir : directions) {
                int nx = curLand.first + dir.first;
                int ny = curLand.second + dir.second;
                if (nx >= 0 && nx < grid.size() && ny >= 0 && ny < grid.size() && grid[nx][ny] == 0) {
                    lands.push({nx, ny});
                    grid[nx][ny] = grid[curLand.first][curLand.second] + 1;
                    maxDistance = max(maxDistance, grid[nx][ny]);
                }
            }
        }
    }

int maxDistance(vector<vector<int>>& grid) {
        int M = grid.size(), maxDistance = 0;
        queue<pair<int, int>> lands;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                if (grid[i][j] == 1) {
                    lands.push({i, j});
                }
            }
        }
        bfs(grid, lands, maxDistance);
        return maxDistance - 1;
    }
    




    int main(){
    vector< vector<int> > grid ={{1,0,1},{0,0,0},{1,0,1}};
    cout<<maxDistance(grid)<<endl;
    return 0;
}