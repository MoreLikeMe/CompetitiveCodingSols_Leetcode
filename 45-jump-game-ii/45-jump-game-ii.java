/* First Solution

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


*/


class Solution {
    public int jump(int[] A) {
        int N = A.length;
        int[] dp = new int[N];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        
        int localMax = 1;
        for(int i=0;i<N;i++){
            if(localMax<=i){
                return 0;
            }
            while(localMax<N && (i+A[i])>=localMax && dp[localMax]==-1){
                dp[localMax] = dp[i]+1;
                localMax++;
            }
        }
        return dp[N-1];
    }
}