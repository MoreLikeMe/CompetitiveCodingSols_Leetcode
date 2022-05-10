class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==1 || strs[0].equals("")){
            return strs[0];
        }
        int itr = -1;
        boolean flag = true;
        while(flag){
            itr++;
            for(int i=0;i<strs.length-1;i++){
                // for testcases "a","ab" || "ab","a"
                if(itr>=strs[i].length() || itr>=strs[i+1].length() || strs[i].charAt(itr)!=strs[i+1].charAt(itr)){
                    flag = false;
                    break;
                }
            }
        }
        return strs[0].substring(0,itr);
    }
}