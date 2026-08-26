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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        //we will do the level order traversal but maintain  a boolean variable to help us with traversing in zigzag manner;
        //that is when it is true then we flip the list and then add in arraylist and when it is false we add the list as it is;
        List<List<Integer>> l=new ArrayList<>();
        if(root==null)return l;
        Queue<TreeNode> q=new LinkedList<>();
        boolean flip=false;
        q.offer(root);
        while(!q.isEmpty()){
            int s=q.size();
            List<Integer> ans=new ArrayList<>();
            for(int i=0;i<s;i++){
                TreeNode t=q.poll();
                ans.add(t.val);
                if(t.left!=null)q.offer(t.left);
                if(t.right!=null)q.offer(t.right);
            }
            if(flip){
                Collections.reverse(ans);
            }
            flip=!flip;
            l.add(ans);
        }
        return l;
    }
}