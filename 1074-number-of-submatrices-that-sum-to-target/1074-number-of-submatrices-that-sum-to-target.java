class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m+1][n+1];
        
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                dp[i][j] = matrix[i-1][j-1]+dp[i-1][j]+dp[i][j-1]-dp[i-1][j-1];
            }
        }
        
        int count = 0;
        
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
               //for each cell need to calculate the sum of submatrix
               //emding at this cell
               for(int r=i-1;r>=0;r--){
                   for(int c=j-1;c>=0;c--){
                       if(target==(dp[i][j]-dp[r][j]-dp[i][c]+dp[r][c])){
                           count++;
                       }
                   }
               } 
            }
        }
        return count;
    }
}