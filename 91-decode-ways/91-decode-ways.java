class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        dp[1] = s.charAt(0)=='0'?0:1;
        
        for(int i=1;i<s.length();i++){
            char curChar = s.charAt(i);
            char prevChar = s.charAt(i-1);
            if(curChar=='0'){
                if(prevChar=='2' || prevChar=='1'){
                    dp[i+1] = dp[i-1];
                } else{
                    dp[i+1] = 0;
                }
            }
            else if(prevChar=='0' || (prevChar=='2' && curChar>'6') || prevChar>'2'){
                dp[i+1] = dp[i];
            } else {
                dp[i+1] = dp[i] + dp[i-1];
            }
        }
        return dp[s.length()];
    }
}