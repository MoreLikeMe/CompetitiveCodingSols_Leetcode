class Solution {
    public int findUnsortedSubarray(int[] nums) {
        
        int len = nums.length;
        int[] numCopy = Arrays.copyOf(nums, len);
        
        Arrays.sort(numCopy);
        int first = -1, last = -1;
        
        for(int i=0;i<len;i++){
            if(nums[i]!=numCopy[i] && first==-1){
                first = i;
            }
            if(nums[i]!=numCopy[i]){
                last = i;
            }
        }
        return first!=-1?(last-first+1):0;
    }
}