class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int k = 0;
        for(int i=0;i<nums.length;i++){
            k = k | nums[i];
        }
        List<List<Integer>> res = new ArrayList<List<Integer>>(); 
        if(k==0 && nums.length>=3){
            res.add(Arrays.asList(0,0,0));
            return res;
        }
        
        Set<Integer> cache = null;
        Set<String> mDuplicate = new HashSet<String>();
        for(int i=0;i<nums.length;i++){
            cache = new HashSet<Integer>();
            for(int j=i+1;j<nums.length;j++){
                if(cache.contains(-(nums[j]+nums[i]))){
                    List<Integer> temp = Arrays.asList(nums[i], nums[j], -(nums[j]+nums[i]));
                    Collections.sort(temp);
                    if(!mDuplicate.contains(temp.toString())){
                        mDuplicate.add(temp.toString());
                        res.add(temp);
                    }
                }
                cache.add(nums[j]);
            }
        }
        return res;
    }
}