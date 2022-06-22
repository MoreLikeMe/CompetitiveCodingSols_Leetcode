class Solution {
    public int findKthLargest(int[] nums, int k) {
        //Arrays.sort(nums);
        //return nums[nums.length-k];
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b)-> a-b);
        for(int i=0;i<nums.length;i++){
            pq.add(nums[i]);
            if(pq.size()>k){
                pq.remove();
            }
        }
        
        return pq.remove();
    }
}