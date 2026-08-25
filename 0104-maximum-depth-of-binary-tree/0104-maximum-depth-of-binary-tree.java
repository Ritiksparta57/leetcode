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
    public int maxDepth(TreeNode root) {
        //so we need to get the height of the tree;
        //which is the maximum depth of tree from root to leaf;
        //so what ae are gonna do is we will add 1 to every level we are at and then go towards the maximum of left and right child;
        //for applying dp on trees we first call all our left and right required for that level and then we process them;
        if(root==null)return 0;
        int left=maxDepth(root.left);
        int right=maxDepth(root.right);
        int height=1+Math.max(left,right);
        return height;
    }
}