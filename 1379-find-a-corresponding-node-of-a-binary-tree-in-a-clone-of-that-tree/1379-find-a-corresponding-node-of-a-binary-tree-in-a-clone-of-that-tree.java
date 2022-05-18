/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        return recurCall(cloned, target.val);
    }
    
    public TreeNode recurCall(TreeNode cloned, int val){
        if(cloned==null){
            return null;
        }
        if(cloned.val==val){
            return cloned;
        }
        
        TreeNode temp = null;
        temp = recurCall(cloned.left, val);
        if(temp!=null){
            return temp;
        }
        return recurCall(cloned.right, val);
        
    }
}