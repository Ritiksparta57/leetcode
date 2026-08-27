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
    public TreeNode deleteNode(TreeNode root, int key) {
        //in insertion we were inserting the number when the root was null therefore it became easier as we just need to traverse tree finding where the null node is with maintaining the order by comparing it with the root's value;
        //but in deletion finding the number is not a big task but deleting it is;
        //we can replace the number with either the maximum on left subtree or minimum on right subtree;
        //finding the maximum on left or right is easy in bst as if we go right then minimum can be found on the leftmost side;
        //similarly if we go left then we find the maximum on rightmost side;
        //thus the steps are clear ->1.find the number;
        //2.find the node we repalce it with(mostly doen by taking the min from right);
        //3.replacing it;
        if(root==null)return null;
        if(root.val<key)root.right=deleteNode(root.right,key);
        else if(root.val>key)root.left=deleteNode(root.left,key);
        //when root==key then there are three possibilities->
        //1.when the root does not have a left subtree thus root.right becomes one;
        //2.when the root does not have right subtree then root.left becomes one;
        //3.when the root have both then make right as ur heir and go as far left as possible as that will be the minimum from right side;
        else{
            //when root=key;
            if(root.left==null)return root.right;//left is null;
            if(root.right==null)return root.left;//right is null;
            //now it has children then make right as ur rightful heir;
            TreeNode rep=root.right;
            //now just traverse as left as possible from root.right;
            while(rep.left!=null){
                rep=rep.left;
            }
            //since rep.left becomes null there we have the minimum max possible;
            //now just replce ur root with it;
            root.val=rep.val;
            root.right=deleteNode(root.right,rep.val);
        }
        return root;
    }
    
}