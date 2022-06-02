class Solution {
    public boolean hasAllCodes(String s, int k) {
        Set<String> setString = new HashSet<String>();
        for(int i=k;i<=s.length();i++){
            setString.add(s.substring(i-k,i));
        }
        
        if(setString.size()==Math.pow(2,k)){
            return true;
        }
        return false;
    }
}