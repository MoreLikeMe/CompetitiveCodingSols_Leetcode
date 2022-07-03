class Solution {
    public int numSquares(int n) {
        
        List<Integer> sq = new ArrayList<Integer>();
        for(int i=1;i*i<=n;i++){
            sq.add(i*i);
        }
        
        int[] dp = new int[n+1];
        
        for(int i=1;i<=n;i++){
            dp[i] = Integer.MAX_VALUE;
            for(int s: sq){
                if(i-s>=0){
                    dp[i] = Math.min(dp[i], dp[i-s]+1);
                } else {
                    break;
                }
            }
        }
        return dp[n];
    }
}