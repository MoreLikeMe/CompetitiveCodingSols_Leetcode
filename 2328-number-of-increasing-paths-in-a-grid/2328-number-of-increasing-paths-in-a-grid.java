class Solution {
    public int countPaths(int[][] grid) {
        int count = 0;
        int[][] cache = new int[grid.length][grid[0].length];
        int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                count = (count + dfs(grid, i, j, dir, cache))%1000000007;
            }
        }
        return count;
    }
    
    public int dfs(int[][] grid, int r, int c, int[][] dir, int[][] cache){
        
        if(cache[r][c]!=0){
            return cache[r][c];
        }
        cache[r][c] = 1;
        for(int i=0;i<dir.length;i++){
            int nextRow = r+dir[i][0];
            int nextCol = c+dir[i][1];
            if(isValid(grid, nextRow, nextCol) && grid[nextRow][nextCol]>grid[r][c]){
                cache[r][c] = (cache[r][c] + dfs(grid, nextRow, nextCol, dir,cache))%1000000007;
            }
        }
        return cache[r][c];
    }
    
    public boolean isValid(int[][] grid, int r, int c){
        int row = grid.length;
        int col = grid[0].length;
        if(r>=0 && r<row && c>=0 && c<col){
            return true;
        }
        return false;
    }
}