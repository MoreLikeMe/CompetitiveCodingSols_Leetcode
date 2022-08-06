class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int i=0;
        while(i<nums.length){
            while(nums[i]!=(i+1) && nums[nums[i]-1]!=nums[i]){
                int temp = nums[i];
                nums[i] = nums[temp-1];
                nums[temp-1] = temp;
            }
            i++;
        }
        
        List<Integer> result = new ArrayList<>();
        for(i=0;i<nums.length;i++){
            if(nums[i]!=i+1){
                result.add(i+1);
            }
        }
        return result;
    }
}