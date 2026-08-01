class Solution {
    public int maxArea(int[] height) {
        int n=height.length;
        int max=Integer.MIN_VALUE;
        int l=0;
        int h=n-1;
        while(l<=h){
            int prod=Math.min(height[l],height[h])*(h-l);
            max=Math.max(max,prod);
            if(height[l]<height[h]){
                l++;
            }
            else{
                h--;
            }
        }
        return max;
    }
}