class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        boolean[][] isVisited = new boolean[row][col];
        int maxArea = 0;
        int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
        
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==1 && !isVisited[i][j]){
                    maxArea = Math.max(maxArea, dfs(grid, isVisited, i, j, dir));
                }
            }
        }
        return maxArea;
    }
    
    public int dfs(int[][] grid, boolean[][] isVisited, int i, int j, int[][] dir){
        
        if(grid[i][j]==0){
            return 0;
        }
        
        isVisited[i][j] = true;
        int res = 1;
        for(int k=0;k<dir.length;k++){
            int nr = i+dir[k][0], nc = j+dir[k][1];
            if(isValidIndex(isVisited, nr, nc)){
                res = res + dfs(grid, isVisited, nr, nc, dir);
            }
        }
        return res;
    }
    
    public boolean isValidIndex(boolean[][] isVisited, int r, int c){
        if(r>=0 && c>=0 && r<isVisited.length && c<isVisited[0].length && !isVisited[r][c]){
            return true;
        }
        return false;
    }
}