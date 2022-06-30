class Solution {
    public int minDeletions(String s) {
        
        Map<String, Integer> map = new HashMap<String, Integer>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i)+"", map.getOrDefault((s.charAt(i)+""),0)+1);
        }
        List<Integer> l = new ArrayList<>(map.values());
        Collections.sort(l);
        System.out.println(l.toString());
        int count = 0;
        for(int i=l.size()-2;i>=0;i--){
            if(l.get(i)>=l.get(i+1)){
                if(l.get(i+1)!=0){
                    count += (l.get(i)-l.get(i+1))+1;
                    l.set(i, l.get(i+1)-1);
                } else {
                    count += l.get(i)-l.get(i+1);
                    l.set(i, 0);
                }
            }
        }
        return count;
    }
}