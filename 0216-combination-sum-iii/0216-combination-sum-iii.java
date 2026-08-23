class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> l=new ArrayList<>();
        List<Integer> ans=new ArrayList<>();
        if(k>n)return l;
        //we need to choose between the numbers in between 1 to 9;
        //thus let us make array from 1 to 9 for ease;
        int[] karr=new int[]{1,2,3,4,5,6,7,8,9};
        dfs(0,k,karr,n,l,ans);
        return l;
    }
    public void dfs(int i,int k,int[] karr,int tar,List<List<Integer>> l,List<Integer> ans){
        //base case->
        //one is when we reach k==0 then we check if tar ==0;
        if(k==0){
            if(tar==0){
                l.add(new ArrayList<>(ans));
                return;
            }
            else return;
        }
        if(i>=9)return;
        //now here comes the main we take or not take the numbers;
        //take->
        if(karr[i]<=tar){
            ans.add(karr[i]);
            dfs(i+1,k-1,karr,tar-karr[i],l,ans);
            ans.remove(ans.size()-1);
        }
        //not take->
        //then make sure that the combination does not come again;
        // int next=i+1;
        // while(next<10&&karr[next])
        //wait in the array i have already made sure there is no duplicates;
        dfs(i+1,k,karr,tar,l,ans);
    }
}