class Solution {
    public char findTheDifference(String s, String t) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }
        char res = '0';
        for(char c: t.toCharArray()){
            if(map.containsKey(c) && map.get(c)!=0){
                map.put(c, map.get(c)-1);
            } else {
                res = c;
                break;
            }
        }
        return res;
    }
}