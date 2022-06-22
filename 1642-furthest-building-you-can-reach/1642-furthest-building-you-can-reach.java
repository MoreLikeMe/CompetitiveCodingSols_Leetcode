class Solution {
    public int furthestBuilding(int[] nums, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b)-> (b-a));
        int sum = 0, i = 0;
        for(i=1;i<nums.length;i++){
            if(nums[i]>nums[i-1]){
                sum = sum + (nums[i]-nums[i-1]);
                pq.add(nums[i]-nums[i-1]);
                if(sum>bricks){
                    if(ladders>0){
                        sum = sum - pq.remove();
                        ladders = ladders - 1;
                    } else {
                        break;
                    }
                }
            }
        }
        return i-1;
    }
}