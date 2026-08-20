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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        //here recursion on tree can be useful;
        //that is we dig deep down to the last node from first node(sounds like dfs) in the mean time maintaing the sum where when we reach the last node we equalize the sum with target sum and see whether they are equal or not;
        return dfs(root,0,targetSum);
    }
    public boolean dfs(TreeNode root,int sum,int target){
        //base case i am keeping is when we hit the last node and check whether the summation gives us the desired ourput;
        if(root==null)return false;
        if(root.left==null&&root.right==null){
            sum+=root.val;
            if(sum==target)return true;
            else return false;
        }
        //since we have written the base case now the main logic is required;
        //we will maintain two pointer left and right who are boolean indicating whether they are false or true;
        boolean left=false;
        boolean right=false;
        if(root.left!=null){
            left=left||dfs(root.left,sum+root.val,target);
        }
        if(root.right!=null){
            right=right||dfs(root.right,sum+root.val,target);
        }
        return left||right;
    }
}