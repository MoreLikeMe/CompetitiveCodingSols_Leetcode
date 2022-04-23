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
    public ListNode mergeKLists(ListNode[] list) {
        
        ListNode start=null,head=null;
        
        //for inputs like [[]]
        if(list.length==0){
            return null;
        }

        
        if(list.length==1 && list[0]==null){
            return list[0];
        }
        
        
        while(true){
            int min = Integer.MAX_VALUE;
            int temp = -1;
            
            //get the minimum of each iteration
            for(int i=0;i<list.length;i++){
                if(list[i]!=null && min>list[i].val){
                    min = list[i].val;
                    temp = i;
                }
            }
            
            //if there is no minimum that means all the linked lists are covered
            if(temp==-1){
                //this is to mark the next part of the last node of result null...
                if(head!=null){
                    head.next = null;
                }
                break;
            }
            
            if(head==null){
                start = list[temp];
                head = list[temp];
            } else {
                head.next = list[temp];
                head = head.next;
            }
            list[temp] = list[temp].next; 
        }
        return start;
    }
}