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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        //here numonright gonna play a big role as it is nearest to the root unlike in preorder;
        //else everything is same;
        int inn=inorder.length;
        int postn=postorder.length;
        Map<Integer,Integer> m=new HashMap<>();
        for(int i=0;i<inn;i++)m.put(inorder[i],i);
        TreeNode root=dfs(inorder,postorder,postn-1,0,0,inn-1,m);
        return root;
    }
    public TreeNode dfs(int[] inorder,int[] postorder,int postend,int poststart,int instart,int inend,Map<Integer,Integer> m){
        if(instart>inend||poststart>postend)return null;
        int inroot=m.get(postorder[postend]);
        int numonright=inend-inroot;
        TreeNode root=new TreeNode(postorder[postend]);
        root.right=dfs(inorder,postorder,postend-1,postend-numonright,inroot+1,inend,m);
        root.left=dfs(inorder,postorder,postend-numonright-1,poststart,instart,inroot-1,m);
        return root;
    }
}