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
    public List<List<Integer>> levelOrder(TreeNode root) {
       
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<TreeNode> temp = new ArrayList<TreeNode>();
        List<TreeNode> nextTemp = null;
        List<Integer> tempVal = null;
        
        if(root==null){
            return result;
        }
        
        temp.add(root);
        
        while(temp.size()!=0){
            tempVal = new ArrayList<Integer>();
            nextTemp = new ArrayList<TreeNode>();;
            for(TreeNode n: temp){
                tempVal.add(n.val);
                if(n.left!=null){
                    nextTemp.add(n.left);
                }
                if(n.right!=null){
                    nextTemp.add(n.right);
                }
            }
            temp = nextTemp;
            result.add(tempVal);
        }
        return result;
    }
}