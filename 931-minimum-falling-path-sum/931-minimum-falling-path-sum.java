class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n+1][n+2];
        
        for(int i=0;i<=n;i++){
            dp[i][0]=Integer.MAX_VALUE;
            dp[i][n+1]=Integer.MAX_VALUE;
        }
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                dp[i][j] = matrix[i-1][j-1] + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i-1][j+1])); 
            }
        }
        
        int min = Integer.MAX_VALUE;
        for(int i=1;i<=n;i++){
            if(min>dp[n][i])
                min = dp[n][i];
        }
        for(int i=0;i<=n;i++){
            for(int j=0;j<=n+1;j++){
                System.out.print(dp[i][j] + " "); 
            }
            System.out.println();
        }
        return min;
    }
}