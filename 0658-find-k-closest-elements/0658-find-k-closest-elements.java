class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n=arr.length;
        int ind=bs(arr,x,0,n-1);
        int[] dist=new int[n];
        int i=0;
        PriorityQueue<Integer> q=new PriorityQueue<>((a,b)->{// stores ind;
            if(dist[a]==dist[b])return arr[a]-arr[b];//when both are at same dist then sort according to no.s;
            else return dist[a]-dist[b];//when not then sort according to dist;
        });
        while(i<=ind){
            dist[i]=Math.abs(arr[i]-x);
            q.offer(i);
            i++;
        }
        int j=ind+1;
        while(j<n){
            dist[j]=Math.abs(arr[j]-x);
            q.offer(j);
            j++;
        }
        List<Integer> l=new ArrayList<>();
        while(!q.isEmpty()&&k>0){
            int val=q.poll();
            l.add(arr[val]);
            k--;
        }
        Collections.sort(l);
        return l;
    }
    public int bs(int[] arr,int tar,int s,int e){
        int ans=0;
        while(s<=e){
            int mid=(s+e)/2;
            if(arr[mid]>=tar){
                ans=mid;
                e=mid-1;
            }
            else{
                s=mid+1;
            }
        }
        return ans;
    }
}