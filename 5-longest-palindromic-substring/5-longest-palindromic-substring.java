class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        for(int i=len-1;i>=0;i--){
            for(int j=i;j<len;j++){
                if(i==j || ((i+1)==j && s.charAt(i)==s.charAt(j)) || (dp[i+1][j-1]==1 && s.charAt(i)==s.charAt(j))){
                    dp[i][j] = 1;
                }
            }
        }
        
        int max = Integer.MIN_VALUE;
        int p=-1,q=-1;
        for(int i=0;i<len;i++){
            for(int j=i;j<len;j++){
                if(dp[i][j]==1 && max<(j-i)){
                    max = j-i;
                    p=i;
                    q=j;
                }
            }
        }
        return s.substring(p,q+1);
    }
}