class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Character, List<String>> map = new HashMap<Character, List<String>>();
        map.put('2', Arrays.asList("a","b","c"));
        map.put('3', Arrays.asList("d","e","f"));
        map.put('4', Arrays.asList("g","h","i"));
        map.put('5', Arrays.asList("j","k","l"));
        map.put('6', Arrays.asList("m","n","o"));
        map.put('7', Arrays.asList("p","q","r","s"));
        map.put('8', Arrays.asList("t","u","v"));
        map.put('9', Arrays.asList("w","x","y","z"));
        
        return letterComboRecur(digits, 0, "", map, new ArrayList<String>());
        
    }
    
    public List<String> letterComboRecur(String digits, int index, String partial, Map<Character, List<String>> map, List<String> result){

        if(partial.length()==digits.length()){
            result.add(partial);
            return digits.length()!=0?result:(new ArrayList<String>());
        }
        
        for(String a: map.get(digits.charAt(index))){
            letterComboRecur(digits, index+1, (partial+a), map, result);
        }
        return result;
    }
}