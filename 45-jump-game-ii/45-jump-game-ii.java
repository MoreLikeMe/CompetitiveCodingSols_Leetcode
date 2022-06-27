class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i=0;i<n;i++){
            int in = 1;
            while(in<=nums[i] && (i+in)<n){
                dp[i+in]=Math.min(dp[i+in],dp[i]+1);
                in++;
            }
        }
        return dp[n-1];
    }
}