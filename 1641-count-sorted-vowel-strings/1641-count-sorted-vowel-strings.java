class Solution {
    public int countVowelStrings(int n) {
        return recurCall(0, n, new ArrayList<String>(), Arrays.asList("a","e","i","o","u"));
    }
    
    public int recurCall(int start, int n, List<String> partial, List<String> vowelList){
        if(partial.size()==n){
            return 1;
        }
        
        int count = 0;
        for(int i=start;i<vowelList.size();i++){
            partial.add(vowelList.get(i));
            count = count + recurCall(i, n, partial, vowelList);
            partial.remove(partial.size()-1);
        }
        return count;
    }
}