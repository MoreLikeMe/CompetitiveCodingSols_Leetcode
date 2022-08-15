class Solution {
    public List<List<String>> partition(String s) {
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
    
    
    private boolean isPalindrome(String s){
        
        int i=0;
        int j=s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++; j--;
        }
        return true;
    }
}