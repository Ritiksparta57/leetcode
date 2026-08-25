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
    int dia=0;//so that we may get accurate daimeter with changing levels;
    public int diameterOfBinaryTree(TreeNode root) {
        //see the diameter is the longest path or the maximum number of nodes in between to nodes;
       //as far as i can see the longest path can be from leftmost node to rightmost node;
       //therefore we just need to calculate the height of left subtree and right subtree and then add them up including the root;
       //but there is a catch;
       //if we just calculate through root node then it might be possible that there is no right subtree thus giving less diameter;
       //so we need to calculate diameter along with the height at every node;
    //    if(root==null)return 0;
    //    int left=diameterOfBinaryTree(root.left);//this is to get height of left subtree;
    //    int right=diameterOfBinaryTree(root.right);//and this is for right subtree;
    //    int d=1+left+right;
    //    dia=Math.max(d,dia);
    //    return 1+Math.max(left,right);
    //we cannot do like above as the main function belongs to diameter return;
    //so we just call the height function;
    height(root);
    return dia;
    }
    //at every single node we are calculating height through height recurrence function thus allowing us to calculate diameter through adding the left and right subtree height at every node;
    public int height(TreeNode root){
       if(root==null)return 0;
       int left=height(root.left);//this is to get height of left subtree;
       int right=height(root.right);//and this is for right subtree;
       int d=left+right;
       dia=Math.max(d,dia);
       return 1+Math.max(left,right);
    }
}