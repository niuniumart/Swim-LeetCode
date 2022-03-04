/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func removeNthFromEnd(head *ListNode, n int) *ListNode {
	var pre, right = head, head
	for i := 0; i < n+1; i++ {
		// 如果走不完n+1，那么说明n刚好等于链表的长度
		if right == nil {
			return head.Next
		}
		right = right.Next
	}
	for right != nil {
		pre = pre.Next
		right = right.Next
	}
	pre.Next = pre.Next.Next
	return head
}
