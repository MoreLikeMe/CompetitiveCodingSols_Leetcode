class Solution {
    public List<List<String>> partition(String s) {
        map = new HashMap<>();
        return partitionRecursiveCall(s, 0, new ArrayList<String>(), new ArrayList<List<String>>());
    }
    
    private List<List<String>> partitionRecursiveCall(String s, int start, List<String> partial, List<List<String>> result){
        
        if(s.length()==start){
            result.add(new ArrayList<>(partial));
            return result;
        }
        
        for(int i=start+1;i<=s.length();i++){
            String temp = s.substring(start,i);
            if(isPalindrome(temp)){
                partial.add(temp);
                partitionRecursiveCall(s, i, partial, result);
                partial.remove(partial.size()-1);
            }
        }
        
        return result;
    }
    
    private static Map<String, Boolean> map;
    
    private boolean isPalindrome(String s){
        
        if(map.containsKey(s)){
            return map.get(s);
        }
        
        int i=0;
        int j=s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                map.put(s, false);
                return false;
            }
            i++; j--;
        }
        map.put(s, true);
        return true;
    }
}