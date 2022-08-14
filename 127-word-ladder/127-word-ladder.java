class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
     
        Set<String> set = new HashSet<>();
        for(String s: wordList){
            set.add(s);
        }
        
        List<Character> charList = new ArrayList<>();
        for(int i=97;i<=122;i++){
            charList.add((char)i);
        }
        
        ArrayDeque<String> queue = new ArrayDeque<>();
        queue.offerLast(beginWord);
        set.remove(beginWord);
        
        int level = 1;
        
        while(!queue.isEmpty() && !set.isEmpty()){
            int size = queue.size();
            level++;
            while(size-- >0){
                String currString = queue.pollFirst();
                for(int i=0;i<currString.length();i++){
                    StringBuilder curr = new StringBuilder(currString);
                    for(char c: charList){
                        curr.setCharAt(i, c);
                        if(set.contains(curr.toString())){
                            if(curr.toString().equals(endWord)){
                                return level;
                            }
                            queue.offerLast(curr.toString());
                            set.remove(curr.toString());
                        }
                    }
                }
            }
        }
        
        return 0;
        
    }
}