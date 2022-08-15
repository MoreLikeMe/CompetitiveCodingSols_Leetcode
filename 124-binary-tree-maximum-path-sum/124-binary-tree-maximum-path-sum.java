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
    private static int maxValue = 0;
    public int maxPathSum(TreeNode root) {
        maxValue = Integer.MIN_VALUE;
        maxPathSumRecursive(root);
        return maxValue;
    }
    
    private int maxPathSumRecursive(TreeNode root){
         
        if(root==null){
            return 0;
        }
        int leftSum =  maxPathSumRecursive(root.left);
        int rightSum = maxPathSumRecursive(root.right);
        int sum = root.val + (leftSum<0?0:leftSum) + (rightSum<0?0:rightSum);
        if(sum>maxValue){
            maxValue = sum;
        }
        
        return ((Math.max(leftSum, rightSum)<0?0:Math.max(leftSum, rightSum)) + root.val);
    }
    
}