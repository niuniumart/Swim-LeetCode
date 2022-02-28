package main

//  Definition for singly-linked list.
type ListNode struct {
	Val  int
	Next *ListNode
}

func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
	var head = new(ListNode)
	crt := head
	var inherit int
	for {
		// 退出条件：l1，l2都用完了，且进位用完了
		if l1 == nil && l2 == nil && inherit == 0 {
			break
		}
		tmpVal := inherit
		if l1 != nil {
			tmpVal = tmpVal + l1.Val
			// l1 当前节点已使用完成，进入下个节点
			l1 = l1.Next
		}
		if l2 != nil {
			tmpVal = tmpVal + l2.Val
			// l2 当前节点已使用完成，进入下个节点
			l2 = l2.Next
		}
		inherit = tmpVal / 10
		var node = new(ListNode)
		node.Val = tmpVal % 10
		crt.Next = node
		crt = node
	}
	return head.Next
}

func main() {
}
