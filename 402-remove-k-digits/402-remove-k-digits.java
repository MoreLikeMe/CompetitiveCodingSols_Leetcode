//Monotonic Stack
class Solution {
    public String removeKdigits(String num, int k) {

        Stack<Character> s = new Stack<>();
        int i=0,len=num.length(),popCount=0;
        while(i<len){
            while(!s.isEmpty() && s.peek()>num.charAt(i) && popCount<k){
                s.pop();
                popCount++;
            }
            s.push(num.charAt(i));
            i++;
        } 
        
        StringBuilder r = new StringBuilder("");
        while(!s.isEmpty() ){
            r.append(s.pop());
        }
        
        r.reverse();
        
        if(popCount<k){
            r = new StringBuilder(r.substring(0,len-k));
        }
        
        while(r.length()!=0 && r.charAt(0)=='0'){
            r = new StringBuilder(r.substring(1, r.length()));
        }
        
        if(r.length()==0){
            return "0";
        }
        
        return r.toString();
    }
}