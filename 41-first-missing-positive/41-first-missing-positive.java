/*

The idea is to find the smallest positive which is not present.
So if the length of array is n
then there could be maximum n positive numbers
So the fitst positive integer that could be missing lies between 1 to n

*/

class Solution {
    public int firstMissingPositive(int[] nums) {
        
        Set<Integer> set = new HashSet<Integer>();
        int now=1;
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
            if(set.contains(now)){
                now++;
            }
        }
        while(set.contains(now)){
            now++;
        }
        return now;
    }
}