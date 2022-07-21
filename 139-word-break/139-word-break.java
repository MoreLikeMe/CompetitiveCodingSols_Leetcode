class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<String>();
        for(int i=0;i<wordDict.size();i++){
            set.add(wordDict.get(i));
        }
        int[] cache = new int[s.length()];
        Arrays.fill(cache, -1);
        return isStringValid(s, set, 0, cache);
    }
    
    public boolean isStringValid(String s, Set<String> set, int index, int[] cache){
        
        if(index==s.length()){
            return true;
        }
        
        if(cache[index]!=-1){
            return cache[index]==1?true:false;
        }
        
        boolean result = false;
        String intermediate = "";
        for(int i=index;i<s.length();i++){
            intermediate += s.charAt(i);
            if(set.contains(intermediate)){
                result = (result || isStringValid(s, set, i+1, cache));
            }
        }
        cache[index] = (result==true?1:0);
        return result;
    }
}