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
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.offerLast(root);
        
        while(!queue.isEmpty()){
            int levelSize = queue.size(), itr = 0;
            while(itr++ <levelSize){
                TreeNode curNode  = queue.pollFirst();
                if(itr==1){
                    result.add(curNode.val);
                }
                if(curNode.right!=null){
                    queue.offerLast(curNode.right);
                }
                if(curNode.left!=null){
                    queue.offerLast(curNode.left);
                }
            }
        }
        return result;
    }
}