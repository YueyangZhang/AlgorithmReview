package ReverseHead;

public class Solution {
	public ListNode Reverse(ListNode head, int k) {
		if (head == null) {
			return null;
		}
		
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode pre = dummy;
		
		int count = 0;
		ListNode node = head;
		while (node != null) {
			count++;
			node = node.next;
		}
		
		int loops = count / k ;
		for (int i = 0; i < loops; i++) {
			for (int j = 1; j < k; j++) {
				pre.next = head.next;
				head.next = pre.next.next;
				pre.next.next = head;
				pre = pre.next;
			}
			
			pre = head;
			head = head.next;
		}
		
//		while (node != null) {
//			count++;
//			if (count % k == 0) {
//				ListNode first = pre.next;
//				ListNode temp = node.next;
//				pre.next = pre.next.next;
//				node.next = first;
//				first.next = temp;
//				
//				pre = first;
//				node = temp;
//			} else {
//				node = node.next;
//			}
//		}
		
		return dummy.next;
	}
}
