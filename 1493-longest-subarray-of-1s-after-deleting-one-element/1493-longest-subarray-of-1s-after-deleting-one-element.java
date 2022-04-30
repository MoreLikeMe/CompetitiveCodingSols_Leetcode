class Solution {
    public int longestSubarray(int[] nums) {
        
        int zeroPos = -1, maxLen=Integer.MIN_VALUE;
        for(int start=-1,end=0;end<nums.length;end++){
            if(nums[end]==0){
                start = zeroPos;
                zeroPos = end;
            }
            maxLen = Math.max(maxLen, (end-start));
        }
        return maxLen-1;
    }
}