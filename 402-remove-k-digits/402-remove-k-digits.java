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
        
        String r = "";
        while(!s.isEmpty() ){
            r = s.pop() + r;
        }
        
        if(popCount<k){
            r = r.substring(0,len-k);
        }
        
        while(r.length()!=0 && r.charAt(0)=='0'){
            r=r.substring(1, r.length());
        }
        
        if(r.length()==0){
            return "0";
        }
        
        return r;
    }
}