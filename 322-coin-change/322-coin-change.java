class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount==0){
            return 0;
        }
        int[] dp = new int[amount+1];
        Arrays.fill(dp, -1);
        
        for(int i=1;i<=amount;i++){
            int min = Integer.MAX_VALUE;
            for(int c: coins){
                if(c==i){
                    dp[i] = 1;
                    break;
                } else {
                    if(i-c>0 && dp[i-c]!=-1 && dp[i-c]<min){
                        min = dp[i-c];
                        dp[i] = min+1;
                    }
                }
            }
            
        }
        return dp[amount];
    }
}