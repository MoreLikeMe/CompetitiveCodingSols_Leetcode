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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        return pathSumRecur(new ArrayList<List<Integer>>(), new ArrayList<Integer>(), 0, targetSum, root);
    }
    
    public List<List<Integer>> pathSumRecur(List<List<Integer>> result, List<Integer> partial, int partialSum, int targetSum, TreeNode node){
        
        if(node==null){
            return result;
        }
        
        partialSum += node.val;
        partial.add(node.val);
            
        if(node.left==null && node.right==null && partialSum==targetSum){
            List<Integer> r = new ArrayList<>(partial);
            result.add(r);
        }
        
        pathSumRecur(result, partial, partialSum, targetSum, node.left);
        pathSumRecur(result, partial, partialSum, targetSum, node.right);
        partial.remove(partial.size()-1);
        
        return result;
    }
}