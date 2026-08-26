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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
       //the preorder contains the root,left,right and the inorder contains left,root,right;
       //steps->
       //1.find the root and then find where the root is located within inorder;
       //BONUS. We need a map to store the value of integer and the index at which that integer is there;
       //2.then make the root as head of tree;
       //3.the left of root in inorder gives us the length of left subtree and similar ones are the right ones;
       //4.now for the left we are gonna do length of left + root's index in preorder and 0 to root-1 in inorder;
       //5.similar for right;
       //6.then just return the tree;
       int pren=preorder.length;
       int inn=inorder.length;
       Map<Integer,Integer> m=new HashMap<>();//we are using map just for easy picking up of indexes while traversing the inorder;
       for(int i=0;i<inn;i++)m.put(inorder[i],i);
       TreeNode root=dfs(preorder,inorder,0,pren-1,0,inn-1,m); 
       return root;
    }
    public TreeNode dfs(int[] preorder,int[] inorder,int prestart,int preend,int instart,int inend,Map<Integer,Integer> m){
        //the base condition will be when prestart goes beyond preend and instart goes beyond inend;
        if(prestart>preend||instart>inend)return null;
        //for the very first element we would calculate where it is located;
        int inroot=m.get(preorder[prestart]);
        //since we have the starting point at where the root is inside inorder then we can calculate the amount of nodes on each side of subtree of root node;
        int numsonleft=inroot-instart;
        int numonright=inend-inroot;
        TreeNode root=new TreeNode(preorder[prestart]);
        //now we go for the left and right child;
    //for left -> in preorder the left starts right after root and goes till numsonleft;
                //in inorder the left starts from instart and ends at inroot-1;
    //for right-> in preorder the right starts after prestart+numsonleft+1 and ends at preend;
                //in inorder the right starts from inroot+1 and goes till inend;
        root.left=dfs(preorder,inorder,prestart+1,prestart+numsonleft,instart,inroot-1,m);
        root.right=dfs(preorder,inorder,prestart+numsonleft+1,preend,inroot+1,inend,m);
        return root;
    }
}