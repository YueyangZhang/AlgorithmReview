package SegregateOddEven;

public class Solution {
	public ListNode Segregate(ListNode head) {
		if (head == null) {
			return head;
		}
		
		ListNode last = head;
		while (last.next != null) {
			last = last.next;
		}
		
		ListNode now = last;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode previous = dummy;
		while (previous.next != last) {
			head = previous.next;
			if (head.val % 2 != 0) {
				previous.next = previous.next.next;
				now.next = head;
				now = now.next;
			} else {
				previous = previous.next;
			}
		}
		now.next = null;
		
		return dummy.next;
	}
}
