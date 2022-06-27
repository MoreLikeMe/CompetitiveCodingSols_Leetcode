class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int len = cardPoints.length-k;
        int sum = 0, minSum = Integer.MAX_VALUE, totalSum = 0;
        for(int i=0;i<cardPoints.length;i++){
            totalSum+=cardPoints[i];
            if(i<len){
                sum = sum + cardPoints[i];
            } else {
                sum = sum + cardPoints[i];
                sum = sum - cardPoints[i-len];
            }
            
            if(i>=len-1){
                minSum = Math.min(minSum, sum);
            }
        }
        return totalSum-minSum;
    }
}