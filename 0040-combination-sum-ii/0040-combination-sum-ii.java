class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //HERE THE NO. CAN BE USED ONLY ONCE AND ALSO THE COMBINATIONS MUST BE UNIQUE;
        //so the part where we were taking a coin multiple times is now gone we just need to take what is there in the array;
        Arrays.sort(candidates);
        List<List<Integer>> l=new ArrayList<>();
        List<Integer> ans=new ArrayList<>();
        dfs(0,l,ans,candidates,target);
        return l;
    }
    public void dfs(int i,List<List<Integer>> l,List<Integer> ans,int[] cand,int tar){
         //the base cases will be same;
         if(tar==0){
            //we create a copy of ans then store in set;
            //the reason is java set stores the reference to ans not the actaul ans so in the next step when ans became [1] then set too becomes [1] from [1,2];
            //but there is a problem with tle as even though we are using set still we are computing the useless elements;
            //so set is not good;
            List<Integer> temp=new ArrayList<>(ans);
                l.add(new ArrayList<>(temp));
            return;
         }
         if(tar<0||i>=cand.length)return;
         //now comes the major one either we are taking this or we are not;
         //TAKE->
         if(cand[i]<=tar){
            ans.add(cand[i]);
            //here we are incrementing i so that we do not use the same element;
            dfs(i+1,l,ans,cand,tar-cand[i]);
            //we do this so that the ith element may be used int other combinations as well;
            ans.remove(ans.size()-1);
         }
            //NOT TAKE->
            //here we can make changes that is if we want no to take the element then we will make sure that the upcoming element is different and not make the same combination as if current and upcoming are same then taking same upcoming will make the same combination;
            int next=i+1;//the upcoming one;
            //now let us take the next to the element where next is not the current element;
            while(next<cand.length&&cand[next]==cand[i])next++;
            //now since we have the no. or element differet from i thus we call the dfs;
         dfs(next,l,ans,cand,tar);
    }
}