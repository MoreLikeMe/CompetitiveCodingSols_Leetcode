class Solution {
    public String minWindow(String s, String t) {
        
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        int start=0,sLen=s.length(),tLen=t.length(),min=Integer.MAX_VALUE;
        
        for(int i=0;i<tLen;i++){
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0)+1);
        }
        
        int minLen=0,maxLen=-1;
        for(int end=0;end<sLen;end++){
            char c = s.charAt(end);
            if(tMap.get(c)!=null){
                sMap.put(c, sMap.getOrDefault(c,0)+1);
                while(mapSatisfies(tMap, sMap)){
                    if(min>(end-start+1)){
                        min = end-start+1;
                        minLen = start;
                        maxLen = end;
                    }
                    if(tMap.get(s.charAt(start))!=null){
                        sMap.put(s.charAt(start), sMap.get(s.charAt(start))-1);
                    }
                    start++;
                }
            }
        }
        
        return s.substring(minLen,maxLen+1);
        
    }
    
    public boolean mapSatisfies(Map<Character, Integer> tMap,Map<Character, Integer> sMap){
        for(Map.Entry<Character, Integer> m: tMap.entrySet()){
            if(!sMap.containsKey(m.getKey()) || (sMap.containsKey(m.getKey()) && sMap.get(m.getKey())<m.getValue())){
                return false;
            }
        }
        return true;
    }
}