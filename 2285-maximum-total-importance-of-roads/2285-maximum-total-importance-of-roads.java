class Solution {
    public long maximumImportance(int n, int[][] roads) {
        
        Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
        for(int[] road: roads){
            freq.put(road[0], freq.getOrDefault(road[0], 0)+1);
            freq.put(road[1], freq.getOrDefault(road[1], 0)+1);
        }
        
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> b[1]-a[1]);
        
        for(Map.Entry<Integer, Integer> m: freq.entrySet()){
            q.add(new int[]{m.getKey(), m.getValue()});
        }
        
        long sum = 0;
        while(!q.isEmpty()){
            int[] t = q.poll();
            sum = sum + ((long)n*t[1]);
            n--;
        }
        
        return sum;
        
    }
}