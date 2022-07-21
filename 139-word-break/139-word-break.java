class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<String>();
        for(int i=0;i<wordDict.size();i++){
            set.add(wordDict.get(i));
        }
        int[] cache = new int[s.length()];
        Arrays.fill(cache, -1);
        return isStringValid(s, set, 0, cache)==1?true:false;
    }
    
    public int isStringValid(String s, Set<String> set, int index, int[] cache){
        
        if(index==s.length()){
            return 1;
        }
        
        if(cache[index]!=-1){
            return cache[index];
        }
        
        cache[index] = 0;
        StringBuilder intermediate = new StringBuilder("");
        for(int i=index;i<s.length();i++){
            intermediate.append(s.charAt(i));
            if(set.contains(intermediate.toString())){
                cache[index] = (cache[index] | isStringValid(s, set, i+1, cache));
            }
        }
        return cache[index];
    }
}