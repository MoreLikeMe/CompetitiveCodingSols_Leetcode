class Solution {
    public int wiggleMaxLength(int[] nums) {
        
        int[] up = new int[nums.length];
        int[] down = new int[nums.length];
        up[0] = 1;
        down[0] = 1;
        
        int max = Integer.MIN_VALUE;
        for(int i=1;i<nums.length;i++){
            up[i] = 1;
            down[i] = 1;
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    up[i] = Math.max(up[i], down[j]+1);
                    max = Math.max(max, up[i]);
                } else if(nums[i]<nums[j]){
                    down[i] = Math.max(down[i], up[j]+1);
                    max = Math.max(max, down[i]);
                }
            }
        }

        return max==Integer.MIN_VALUE?1:max;
    }
}