class Solution {
    public int countSubstrings(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        //using dynamic programming calculate the palindromes  in the string
        //dp[i][j] is 1 if substring(i,j) is a palindrome
        //in the next loop in line 17 we calculate the total no. of 1s that is the
        //number of palindromes
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