func singleNonDuplicate(nums []int) int {
	left, right := 0, len(nums)-1
	for left < right {
		mid := left + (right-left) / 2
		// 数据是成对的，我们每次mid取偶数位置
		if mid % 2 == 1 {
			mid = mid - 1
		}
		// 满足特殊数字出现前规律，向右寻找
		if nums[mid] == nums[mid+1] {
			// 加2是由于数字成对出现
			left = mid + 2
		} else {
			// 如果规律改变，就向左寻找
			right = mid
		}
	}
	return nums[left]
}


