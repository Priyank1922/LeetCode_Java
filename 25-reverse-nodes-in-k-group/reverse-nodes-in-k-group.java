class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        // Step 1: check if there are at least k nodes
        ListNode node = head;
        int count = 0;
        while (node != null && count < k) {
            node = node.next;
            count++;
        }
        
        // If less than k nodes, return head as it is
        if (count < k) return head;
        
        // Step 2: reverse first k nodes
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        int i = 0;
        while (i < k && curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            i++;
        }
        
        // Step 3: connect recursion for remaining list
        head.next = reverseKGroup(curr, k);
        
        // prev is new head of this reversed group
        return prev;
    }
}
