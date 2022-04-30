class Solution {
    public boolean checkInclusion(String s1, String s2) {
    	
    	if(s1.length()>s2.length()){
    		return false;
    	}
    	
        Map<Character, Integer> staticMap = new HashMap<>();
        Map<Character, Integer> dynamicMap = new HashMap<>();
        for(int i=0;i<s1.length();i++){
        	
        	if(staticMap.containsKey(s1.charAt(i))){
        		staticMap.put(s1.charAt(i), staticMap.get(s1.charAt(i))+1);
        	} else {
        		staticMap.put(s1.charAt(i), 1);
        	}
        	
        	if(dynamicMap.containsKey(s2.charAt(i))){
        		dynamicMap.put(s2.charAt(i), dynamicMap.get(s2.charAt(i))+1);
        	} else {
        		dynamicMap.put(s2.charAt(i), 1);
        	}
        }
        
        int start=0, end = s1.length()-1;
        
        while(end<s2.length()){
        	//check the Maps
        	if(staticMap.equals(dynamicMap)){
        		return true;
        	}
        	
        	if((end+1)<s2.length() && !(s2.charAt(start)==s2.charAt(end+1))){
            	if(dynamicMap.containsKey(s2.charAt(end+1))){
            		dynamicMap.put(s2.charAt(end+1), dynamicMap.get(s2.charAt(end+1))+1);
            	} else {
            		dynamicMap.put(s2.charAt(end+1), 1);
            	}
            	
            	if(dynamicMap.get(s2.charAt(start))==1){
            		dynamicMap.remove((Character)s2.charAt(start));
            	} else {
            		dynamicMap.put(s2.charAt(start), dynamicMap.get(s2.charAt(start))-1);
            	}
        	}
        	start++; end++;
        }
		//return false;
		return false;
        	
     }
}