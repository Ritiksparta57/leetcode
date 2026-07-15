class Solution {
    public int numOfSubarrays(int[] arr, int k, int thresh) {
        int n=arr.length;
        int l=0;
        int i=l+k;
        int sum=0;
        int count=0;
        for(int j=l;j<i;j++)sum+=arr[j];
        if(sum>=thresh*k)count++;
        for(int j=i;j<n;j++){
           sum+=arr[j];
           sum-=arr[l];
           if(sum>=thresh*k)count++;
           i++;
           l++;
        }
        return count;
    }
}