class Solution {
    /*
    Our Approach is like: iterating through the array one by one elements
    and having another pointer that will increase only for distinct elements.
    
    like the another pointer will overlap the duplicate ones with distinct ones
    
    */
    public int removeDuplicates(int[] nums) {
        
        int ind = 0;
        //iterate through each elements
        for(int i=0;i<nums.length;i++){
            //add the distinct element to array
            nums[ind++] = nums[i];
            
            //skip the dulicate ones
            while((i+1)<nums.length && nums[i]==nums[i+1]){
                i++;
            }
        }
        //return the index to which the distinct elements are stored
        return ind;
    }
}