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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        if(root==null){
            return result;
        }
        
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        ArrayDeque<TreeNode> tstack = new ArrayDeque<>();
        stack.offerLast(root);
        boolean isLeftToRight = false;
        while(!stack.isEmpty()){
            int size = stack.size();
            isLeftToRight = !isLeftToRight;
            List<Integer> r = new ArrayList<Integer>();
            while(size-- >0){
                TreeNode t = stack.pollLast();
                r.add(t.val);
                if(isLeftToRight){
                    if(t.left!=null)
                        tstack.offerLast(t.left);
                    if(t.right!=null)
                        tstack.offerLast(t.right);
                } else {
                    if(t.right!=null)
                        tstack.offerLast(t.right);
                    if(t.left!=null)
                        tstack.offerLast(t.left);
                }
            }
            result.add(r);
            ArrayDeque<TreeNode> tmp = tstack;
            tstack = stack;
            stack = tmp;
        }
        return result;
    }
}