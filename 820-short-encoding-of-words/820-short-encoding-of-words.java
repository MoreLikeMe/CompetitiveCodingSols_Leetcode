class Solution {
    public int minimumLengthEncoding(String[] words) {
        
        Arrays.sort(words, new Comparator<String>(){
            public int compare(String a, String b){
                return new StringBuilder(a).reverse().compareTo(new StringBuilder(b).reverse());
            }
        });
        
        int res = 0;
        for(int i=1;i<words.length;i++){
            if(!words[i].endsWith(words[i-1])){
                res = res + words[i-1].length() + 1;
            }
        }
        res = res + words[words.length-1].length() + 1;
        return res;
    }
}