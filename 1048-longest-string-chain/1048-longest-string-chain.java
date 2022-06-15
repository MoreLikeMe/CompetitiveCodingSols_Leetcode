class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a,b)->a.length()-b.length());
        int[] dp = new int[words.length];
        int max = Integer.MIN_VALUE;
        for(int i=0;i<dp.length;i++){
            int j = i-1;
            int t = Integer.MIN_VALUE;
            while(j>=0 && words[i].length()-words[j].length()<2){
                if(words[i].length()-words[j].length()==1){
                    //check if one element diff is there or not
                    if(checkString(words[i], words[j])){
                        t = Math.max(t, dp[j]);
                    }
                }
                j--;
            }
            dp[i] = t==Integer.MIN_VALUE?1:(t+1);
            max = max<dp[i]?dp[i]:max;
        }
        return max;
    }
    
    public boolean checkString(String s1, String s2){
        int i=0,j=0;
        boolean flag = false;
        while(i<s1.length() && j<s2.length()){
            if(s1.charAt(i)!=s2.charAt(j)){
                if(flag){
                    return false;
                }
                flag = true;
                j--;
            }
            i++; j++;
        }
        return true;
    }
}