/*
Recursion + Memoization Approach
*/
class Solution {
    public int minimumNumbers(int num, int k) {
        if(k==0){
            k=10;
        }
        int[] dp = new int[num+1];
        Arrays.fill(dp,-1);
        int t = recurCall(num, k, 0, dp);
        if(t==Integer.MAX_VALUE){
            return -1;
        }
        return t;
    }
    
    public int recurCall(int sum, int k, int count, int[] dp){
        
        if(sum==0){
            //System.out.println("Sum:" + count);
            return count;
        }
        
        if(sum<0){
            return Integer.MAX_VALUE;
        }
        
        if(dp[sum]!=-1){
            return dp[sum];
        }
        
        int res = Integer.MAX_VALUE;
        for(int i=k;i<=sum;i=i+10){
            res = Math.min(res,recurCall(sum-i, k, count+1, dp));
        }
        dp[sum] = res;
        return res;
    }
}