class Solution {
    public int totalFruit(int[] fruits) {
        
        //for keeping the current 2 types of trees
        Map<Integer, Integer> curMap = new HashMap<Integer, Integer>();
        int maxLen = Integer.MIN_VALUE;
        
        for(int i=0,j=0;j<fruits.length;j++){
            
            //when a new tree is coming on top of already 2 trees
            //remove the farthest type of tree
            //sink the array to the last occurence of the farthest tree
            if(curMap.size()==2 && !curMap.containsKey(fruits[j])){
                //remove the farthest tree from the set
                int farthest = -1;
                for(int a: curMap.keySet()){
                    if(a!=fruits[j-1]){
                        farthest = a;
                        break;
                    }
                }
                //set window starting position to the last 
                //occurence of the farthest tree + 1
                i=curMap.get(farthest)+1;
                curMap.remove(Integer.valueOf(farthest));
            }
            
            //add the every tree into the set
            curMap.put(fruits[j], j);
            
            //check the new window is the maximum or not
            if(maxLen<(j-i+1)){
                maxLen = (j-i+1);
            }
            
        }
        return maxLen;
    }
}