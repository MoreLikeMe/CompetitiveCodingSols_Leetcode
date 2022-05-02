class Solution {
    public boolean canJump(int[] nums) {
        
        int max = Integer.MIN_VALUE;
        boolean isReachable = false;
        for(int i=0;i<nums.length;i++){
            if((i+nums[i])>max){
                max = nums[i]+i;
                if(max>=(nums.length-1)){
                    isReachable = true;
                    break;
                }
            }
            if(i==max){
                isReachable = false;
                break;
            }
        }
        return isReachable;
    }
}