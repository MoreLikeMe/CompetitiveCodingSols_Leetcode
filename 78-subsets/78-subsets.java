class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result.add(new ArrayList<Integer>());
        
        Set<Integer> processed = new HashSet<Integer>();
        
        for(int i=0;i<nums.length;i++){
            if(!processed.contains(nums[i])){
                processed.add(nums[i]);
                List<List<Integer>> temp = new ArrayList<List<Integer>>();
                for(List<Integer> ls: result){
                    List<Integer> t = new ArrayList<Integer>(ls);
                    t.add(nums[i]);
                    temp.add(t);
                }
                result.addAll(temp);
            }
        }
        return result;
    }
}