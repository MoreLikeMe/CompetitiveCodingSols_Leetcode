/*
// Definition for a Node.
class Node { 
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        List<Node> nextList = null;
        List<Node> currList = new ArrayList<Node>();
        currList.add(root);
        
        while(currList!=null && currList.size()>0 && currList.get(0)!=null){
            nextList = new ArrayList<Node>();
            if(currList.get(0).left!=null){
                nextList.add(currList.get(0).left);
            }
            if(currList.get(0).right!=null){
                nextList.add(currList.get(0).right);
            }
            for(int i=1;i<currList.size();i++){
                if(currList.get(i).left!=null){
                    nextList.add(currList.get(i).left);
                }
                if(currList.get(i).right!=null){
                    nextList.add(currList.get(i).right);
                }
                currList.get(i-1).next = currList.get(i);
            }
            currList = nextList;
            nextList = null;
        }
        
        return root;
        
    }
}