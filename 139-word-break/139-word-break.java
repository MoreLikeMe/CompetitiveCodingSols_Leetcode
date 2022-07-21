class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        
        Set<String> set = new HashSet<String>();
        for(int i=0;i<wordDict.size();i++){
            set.add(wordDict.get(i));
        }
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        
        for(int i=1;i<=s.length();i++){
            for(int j=0;j<i;j++){
                if(dp[j]==true && set.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}