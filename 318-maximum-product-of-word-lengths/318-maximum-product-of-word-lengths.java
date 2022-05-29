class Solution {
    public int maxProduct(String[] words) {
        int n = words.length;
        int max = Integer.MIN_VALUE;
        
        Set<Character> set = null;
        boolean flag = false;
        for(int i=0;i<n;i++){
            set = new HashSet<Character>(); 
            for(int k=0;k<words[i].length();k++){
                set.add(words[i].charAt(k));
            }
            for(int j=i+1;j<n;j++){
                flag = false;
                for(int k=0;k<words[j].length();k++){
                    if(set.contains(words[j].charAt(k))){
                        flag = true;
                        break;
                    }
                }
                if(!flag && max<words[i].length()*words[j].length()){
                    max = words[i].length()*words[j].length();
                }
            }
        }
        
        
        return max==Integer.MIN_VALUE?0:max;
    }
}