class Solution {
    public long appealSum(String s) {
        int len = s.length();
        Map<String, Integer> map = new HashMap<String, Integer>();
        
        long tempSum = 0, totalSum = 0;
        for(int i=0;i<len;i++){
            map.put((s.charAt(i)+""),map.getOrDefault((s.charAt(i)+""),0)+1);
            tempSum += map.size();
        }
        totalSum=tempSum;
        for(int i=1;i<len;i++){
            if(map.containsKey(s.charAt(i-1)+"") && map.get(s.charAt(i-1)+"")>1){
                //get the next index of ith character
                tempSum = tempSum - (s.indexOf(s.charAt(i-1),i)-i+1);
                totalSum += tempSum;
                map.put(s.charAt(i-1)+"", map.get(s.charAt(i-1)+"")-1);
            } 
            else if(map.containsKey(s.charAt(i-1)+"") && map.get(s.charAt(i-1)+"")==1){
                tempSum = tempSum - (len-i+1);
                totalSum += tempSum;
                map.remove(s.charAt(i-1)+"");
            }
        }
        
        return totalSum;
    }
}