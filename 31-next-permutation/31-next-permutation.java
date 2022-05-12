class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length-1;
        while(i>0 && nums[i]<=nums[i-1]){
            i--;
        }
        if(i==0){
            Arrays.sort(nums);
        } else {
            Arrays.sort(nums, i, nums.length);
            for(int j=i;j<nums.length;j++){
                if(nums[i-1]<nums[j]){
                    int temp = nums[j];
                    nums[j] = nums[i-1];
                    nums[i-1] = temp;
                    break;
                }
            }
        }
    }
}