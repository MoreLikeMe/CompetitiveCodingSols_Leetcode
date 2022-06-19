class Solution {
    public int minimumNumbers(int num, int k) {
        
        if(num==0){
            return 0;
        }
        int[] dp = new int[num+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i=1;i<=num;i++){
            if(i%10==k){
                dp[i] = 1;
                continue;
            }
            for(int j=k;j<=i;j=j+10){
                if(dp[i-j]!=Integer.MAX_VALUE){
                     dp[i] = Math.min(dp[i],dp[i-j]+1);
                }
            }
        }
        return dp[num]!=Integer.MAX_VALUE?dp[num]:-1;
    }
}