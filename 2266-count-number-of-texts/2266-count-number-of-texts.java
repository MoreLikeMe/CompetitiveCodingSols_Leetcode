/*
"2222222"

dp = [0,1,2,4,7,13,24,44]

*/

class Solution {
    public int countTexts(String pressedKeys) {
        int[] itrCount = new int[10];
        char[] keyArr = pressedKeys.toCharArray();
        Arrays.fill(itrCount, 3);
        itrCount[7] = 4;
        itrCount[9] = 4;
        
        int[] dp = new int[keyArr.length+1];
        dp[0] = 0;
        dp[1] = 1;
        
        for(int i=2;i<=keyArr.length;i++){
            //when a new number is used then the count will be same
            //as addition of new number wont make a new way
            if(keyArr[i-1]!=keyArr[i-2]){
                dp[i] = dp[i-1];
            } else {
                int itr = 0, tempSum = 0;
                //check get the sum of same digits last K occurences
                while(i-itr-2>=0 && itr<itrCount[keyArr[i-1]-48] && keyArr[i-1]==keyArr[i-itr-2]){
                    tempSum = (tempSum+dp[i-itr-1])%1000000007;
                    itr++;
                }
                //if the same digit is not present more than K times then we will double if
                //otherwise we use the sum
                if(itr==itrCount[keyArr[i-1]-48]){
                    dp[i] = tempSum;
                } else {
                    dp[i] = (dp[i-1]*2)%1000000007;
                }
            }
        }
        return dp[keyArr.length];
    }
}