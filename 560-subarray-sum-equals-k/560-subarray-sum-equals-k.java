class Solution {
    public int subarraySum(int[] nums, int k) {
        
        Map<Integer, Integer> sumMap = new HashMap<>();
        int currSum = 0, count = 0;
        for(int i=0;i<nums.length;i++){
            currSum += nums[i];
            
            //if prefixSum is equal to the target
            //then it is a subarray that is equal to k
            if(currSum==k){
                count++;
            }
            
            //check in the map that (currSum-k) is present or not
            //if present, we can say there is a subarray that is equal to k
            if(sumMap.containsKey(currSum-k)){
                count = count + sumMap.get(currSum-k);
            }
            
            //put the prefix sum in the map
            sumMap.put(currSum, sumMap.getOrDefault(currSum,0)+1);
        }
        
        return count;
    }
}