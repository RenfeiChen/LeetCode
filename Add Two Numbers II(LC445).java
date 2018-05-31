/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        ListNode pre = null;
        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        int add = 0;
        while (!s1.empty() && !s2.empty()) {
            int cur1 = s1.pop(), cur2 = s2.pop(), cur = 0;
            if (cur1 + cur2 + add >= 10) {
                cur = cur1 + cur2 + add - 10;
                add = 1;
            } else {
                cur = cur1 + cur2 + add;
                add = 0;
            }
            ListNode curNode = new ListNode(cur);
            curNode.next = pre;
            pre = curNode;
        }
        while (!s1.empty()) {
            int cur1 = s1.pop(), cur = 0;
            if (cur1 + add >= 10) {
                cur = cur1 + add - 10;
                add = 1;
            } else {
                cur = cur1 + add;
                add = 0;
            }
            ListNode curNode = new ListNode(cur);
            curNode.next = pre;
            pre = curNode; 
        }
        while (!s2.empty()) {
            int cur2 = s2.pop(), cur = 0;
            if (cur2 + add >= 10) {
                cur = cur2 + add - 10;
                add = 1;
            } else {
                cur = cur2 + add;
                add = 0;
            }
            ListNode curNode = new ListNode(cur);
            curNode.next = pre;
            pre = curNode; 
        }
        if (add == 1) {
            ListNode curNode = new ListNode(1);
            curNode.next = pre;
            pre = curNode;
        }
        return pre;
    }
}