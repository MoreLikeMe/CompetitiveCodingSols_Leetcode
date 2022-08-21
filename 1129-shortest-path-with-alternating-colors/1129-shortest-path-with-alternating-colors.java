class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        
        Map<Integer, List<Integer>> redMap = new HashMap<>();
        Map<Integer, List<Integer>> blueMap = new HashMap<>();
        
        for(int i=0;i<redEdges.length;i++){
            List<Integer> adjList = redMap.getOrDefault(redEdges[i][0], new ArrayList<Integer>());
            adjList.add(redEdges[i][1]);
            redMap.put(redEdges[i][0], adjList);
        }
        
        for(int i=0;i<blueEdges.length;i++){
            List<Integer> adjList = blueMap.getOrDefault(blueEdges[i][0], new ArrayList<Integer>());
            adjList.add(blueEdges[i][1]);
            blueMap.put(blueEdges[i][0], adjList);
        }
        
        Set<String> isVisited = new HashSet<>();
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offerLast(new int[]{0,-1});
        
        int level = 0;
        int[] result = new int[n];
        Arrays.fill(result, Integer.MAX_VALUE);
        result[0] = 0;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            level++;
            while(size-- >0){
                int[] curr = queue.pollFirst();
                int currNode = curr[0];
                int prevEdge = curr[1];
                
                if(prevEdge==0 || prevEdge==-1){
                    if(blueMap.get(currNode)!=null){
                        for(int nextNode:blueMap.get(currNode)){
                            if(!isVisited.contains(nextNode+"-"+1)){
                                queue.offerLast(new int[]{nextNode, 1});
                                isVisited.add(nextNode+"-"+1);
                                result[nextNode] = Math.min(result[nextNode],level);
                            }
                        }
                    }
                }
                
                 if(prevEdge==1 || prevEdge==-1){
                    if(redMap.get(currNode)!=null){
                        for(int nextNode:redMap.get(currNode)){
                            if(!isVisited.contains(nextNode+"-"+0)){
                                queue.offerLast(new int[]{nextNode, 0});
                                isVisited.add(nextNode+"-"+0);
                                result[nextNode] = Math.min(result[nextNode],level);
                            }
                        }
                    }
                }
                
            }
        }
        for(int i=0;i<result.length;i++){
            if(result[i]==Integer.MAX_VALUE){
                result[i] = -1;
            }
        }
        return result;
    }
}