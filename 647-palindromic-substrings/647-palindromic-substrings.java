class Solution {
    public int countSubstrings(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        for(int i=len-1;i>=0;i--){
            for(int j=i;j<len;j++){
                if(i==j || ((i+1)==j && s.charAt(i)==s.charAt(j)) || (dp[i+1][j-1]==1 && s.charAt(i)==s.charAt(j))){
                    dp[i][j] = 1;
                }
            }
        }
        
        int sum = 0;
        for(int i=0;i<len;i++){
            for(int j=i;j<len;j++){
                sum+=dp[i][j];
            }
        }
        return sum;
    }
}