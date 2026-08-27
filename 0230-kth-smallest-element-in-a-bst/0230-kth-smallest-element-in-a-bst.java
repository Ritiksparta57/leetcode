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
    public int kthSmallest(TreeNode root, int k) {
        //the bst contains the numbers in ascending order;
        //thus just make a list of number then give the number k;
        List<Integer> l=new ArrayList<>();
        dfs(root,l);
        int ans=0;
        int i=0;
        while(k>0){
          ans=l.get(i++);
          k--;
        }
        return ans;
    }
    public void dfs(TreeNode root,List<Integer> l){
        if(root==null)return;
        dfs(root.left,l);
        l.add(root.val);
        dfs(root.right,l);
    }
}