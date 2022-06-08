class Solution {
    public int removePalindromeSub(String s) {
        
        int i=0,j=s.length()-1;
        boolean isPalin = true;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                isPalin = false;
                break;
            }
            i++; j--;
        }
        
        if(isPalin){
            return 1;
        } else {
            return 2;
        }
    }
}