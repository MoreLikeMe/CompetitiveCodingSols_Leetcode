//Try to get the maximum length of the subarray with sum (totalSum - x)
//the rest of it will be the array parts which will be deleted...
class Solution {
    public int minOperations(int[] nums, int x) {
        
        long totalSum = 0L;
        for(int i=0;i<nums.length;i++){
            totalSum = totalSum + nums[i];
        }
        
        long requiredSum = totalSum - x;
        
        int start = 0;
        long sum = 0L;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            sum = sum + nums[i];
            while(sum>requiredSum && start<=i){
                sum = sum - nums[start];
                start++;
            }
            if(sum==requiredSum && max<(i-start+1)){
                max=i-start+1;
            }
        }
        return (max == Integer.MIN_VALUE)?-1:(nums.length-max);
    }
}