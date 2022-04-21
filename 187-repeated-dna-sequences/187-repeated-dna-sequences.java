class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> result = new HashSet<String>();
        Set<String> set = new HashSet<String>();
        for(int i=0;(i+9)<s.length();i++){
            String temp = s.substring(i,i+10);
            if(set.contains(temp)){
                result.add(temp);
            } else {
                set.add(temp);
            }
        }
        return new ArrayList<String>(result);
    }
}