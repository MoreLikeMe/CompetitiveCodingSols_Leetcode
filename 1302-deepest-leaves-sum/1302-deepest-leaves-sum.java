/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int deepestLeavesSum(TreeNode root) {
        Map<Integer, Integer> map =  new HashMap<Integer, Integer>();
        recurCall(root, 0, map);
        for(Map.Entry<Integer, Integer> d: map.entrySet()){
            System.out.println(d.getKey() + "    " + d.getValue());
        }
        int maxKey = Collections.max(map.keySet());
        return map.get(maxKey);
    }
    
    public void recurCall(TreeNode node, int level, Map<Integer, Integer> map){
        
        if(node==null){
            return;
        }
        
        map.put(level, node.val + map.getOrDefault(level, 0));
        
        recurCall(node.left, level+1, map);
        recurCall(node.right, level+1, map);
        
        return;
    }
}