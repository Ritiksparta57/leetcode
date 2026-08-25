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
    public List<List<Integer>> levelOrder(TreeNode root) {
        //this similar to bfs traversal in graph;
        //we just need a priority queue in which we will store the nodes nd level wise we will traverse it;
        //since the traversal is level wise therefore while queue traversal we will use for loop with traversal ending at the size of the current queue;
        List<List<Integer>> l=new ArrayList<>();
        if(root==null)return l;
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int s=q.size();
            List<Integer> ans=new ArrayList<>();
            for(int i=0;i<s;i++){
                TreeNode p=q.poll();
                ans.add(p.val);
                if(p.left!=null)q.offer(p.left);
                if(p.right!=null)q.offer(p.right);
            }
            l.add(ans);
        }
        return l;
    }
}