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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> l=new ArrayList<>();
        List<Integer> ans=new ArrayList<>();
        dfs(root,targetSum,l,ans);
        return l;
    }
    public void dfs(TreeNode root,int tar,List<List<Integer>> l,List<Integer> ans){
        // if(tar==0){
        //     l.add(new ArrayList<>(ans));
        //     return;
        // }
        // if(tar<0)return;
        //above bc were not fit as the problem demands that the path must end at leaf;
        //also the answer demands that the path should begin from root node therefore we need to add the path to ans;
        if(root==null)return;
        ans.add(root.val);
        if(root.left==null&&root.right==null&&tar==root.val){
            l.add(new ArrayList<>(ans));
        }
        else{
            dfs(root.left,tar-root.val,l,ans);
            dfs(root.right,tar-root.val,l,ans);
        }
        ans.remove(ans.size()-1);
    }
}