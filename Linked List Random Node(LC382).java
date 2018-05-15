/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    ListNode h;
    int len = 0;
    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        h = head;
        ListNode temp = head;
        while (temp != null) {
            len++;
            temp = temp.next;
        }
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        ListNode temp = h;
        Random r = new Random();
        int random = r.nextInt(len);
        for (int i = 0; i < random; i++) {
            temp = temp.next;
        }
        return temp.val;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */