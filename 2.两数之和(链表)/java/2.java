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
  ListNode head = new ListNode();
            ListNode crt = head;
            int inherit = 0;
            while(true) {
                if (l1 == null && l2 == null && inherit == 0) {
                    break;
                }
                int tmpVal = inherit;
                if (l1 != null) {
                    tmpVal = tmpVal + l1.val;
                    l1 = l1.next;
                }
                if (l2 != null) {
                    tmpVal = tmpVal + l2.val;
                    l2 = l2.next;
                }
                inherit = tmpVal / 10;
                ListNode node = new ListNode();
                node.val = tmpVal % 10;
                crt.next = node;
                crt = node;
            }
            return head.next;
    }
}
