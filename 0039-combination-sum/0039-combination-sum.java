class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //here we will need recursion as we need the list to reach the target;
        //here it is asking for unique combinations thus the {1,2} is same as {2,1} so we need not to care for making multiple combinations from every element what we need to care is starting from 0th element and going till n in how many ways we can reach target;
        //the direction of flow is only in one direction unlike cs4 where even previous elements were needed; 
        int n=candidates.length;
        List<List<Integer>> l=new ArrayList<>();
        List<Integer> ans=new ArrayList<>();
        dfs(0,n,candidates,target,ans,l);
        return l;
    }
    public void dfs(int i,int n,int[] cand,int tar,List<Integer> ans,List<List<Integer>> l){
        //now when we reach tar==0;
        if(tar==0){
            l.add(new ArrayList<>(ans));
            return;
        }
        if(i>=n)return;
        //we only take the element which is less than or equal to tar else we leave it;
        //since there are other combinations to try thus we just use the element one time and then we backtrack;
        //this is when we do not take the element->NOT TAKE;
        dfs(i+1,n,cand,tar,ans,l);
        //this part is when we take the element->TAKE;
        if(cand[i]<=tar){
            ans.add(cand[i]);
            //then afte taking the cand[i] we just recurse the function;
            dfs(i,n,cand,tar-cand[i],ans,l);
            //then we remove the element to make space int the new list;
            ans.remove(ans.size()-1);
        }
    }
}