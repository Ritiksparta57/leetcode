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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        //while inserting if the val is greater than root then the node goes to right else it goes towards left;
        //this keeps on going until we find the perfect place for it;
        if(root==null)return new TreeNode(val);
        return buildtree(root,val);
    }
    public TreeNode buildtree(TreeNode root,int val){
        if(root==null)return new TreeNode(val);
        //we start comparing the val with the current root;
        if(root.val>val){
            root.left=buildtree(root.left,val);
        }
        else if(root.val<val){
           root.right=buildtree(root.right,val);
        }
        return root;
    }
}