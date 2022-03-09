/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func swapPairs(head *ListNode) *ListNode {
	if head == nil || head.Next == nil {
		return head
	}
	left := head
	right := head.Next
	// 新的头节点一定从第二个位置开始
	head = right
	var pre *ListNode
	for {
		// 左节点指向right下一个位置
		left.Next = right.Next
		// 右节点指向左节点
		right.Next = left
		// pre从第一轮之后才有值
		if pre != nil {
			pre.Next = right
		}
		// pre等于本次右边的节点
		pre = left
		left = left.Next
		if left == nil || left.Next == nil {
			return head
		}
		right = left.Next
	}
	return head
}
