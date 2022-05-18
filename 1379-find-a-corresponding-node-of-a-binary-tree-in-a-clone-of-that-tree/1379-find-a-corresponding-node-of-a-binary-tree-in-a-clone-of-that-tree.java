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
        
        if(original.val == target.val && cloned.val == target.val ){
            return cloned;
        }
        
        TreeNode left=null, right=null;
        if(original.left!=null && cloned.left!=null){
            left = getTargetCopy(original.left, cloned.left, target);
        }
        if(original.right!=null && cloned.right!=null){
            right = getTargetCopy(original.right, cloned.right, target);
        }
        
        if(left!=null){
            return left;
        } else if(right!=null){
            return right;
        } else{
            return null;
        }
         
    }
}