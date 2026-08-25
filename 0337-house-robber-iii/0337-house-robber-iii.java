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
    public int rob(TreeNode root) {
        //every node has two possibility one to rob and other not to rob;
        //when we rob we add the not rob of the children and when we do not rob then we take maximum value from rob and not rob of the two childs and add them up;
        //at the end we return the maximum of rob and not rob;
        int[] ans=dfs(root);
        return Math.max(ans[0],ans[1]);
    }
    public int[] dfs(TreeNode root){
        if(root==null)return new int[]{0,0};
        //we need to have info of child to use it in this case;
        //so we must collect it first;
        int[] left=dfs(root.left);
        int[] right=dfs(root.right);
        //now comes the rob and not rob possibility;
        int rob=root.val+left[1]+right[1];//when we do not rob the childs;
        int notrob=Math.max(left[0],left[1])+Math.max(right[0],right[1]);
        return new int[]{rob,notrob};
    }
}