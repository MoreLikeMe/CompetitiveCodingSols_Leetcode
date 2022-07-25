class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = findFirst(nums,target);
        res[1] = findLast(nums,target);
        return res;
    }
    
    public int findFirst(int[] nums, int target){
        int start = 0, end = nums.length-1;
        int mid = -1, result = -1;
        while(start<=end){
            mid = start+(end-start)/2;
            if(nums[mid]==target){
                result = mid;
                end = mid-1;
            }
            else if(nums[mid]>target){
                end = mid-1;
            }
            else {
                start = mid+1;
            }
        }
        return result;
    }
    
    public int findLast(int[] nums, int target){
        int start = 0, end = nums.length-1;
        int mid = -1, result = -1;
        while(start<=end){
            mid = start+(end-start)/2;
            if(nums[mid]==target){
                result = mid;
                start = mid+1;
            }
            else if(nums[mid]>target){
                end = mid-1;
            }
            else {
                start = mid+1;
            }
        }
        return result;
    }
}