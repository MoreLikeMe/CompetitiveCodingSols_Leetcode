class Solution {
    public int longestOnes(int[] nums, int k) {
        
        int zeroCount = 0, maxLen=Integer.MIN_VALUE;
        for(int i=0,j=0;j<nums.length;j++){
            if(nums[j]==0){
                zeroCount++;
            }
            while(zeroCount>k){
                if(nums[i]==0){
                    zeroCount--;
                }
                i++;
            }
            maxLen = Math.max(maxLen, (j-i+1));
        }
        return maxLen;
    }
}