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
        //in binary tree we were finding the left and right child then if both of them are non null then we return the node;
        //but here we have a upper hand of sorted thing;
        //we have p and q so the lca may lie in between both of them;
        //the node >=p but <=q having children on both the sides is the one;
        if(root==null||root==p||root==q)return root;
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);
        if(left==null)return right;
        if(right==null)return left;
        return root;
    }
}