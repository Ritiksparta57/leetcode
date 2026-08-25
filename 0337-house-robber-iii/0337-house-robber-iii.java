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
    public int rob(TreeNode root) {
        //for every node there are two possibilities i.e. two value either i rob or not rob;
        //if we rob a particular node we do not select the next node that is the childs so we take the not rob option from both its right and left child;
        //if we do not rob then we have possibility to select from the rob and not rob options of both the childs and adding the amximum value possible from each child;
        //so we call the dfs and return the maximum of rob or not rob;
        int[] ans=dfs(root);
        return Math.max(ans[0],ans[1]);
    }
    public int[] dfs(TreeNode root){
        //base case is when we reach a node that is null;
        if(root==null)return new int[]{0,0};
        int[] left=dfs(root.left);
        int[] right=dfs(root.right);
        //two options since we have left and right of the child values we can explore the options;
        //one is robbing the house hence restricting to take only notrob optin from child;
        int rob=root.val+left[1]+right[1];
        //other is not robbing so we are free to take the maximum value from both the childs;
        int notrob=Math.max(left[0],left[1])+Math.max(right[0],right[1]);
        return new int[]{rob,notrob};
    }
    // i got an idea whhy not just do a level order traversal on the tree and then store the sum of that level in a list then do house robber 1;
        // List<Integer> l=new ArrayList<>();
        // Queue<TreeNode> q=new LinkedList<>();
        // q.offer(root);
        // while(!q.isEmpty()){
        //     int s=q.size();
        //     int sum=0;
        //     for(int i=0;i<s;i++){
        //         TreeNode t=q.poll();
        //         sum+=t.val;
        //         if(t.left!=null)q.offer(t.left);
        //         if(t.right!=null)q.offer(t.right);
        //     }
        //     l.add(sum);
        // }
        // //now the problem has became [1,3,5,6,6] and so like that (array is just an example);
        // //now just apply the house robber thing that is 1d dp to find the max amount possible;
        // int n=l.size();
        // int[] dp=new int[n];
        // Arrays.fill(dp,-1);
        // return dfs(n-1,l,dp);
    // public int dfs(int i,List<Integer> l,int[] dp){
    //     //base case is when we reach the last node;
    //     if(i==0)return l.get(i);
    //     if(i<0)return 0;
    //     if(dp[i]!=-1)return dp[i];
    //     int not=0;
    //     int pick=0;
    //     not=dfs(i-1,l,dp);
    //     pick=l.get(i)+dfs(i-2,l,dp);
    //     return dp[i]=Math.max(pick,not);
    // }
}