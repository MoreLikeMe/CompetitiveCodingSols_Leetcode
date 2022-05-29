class Solution {
    
    static private List<List<Integer>> result = new ArrayList<List<Integer>>();
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<List<Integer>>();
        recurCall(candidates, new ArrayList<Integer>(), 0, 0, target);
        return result;
    }
    
    public void recurCall(int[] candidates, List<Integer> partial, int sum, int start, int target){
        
        if(sum==target){
            result.add(new ArrayList<Integer>(partial));
            return;
        }
        
        if(start>=candidates.length){
            return;
        }
        
        if(sum+candidates[start]<=target){
            partial.add(candidates[start]);
            recurCall(candidates, partial, sum+candidates[start], start, target);
            partial.remove(partial.size()-1);
        }
        
        recurCall(candidates, partial, sum, start+1, target);
        return;
    }
}