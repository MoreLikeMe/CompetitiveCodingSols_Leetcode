class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int r = obstacleGrid.length;
        int c = obstacleGrid[0].length;
        
        int[][] dp = new int[r+1][c+1];
        
        for(int i=1;i<=r;i++){
            for(int j=1;j<=c;j++){
                if(i==1 && j==1 && obstacleGrid[0][0]==0){
                    dp[1][1] = 1;
                    continue;
                }
                if(obstacleGrid[i-1][j-1]==0){
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[r][c];
    }
}