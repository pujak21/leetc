/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode temp1 = head;
        ListNode temp2 = head;
        while(temp2 != null && temp2.next != null ){
            if(temp2.next == temp1){
            return true;
        }
        temp1 = temp1.next;
        temp2 = temp2.next.next;
        }
     return false;
        }

        
        
    
    
}