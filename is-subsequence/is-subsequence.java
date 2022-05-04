class Solution {
    public boolean isSubsequence(String s, String t) {
        int j=0, i=0, count=0;
        
        for(i=0;i<s.length();i++,j++){
            while(j<t.length() && t.charAt(j)!=s.charAt(i)){
                j++;
            }
            if(j<t.length() && t.charAt(j)==s.charAt(i)){
                count++;
            }
        }
        if(count==s.length()){
            return true;
        }
        return false;
    }
}