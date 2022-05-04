
class Solution {
    public int maxOperations(int[] nums, int k) {
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(k-nums[i]) && map.get(k-nums[i])>0){
                map.put((k-nums[i]), map.get(k-nums[i])-1);
                count++;
            } else {
                map.put(nums[i], map.getOrDefault(nums[i],0)+1);
            }
        }
        return count;
    }
}