class Solution {
    public int subarraySum(int[] nums, int k) {
        
        Map<Integer, Integer> sumMap = new HashMap<>();
        int currSum = 0, count = 0;
        for(int i=0;i<nums.length;i++){
            currSum += nums[i];
            
            if(currSum==k){
                count++;
            }
            if(sumMap.containsKey(currSum-k)){
                count = count + sumMap.get(currSum-k);
            }
            
            sumMap.put(currSum, sumMap.getOrDefault(currSum,0)+1);
        }
        
        return count;
    }
}