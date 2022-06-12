class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        
        int[] prefixSum = new int[nums.length];
        Map<Integer, Integer> map = new HashMap<>();
        int start = 0;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(i==0){
                prefixSum[i] = nums[i];
            } else {
                prefixSum[i] = prefixSum[i-1]+nums[i];
            }
            
            while(map.containsKey(nums[i])){
                map.remove(nums[start]);
                start++;
            }
            map.put(nums[i], i);
            if(start==0){
                max = prefixSum[i];
            }
            else if(max<(prefixSum[i]-prefixSum[start-1])){
                max = prefixSum[i]-prefixSum[start-1];
            }
        }
        return max;
    }
}