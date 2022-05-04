class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Map<String, Integer>, List<String>> master = new HashMap<Map<String, Integer>, List<String>>();
        Map<String, Integer> temp = null;
        List<String> tempString = null;
        for(String s: strs){
            temp = new HashMap<String, Integer>();
            for(int i=0;i<s.length();i++){
                temp.put((s.charAt(i)+""), temp.getOrDefault((s.charAt(i)+""), 0)+1);
            }
            if(master.containsKey(temp)){
                master.get(temp).add(s);
            } else{
                tempString = new ArrayList<String>();
                tempString.add(s);
                master.put(temp, tempString);
            }
        }
        
        List<List<String>> result = new ArrayList<List<String>>();
        for(Map.Entry<Map<String, Integer>, List<String>> m: master.entrySet()){
            result.add(m.getValue());
        }
        return result;
    }
}