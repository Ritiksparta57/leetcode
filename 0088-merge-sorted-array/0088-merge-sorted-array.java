class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] first=new int[m];
        int[] second=new int[n];
        for(int i=0;i<m;i++)first[i]=nums1[i];
        for(int j=0;j<n;j++)second[j]=nums2[j];
        int i=0;
        int j=0;
        int k=0;
        while(i<m&&j<n){
            if(first[i]<second[j]){
                nums1[k++]=first[i];
                i++;
            }
            else{
                nums1[k++]=second[j];
                j++;
            }
        }
        while(i<m){
            nums1[k++]=first[i++];
        }
        while(j<n){
            nums1[k++]=second[j++];
        }
    }
}