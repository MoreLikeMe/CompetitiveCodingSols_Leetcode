class Solution {
    public String decodeMessage(String key, String message) {
        Set<Character> charSet = new HashSet<Character>();
        char[] mapping = new char[26];
        int ind = 0;
        for(int i=0;i<key.length();i++){
            if(key.charAt(i)!=' ' && !charSet.contains(key.charAt(i))){
                charSet.add(key.charAt(i));
                mapping[key.charAt(i)-97] = (char)(ind+97);
                ind++;
            }
            if(charSet.size()==26){
                break;
            }
        }
        
        StringBuilder res = new StringBuilder("");
        for(int i=0;i<message.length();i++){
            if(message.charAt(i)==32){
                res.append(" ");
            } else {
                res.append(mapping[message.charAt(i)-97]);
            }
        }
        return res.toString();
    }
}