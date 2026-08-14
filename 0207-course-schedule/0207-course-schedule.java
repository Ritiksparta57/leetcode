class Solution {
    public boolean canFinish(int numCourses, int[][] pre) {
        //u want x course so before that you need to finish y course;
        //thus x becomes dependent on y but y is free;
        //so the marking or adjacency becomes x->y;
        //now to finish all courses the dependency should be in such order that everyone needs to be acyclic;
        //because if a cycle is formed then a person keeps on revolving around the same courses;
        //thus leaving all other in despair;
        //thus we have to find a way which leads us to an acyclic path;
        //TRY->
        //we will be counting no. of incoming edges for every node;
        //the node with no incoming edges can be the starting point of investigation as there is no node that is dependent on it;
        //then we add that node with 0 incomings in queue and then we move forward by iterating the neighbours and removing the connection of 0 incom node to that  node and check if that node also become a no dpendency node;
        //like that we check each node and in the end we have the highest no of dependency node left;
        //then we check whether after removal of it last dependency that node is free or not;
        List<List<Integer>> l=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            l.add(new ArrayList<>());
        }
        int[] incoming=new int[numCourses];
        for(int i=0;i<pre.length;i++){
           int x=pre[i][0];
           int y=pre[i][1];
           //incoming will on x as incoming counts the no. of courses that should be taken before joining x.
           //thus it means how many courses are blocking the path for x;
           incoming[x]++;
           //adding the dependent x to y as x is incoming to y;
           l.get(y).add(x);
        }
        List<Integer> ans=new ArrayList<>();
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            //the array incoming gives us the no. of courses which we need to take to be able to afford the course i;
            //so let us take those courses first which do not have any dependency or no prerequesite;
            if(incoming[i]==0){
                q.offer(i);
                ans.add(i);
            }
        }
        while(!q.isEmpty()){
           //now we will remove dependency of y from all of its x neighbors and if there incoming becomes 0 i.e. if there are no more prerequisite required to tak course x then we will add them to q as they are also free;
           int y=q.poll();
           for(int x:l.get(y)){
             incoming[x]--;
             if(incoming[x]==0){
                q.offer(x);
                ans.add(x);
             }
           }
        }
        return ans.size()==numCourses?true:false;
    }
}