class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        
        int min = Integer.MAX_VALUE;
        for(int i=1;i<triangle.size();i++){
            for(int j=0;j<triangle.get(i).size();j++){
                min = Integer.MAX_VALUE;
                if(j!=0){
                    min = Math.min(min, triangle.get(i-1).get(j-1));
                }
                if(j!=triangle.get(i).size()-1){
                    min = Math.min(min, triangle.get(i-1).get(j));
                }
                triangle.get(i).set(j, min+triangle.get(i).get(j));
            }
        }
        
        min = Integer.MAX_VALUE; 
        for(int l: triangle.get(triangle.size()-1)){
            min = Math.min(min, l);
        }
        return min;
    }
}