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
    /* Addition : 2 + 4
       l1 : 2
       l2 : 4
 newList  : 6
 
       Addition : 14 + 12 = 16
       l1 : 4 -> 1
       l2.: 2 -> 1
 newList  : 6 -> 1
 
       Addition : 9 + 4 = 13
       l1 : 9
       l2 : 4
 newlist  : 3 -> 1 
 
       Addition : 123 + 9 = 132
       l1 : 3 -> 2 -> 1
       l2 : 9    
 newList  : 2 -> 3 -> 1       
    */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode dummyCurr = dummy;
        ListNode curr1 = l1, curr2 = l2;
        int carry = 0;
        while(curr1 != null || curr2 != null){
            int val = (curr1 == null ? 0 : curr1.val) + (curr2 == null ? 0 : curr2.val) + carry;
            carry = val / 10;
            val = val % 10;
            if(dummy.next == null){
                dummy.next = new ListNode(val);
                dummyCurr = dummy.next;
            }
            else{ 
                dummyCurr.next = new ListNode(val);
                dummyCurr = dummyCurr.next;
            }   
            if(curr1 != null) curr1 = curr1.next;
            if(curr2 != null) curr2 = curr2.next;
        }
        if(carry > 0) dummyCurr.next = new ListNode(carry);
        return dummy.next;
    }
}