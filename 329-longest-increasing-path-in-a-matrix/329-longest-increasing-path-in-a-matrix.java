class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i], -1);
        }
        
        int maxLen = 0;
        int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(dp[i][j]==-1){
                    maxLen = Math.max(maxLen, longestPath(matrix, dp, dir, i, j));
                }
            }
        }
        
        return maxLen;
    }
    
    public int longestPath(int[][] matrix, int[][] dp, int[][] dir, int i, int j){
        
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        
        dp[i][j] = 1;
        for(int k=0;k<dir.length;k++){
            int nr = i+dir[k][0], nc = j+dir[k][1];
            if(isValidIndex(nr,nc,matrix) && matrix[i][j]<matrix[nr][nc]){
                dp[i][j] = Math.max(dp[i][j], longestPath(matrix, dp, dir, nr, nc)+1);
            }
        }
        return dp[i][j];
    }
    
    public boolean isValidIndex(int nr, int nc, int[][] matrix){
        int r = matrix.length, c = matrix[0].length;
        if(nr>=0 && nc>=0 && nr<r && nc<c){
            return true;
        }
        return false;
    }
}