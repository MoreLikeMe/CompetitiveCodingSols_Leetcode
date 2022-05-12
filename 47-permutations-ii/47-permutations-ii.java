class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        return recurcall(nums, new boolean[nums.length], new ArrayList<Integer>(), new ArrayList<List<Integer>>());
    }
    
    public List<List<Integer>> recurcall(int[] nums, boolean[] visited, List<Integer> partial, List<List<Integer>> result){
        if(partial.size()==nums.length){
            result.add(new ArrayList<>(partial));
            return result;
        }
        
        for(int i=0;i<nums.length;i++){
            if(visited[i]==false){
                partial.add(nums[i]);
                visited[i] = true;
                recurcall(nums, visited, partial, result);
                partial.remove(partial.size()-1);
                visited[i] = false;
                while(i<nums.length-1 && nums[i]==nums[i+1]){
                    i++;
                }
            }
        }
        return result;
    }
}