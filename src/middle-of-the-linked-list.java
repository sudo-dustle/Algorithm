//https://leetcode.com/problems/middle-of-the-linked-list
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
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(true) {
            if(fast == null) break;
            fast = fast.next;
            if(fast == null) break;
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }
}
