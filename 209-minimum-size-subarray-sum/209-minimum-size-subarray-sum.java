class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        
        int i=0,j=0,minLen=999999999,arrLen=nums.length,sum=nums[0];
        
        //loop till the starting of subarray reaches the end of the array
        while(i<arrLen && j<arrLen){
            //when sum of subarray is equal or greater than the target
            //check for maxLen and reduce the subarray from starting
            //System.out.println(minLen+" " + sum);
            if(sum>=target){
                if(minLen>(j-i+1)){
                    minLen = j-i+1;
                }
                sum-=nums[i++];
            } 
            //if sum doesnot reach the target then increase the sum by
            //increasing the end of subarray considering that the end is
            //not already at the tail of the actual array
            else if(sum<target && j<(arrLen-1)){
                sum+=nums[++j];
            } 
            //if end of subarray reaches the end of array and sum is less than
            //target then no point of looping as only operation left i.e. 
            //increasing the start point will make the sum less further.
            else if(sum<target && j>=(arrLen-1)){
                //System.out.println(i+" "+j);
                break;
            }
        }
        return minLen==999999999?0:minLen;
    }
}