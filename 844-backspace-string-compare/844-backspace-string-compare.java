class Solution {
    public boolean backspaceCompare(String s, String t) {
        int i = s.length()-1, j = t.length()-1;
        boolean isSameText = true;
        while(i>=0 || j>=0){
            int count = 0;
            boolean flag = false;
            if(i>=0 && s.charAt(i)=='#'){
                while(i>=0 && s.charAt(i)=='#'){
                    i--;
                    count++;
                }
                while(i>=0 && count>0){
                    if(s.charAt(i)!='#'){
                        count--;
                    } else {
                        count++;
                    }
                    i--;
                }
                flag = true;
            }
            if(flag){
                continue;
            }
            count = 0;
            flag = false;
            if(j>=0 && t.charAt(j)=='#'){
                while(j>=0 && t.charAt(j)=='#'){
                    j--;
                    count++;
                }
                while(j>=0 && count>0){
                    if(t.charAt(j)!='#'){
                        count--;
                    } else {
                        count++;
                    }
                    j--;
                }
                flag = true;
            }
            if(flag){
                continue;
            }
            
            if(!(i<0 && j<0) && ((i<0) || (j<0) || (s.charAt(i)!=t.charAt(j)))){
                isSameText = false;
                break;
            }
            if(i>=0)
                i--;
            if(j>=0)
                j--;
        }
        return isSameText;
    }
}