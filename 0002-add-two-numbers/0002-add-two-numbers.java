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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        
        ListNode answer = new ListNode();
        ListNode current = answer;
        while(true){
            int value1 = l1.val;
            int value2 = l2.val;

            int sum = value1 + value2 + carry;
            carry = sum / 10;
            sum = sum % 10;
            
            current.next = new ListNode(sum);
            current = current.next;

            if(l1.next != null && l2.next != null){
                l1 = l1.next;
                l2 = l2.next;
            }else if(l1.next != null){
                l1 = l1.next;
                l2 = new ListNode(0);
            }else if(l2.next != null){
                l2 = l2.next;
                l1 = new ListNode(0);
            }else{
                if(carry == 1)
                    current.next = new ListNode(carry);
                break;
            }
        }
        

        return answer.next;
    }
}