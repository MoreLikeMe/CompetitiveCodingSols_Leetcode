class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        return recurCall(1, k, n, 0, new ArrayList<Integer>(), new ArrayList<List<Integer>>());
    }
    
    public List<List<Integer>> recurCall(int start, int k, int targetSum, int partialSum, List<Integer> partial, List<List<Integer>> result){
        
        if(partialSum==targetSum && partial.size()==k){
            result.add(new ArrayList<>(partial));
            return result;
        }
        
        for(int i=start;i<10;i++){
            if(partialSum+i<=targetSum){
                partial.add(i);
                recurCall(i+1, k, targetSum, (partialSum+i), partial, result);
                partial.remove(partial.size()-1);
            }
        }
        return result;
    }
}