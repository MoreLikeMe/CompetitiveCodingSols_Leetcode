class Solution {
    public boolean hasAllCodes(String s, int k) {
        Set<String> setString = new HashSet<String>();
        for(int i=k;i<=s.length();i++){
            setString.add(s.substring(i-k,i));
        }
        StringBuilder str = new StringBuilder("");
        for(int i=0;i<k;i++){
            str.append("0");
        }
        return recurCall(s, str, 0, setString);
    }
    
    public boolean recurCall(String s, StringBuilder curr, int index, Set<String> setString){
        
        //System.out.println(curr);
        
        if(!setString.contains(curr.toString())){
            return false;
        }
        
        if(index==curr.length()){
            return true;
        }
        
        boolean result = false;
        
        curr.setCharAt(index, '1');
        result = recurCall(s, curr, index+1, setString);
        curr.setCharAt(index, '0');
        result = result & recurCall(s, curr, index+1, setString);
        
        return result;
    }
}