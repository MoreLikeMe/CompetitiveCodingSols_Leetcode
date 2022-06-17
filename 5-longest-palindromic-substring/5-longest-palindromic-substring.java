class Solution {
    public String longestPalindrome(String s) {
        int[][] dp = new int[s.length()][s.length()];
        int c=-1,r=-1;
        int max = Integer.MIN_VALUE;
        for(int i=s.length()-1;i>=0;i--){
            for(int j=i;j<s.length();j++){
                if(j==i){
                    dp[i][j] = 1;
                }
                else if(j==i+1 && s.charAt(i)==s.charAt(j)){
                    dp[i][j] = 2;
                }
                else if(dp[i+1][j-1]!=0 && s.charAt(i)==s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1] + 2;
                }
                
                if(max<dp[i][j]){
                    max = dp[i][j];
                    r = i;
                    c = j;
                }
                
            }
        }
        return s.substring(r,c+1);
    }
}