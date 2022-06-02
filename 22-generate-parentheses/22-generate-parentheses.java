class Solution {
    public List<String> generateParenthesis(int n) {
        return recurCall(n*2, "(", new ArrayList<String>());
    }
    
    public List<String> recurCall(int n, String partial, List<String> result){
        
        if(partial.length()==n && partial.charAt(n-1)==')' && isValid(partial)){
            result.add(partial);
            return result;
        }
        
        if(partial.length()==n){
            return result;
        }
        
        recurCall(n, partial+"(", result);
        recurCall(n, partial+")", result);
        return result;
    }
    
    public boolean isValid(String s){
        int count = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                count++;
            } else {
                count--;
            }
            
            if(count<0){
                return false;
            }
        }
        
        if(count==0){
            return true;
        }else {
            return false;
        }
    }
}