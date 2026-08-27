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
    //        if(root==null)return true;
    //     List<Long> l=new ArrayList<>();
    //     dfs(root,l);
    //     for(int i=1;i<l.size();i++){
    //         if(l.get(i)<=l.get(i-1))return false;
    //     }
    //     return true;
    //     public void dfs(TreeNode root,List<Long> l){
    //     //left->root->right
    //     if(root==null)return;
    //     dfs(root.left,l);
    //     l.add((long)root.val);
    //     dfs(root.right,l);
    // }
    // OPTIMAL ONE IS WITHOUT RECURSION STACK->
        //2.In this i am going to set a maximum and minimum range that the root values can have;
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