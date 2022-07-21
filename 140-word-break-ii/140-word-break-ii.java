class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<String>();
        for(int i=0;i<wordDict.size();i++){
            set.add(wordDict.get(i));
        }
        int[] cache = new int[s.length()];
        Arrays.fill(cache, -1);
        List<String> result = new ArrayList<>();
        List<String> partial = new ArrayList<>();
        return isStringValid(s, set, 0, cache, result, partial);
    }
    
     public List<String> isStringValid(String s, Set<String> set, int index, int[] cache, List<String> result, List<String> partial){
        
        if(index==s.length()){
            String temp = "";
            for(String str: partial){
                temp += str + " ";
            }
            temp = temp.substring(0,temp.length()-1);
            result.add(temp);
            return result;
        }
        
        StringBuilder intermediate = new StringBuilder("");
        for(int i=index;i<s.length();i++){
            intermediate.append(s.charAt(i));
            if(set.contains(intermediate.toString())){
                partial.add(intermediate.toString());
                isStringValid(s, set, i+1, cache, result, partial);
                partial.remove(partial.size()-1);
            }
        }
        return result;
    }
}