import "sort"

func threeSumClosest(nums []int, target int) int {
	sort.Ints(nums)
	// 初始值为前三个数的和
	crtSum := nums[0] + nums[1] + nums[2]
	crtAbs := abs(crtSum - target)
	for i := 0; i < len(nums); i++ {
		left := i + 1
		right := len(nums) - 1
		// 剩下两个位置通过双指针
		for left < right {
			sum := nums[left] + nums[right] + nums[i]
			// 刚好相等，直接返回
			if sum == target {
				return sum
			} else if sum > target {
				right--
			} else {
				left++
			}
			// 更新当前最新的最小差值
			tmpAbs := abs(sum - target)
			if tmpAbs < crtAbs {
				crtSum = sum
				crtAbs = tmpAbs
			}
		}
	}
	return crtSum
}

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}

func abs(a int) int {
	if a < 0 {
		return -a
	}
	return a
} 
