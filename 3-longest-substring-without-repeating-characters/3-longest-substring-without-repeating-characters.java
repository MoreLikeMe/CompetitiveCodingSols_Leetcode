class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> charMap = new HashMap<>();
        int slider = 0, maxSize = 0;
        for(int i=0;i<s.length();i++){
        	if(charMap.containsKey(s.charAt(i))){
        		int temp = charMap.get(s.charAt(i));
        		for(int k=slider;k<temp;k++){
        			charMap.remove(s.charAt(k));
        		}
        		slider = temp+1;
        	}
        	charMap.put(s.charAt(i), i);
        	if(maxSize<(i-slider)){
        		maxSize = i-slider;
        	}
        }
        return (s.length()==0?0:(maxSize+1));
    }
}