#include <vector>

using namespace std;

class Solution {
    int n, m;
    int max = 0;
    int count;
    vector<vector<int>> v;
public:

    void dfs(int i, int j) {
        if (i == this->n || j == this->m || i < 0 || j < 0) return;
        if (this->v[i][j] == 0) return;
        this->v[i][j] = 0;
        this->count++;
        dfs(i, j + 1);
        dfs(i, j - 1);
        dfs(i + 1, j);
        dfs(i - 1, j);
    }

    int maxAreaOfIsland(vector<vector<int>>& grid) {
        this->v = grid;
        this->n = grid.size();
        this->m = grid[0].size();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (this->v[i][j]) {
                    count = 0;
                    dfs(i, j);
                    if (this->count > this->max) {
                        this->max = this->count;
                    }
                }
            }
        }
        return this->max;
    }
};