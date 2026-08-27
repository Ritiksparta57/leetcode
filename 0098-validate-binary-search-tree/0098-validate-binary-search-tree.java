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
    public boolean isValidBST(TreeNode root) {
        //the inorder traversal of bst gives us a sorted array or list;
        //1.//so one of the way is to do inorder traversal then traverse the list and if there are any descrepencies found in the list then immediately give false;
        //2.// //the other way i am going to do is by recursively calling and comparing the child and the current parent;
        // if(root==null)return true;
        // //since we need the information of left and right subtrees too so we need to call them first but before that we need to compare our this node with its children;
        // boolean left=isValidBST(root.left);
        // boolean right=isValidBST(root.right);
        // if(root.left!=null&&root.right!=null){
        //     if(root.left.val>=root.val||root.right.val<=root.val||left==false||right==false){
        //       return false;
        //     }
        // }
        // else if(root.left!=null){
        //     if(root.left.val>=root.val||left==false||right==false){
        //       return false;
        //     }
        // }
        // else if(root.right!=null){
        //     if(root.right.val<=root.val||left==false||right==false){
        //       return false;
        //     }
        // }
        // return true;
        //3.In this i am going to set a maximum and minimum range that the root values can have;
        //this way i can easily compare the value of root whether it lise in the range or not;
        //if any exception is found then return false;
        //for left subtree the minimum value will be the minimum of prev. node;
        //for left the maximum will the prev. node;
        //for right the minimum will be the prev.node  and the maximum will be the maximum of prev. node;
        if(root==null)return true;
        return dfs(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    public boolean dfs(TreeNode root,long min,long max){
        if(root==null)return true;
        if((long)root.val>=max||(long)root.val<=min)return false;
        boolean left=dfs(root.left,min,(long)root.val);//min to minimum hi rahega but maximum root ka value ho jayega;
        boolean right=dfs(root.right,(long)root.val,max);
        return left&&right;
    }
}