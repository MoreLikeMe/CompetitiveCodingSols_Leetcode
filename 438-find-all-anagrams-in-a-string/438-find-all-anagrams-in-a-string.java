class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> sourceMap = new HashMap<Character, Integer>();
        Map<Character, Integer> targetMap = new HashMap<Character, Integer>();
        List<Integer> result = new ArrayList<Integer>();
        int count = 0, sourceLen=p.length();
        if(sourceLen>s.length()){
            return result;
        }
        for(int i=0;i<sourceLen;i++){
            sourceMap.put(p.charAt(i), sourceMap.getOrDefault(new Character(p.charAt(i)),0)+1);
            targetMap.put(s.charAt(i), targetMap.getOrDefault(new Character(s.charAt(i)),0)+1);
        }
        if(sourceMap.equals(targetMap)){
            result.add(0);
        }
        
        for(int i=sourceLen;i<s.length();i++){
            targetMap.put(s.charAt(i), targetMap.getOrDefault(new Character(s.charAt(i)),0)+1);
            if(targetMap.get(new Character(s.charAt(i-sourceLen)))==1){
                targetMap.remove(new Character(s.charAt(i-sourceLen)));
            } else{
                targetMap.put(s.charAt(i-sourceLen), targetMap.get(new Character(s.charAt(i-sourceLen)))-1);
            }
            if(sourceMap.equals(targetMap)){
                result.add(i-sourceLen+1);
            }
        }
        return result;
    }
}