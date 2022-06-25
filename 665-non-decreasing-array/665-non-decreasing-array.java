class Solution {
    public boolean checkPossibility(int[] nums) {
        
        int k = -1;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]>nums[i+1]){
                if(k!=-1){
                    return false;
                }
                k = i;
                if(k==0){
                    nums[k] = nums[k+1];
                } else if(k==nums.length-2){
                    nums[k+1] = nums[k];
                } else if(nums[k-1]<=nums[k+1]){
                    nums[k] = nums[k+1];
                } else if (nums[k-1]>nums[k+1]){
                    nums[k+1] = nums[k];
                }
            }
        }
        return true;
    }
}