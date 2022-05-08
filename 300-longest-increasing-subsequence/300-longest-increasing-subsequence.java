class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length+1];
        dp[1] = 1;
        for(int i=2;i<=nums.length;i++){
            dp[i] = 1;
            for(int j=0;j<i-1;j++){
                int temp = 0;
                if(nums[j]<nums[i-1]){
                    temp = dp[j+1]+1;
                }
                dp[i] = Math.max(dp[i], temp);
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i=0;i<=nums.length;i++){
            max = Math.max(dp[i], max);
        }
        return max;
    }
}