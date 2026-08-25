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
 class pair{
    TreeNode node;
    int r;
    public pair(TreeNode n,int r1){
        this.node=n;
        this.r=r1;
    }
 }
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        //had it been the bottom or top side view we would mainly focus on the column and update the map respectively;
        //but since this question asks for right side view therefore we should mainly focus on row;
        //we will take the root as 0 th row and we will do level order traversal and update the map for the row with the last value of that row;
        //let us make pair of value and row;
        Map<Integer,Integer> m=new LinkedHashMap<>();
        List<Integer> l=new ArrayList<>();
        if(root==null)return l;
        Queue<pair> q=new LinkedList<>();
        m.put(0,root.val);
        q.offer(new pair(root,0));
        while(!q.isEmpty()){
            int s=q.size();
            for(int i=0;i<s;i++){
                pair p=q.poll();
                TreeNode t=p.node;
                int r=p.r;
                //since this whole traversal will contain the same row number r as the elements over here are on the same level therefore we will keep on updating m with the value r;
                m.put(r,t.val);
                if(t.left!=null)q.offer(new pair(t.left,r+1));
                if(t.right!=null)q.offer(new pair(t.right,r+1));
            }
        }
        for(Map.Entry<Integer,Integer> m1:m.entrySet()){
            int key=m1.getKey();
            int value=m1.getValue();
            l.add(value);
        }
        return l;
    }
}