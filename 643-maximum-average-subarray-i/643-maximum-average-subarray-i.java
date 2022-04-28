class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double avj = 0.0;
        double sum = 0.0;
        for(int i=0;i<nums.length && i<k;i++){
            sum+=nums[i];
        }
        avj = k<nums.length?(sum/k):(sum/nums.length);
        for(int i=k;i<nums.length;i++){
            sum+=nums[i];
            sum-=nums[i-k];
            if(avj<(sum/k)){
                avj = sum/k;
            }
        }
        return avj;
    }
}