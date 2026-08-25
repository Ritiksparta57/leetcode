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
    int bal=0;
    public boolean isBalanced(TreeNode root) {
        //balanced tree is one where the height or depth difference between two subtrees never differ by one;
        //the thing is we need to traverse each and every node;
        //then similar to diameter we need to check  every point's height diference;
        //the problem is we need to calculate height and return true or false at the same time;
        //but both have different return types;
        //one thing which we can do is we keep calculating height but also keep a variable (global) one which keeps an eye on the difference on lh and rh and then stores the maximum possible value;
        height(root);
        return bal<=1?true:false;
    }
    public int height(TreeNode root){
        if(root==null)return 0;
        int left=height(root.left);
        int right=height(root.right);
        bal=Math.max(bal,Math.abs(left-right));
        return 1+Math.max(left,right);
    }
}