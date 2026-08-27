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
    public TreeNode bstFromPreorder(int[] preorder) {
      //we may use bst property;
      //since the first element is root then the upcoming ones will be left which are less than root as in property of bst;
      //similarly from the moment in preorder we get a value greater than root we have our right subtree;
      int n=preorder.length;
      return buildtree(preorder,0,n-1);
    }
    public TreeNode buildtree(int[] pre,int start,int end){
        if(start>end)return null;
        TreeNode t=new TreeNode(pre[start]);//since start is the root element;
        //then now we need to calculate the length of left subtree;
        //this can be calculated in such a way that the first element we encounter in preorder that are greater than root is the gateway to right subtree;
        int i=start+1;
        while(i<=end&&pre[i]<t.val){
            i++;
        }
        //when it stops then that is the moment where i is equal to the length;
        t.left=buildtree(pre,start+1,i-1);
        //the right subtree will start from i as there we get elements greater than root and ends at the last;
        t.right=buildtree(pre,i,end);
        return t;
    }
}