/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int prev=-1;
        List<Integer> l=new ArrayList<>();
        ListNode temp=head;
        int count=0;
        while(temp!=null){
            count++;
            if(prev!=-1&&temp.next!=null){
                if((temp.val>prev&&temp.val>temp.next.val)||(temp.val<prev&&temp.val<temp.next.val)){
                   l.add(count);
                }
            }
            prev=temp.val;
            temp=temp.next;
        }
        int max=-1;
        int min=Integer.MAX_VALUE;
        if(l.size()>1){
        max=l.get(l.size()-1)-l.get(0);
        int[] diff=new int[l.size()];
        diff[0]=0;
        for(int i=1;i<l.size();i++){
            diff[i]=l.get(i)-l.get(i-1);
            min=Math.min(diff[i],min);
        }
        }
        return min==Integer.MAX_VALUE?new int[]{-1,max}:new int[]{min,max};
    }
}