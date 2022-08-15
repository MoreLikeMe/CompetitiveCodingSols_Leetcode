class Solution {
    
    private Map<String, List<String>> findPathMap(String beginWord, String endWord, List<String> wordList){
        Map<String, Boolean> map = new HashMap<>();
        Map<String, List<String>> pathMap = new HashMap<>();
        List<Character> charList = new ArrayList<>();
        
        //adding the lists to the set for O(1) search
        for(String s: wordList){
            map.put(s, false);
        }
        
        //prepare characterList with lowercase english letters
        for(int i=97;i<=122;i++){
            charList.add((char)i);
        }
        
        ArrayDeque<String> queue = new ArrayDeque<>();
        queue.offerLast(beginWord);
        
        boolean isFound = false;
        while(!queue.isEmpty()){
            int size = queue.size();
            Set<String> levelSet = new HashSet<>();
            while(size-- >0){
                String currString = queue.pollFirst();
                for(int i=0;i<currString.length();i++){
                    StringBuilder curr = new StringBuilder(currString);
                    for(char c: charList){
                        curr.setCharAt(i, c);
                        if(map.containsKey(curr.toString()) && !map.get(curr.toString())){
                            if(!levelSet.contains(curr.toString())){
                                queue.offerLast(curr.toString());
                                levelSet.add(curr.toString());
                            }
                            List<String> connection = pathMap.getOrDefault(curr.toString(), new ArrayList<String>());
                            connection.add(currString);
                            pathMap.put(curr.toString(), connection);
                            
                            if(curr.toString().equals(endWord)){
                                isFound = true;
                            }
                        }
                    }
                }
            }
            
            for(String s: levelSet){
                map.put(s, true);
            }
            if(isFound){
                return pathMap;
            }
        }
        
        return pathMap;
        
    }
    
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        
        //get the mapping of shortest paths
        Map<String, List<String>> pathMap = findPathMap(beginWord, endWord, wordList);
        
        List<List<String>> result = new ArrayList<List<String>>();
        pathListRecur(beginWord, endWord, result, pathMap, new ArrayList<>(Arrays.asList(endWord)));
        return result;
    }
    
    private List<List<String>> pathListRecur(String beginWord, String currentWord, List<List<String>> result, Map<String, List<String>> pathMap, List<String> partial){
        
        if(currentWord.equals(beginWord)){
            List<String> t = new ArrayList<>(partial);
            Collections.reverse(t);
            result.add(t);
            return result;
        }
        
        if(pathMap.get(currentWord)!=null){
            for(String s: pathMap.get(currentWord)){
                 partial.add(s);
                 pathListRecur(beginWord, s, result, pathMap, partial);
                 partial.remove(partial.size()-1);
            }
        }
        
        return result;
    }
}