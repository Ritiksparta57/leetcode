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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //lowest common ancestor is the one where both nodes meet up above themselves;
        //thus the childs of that ancestor cannot be null;
        //see we cannot go to a node and then comeback to previous one;
        //thus at every node we call the recursive function for its child and if we found both the nodes then we confirm that thr node from which recursive function was called has its left and right child or not;
        // if yes then that is the node which we are reffering to;
        //else the non null node is given the control;
        //this is the base case when we found a null,p or q node;
        if(root==null||root==p||root==q)return root;
        //now we will find the left and right nodes;
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);
        //now we have either reached null or p or q then we test for the current node whether it is non null or not;
        if(left==null)return right;
        if(right==null)return left;
        return root;
    }
}