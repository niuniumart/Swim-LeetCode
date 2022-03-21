import "sort"

func fourSum(nums []int, target int) [][]int {
	sort.Ints(nums)
	length := len(nums)
	res := make([][]int, 0)
	// 第一个数字
	for i := 0; i < length-3; i++ {
		// 一定大于目标，后续不必操作
		if nums[i] > target && nums[i] >= 0 {
			return res
		}
		// 第一个数字去重
		if i > 0 && nums[i] == nums[i-1] {
			continue
		}
		for j := i + 1; j < length-2; j++ {
			// 第二个数字去重
			if j > i+1 && nums[j-1] == nums[j] {
				continue
			}
			// 如果当前已大于目标，后续还会增大，不用继续寻找
			if (nums[i]+nums[j] > target) && (nums[j] >= 0) {
				break
			}
			left := j + 1
			right := length - 1
			// 双指针向中间碰头
			for left < right {
				sum := nums[i] + nums[j] + nums[left] + nums[right]
				if sum == target {
					res = append(res, []int{nums[i], nums[j],
						nums[left], nums[right]})
					left++
					for left < right && nums[left] == nums[left-1] {
						left++
					}
				} else if sum < target {
					left++
				} else {
					right--
				}
			}
		}
	}
	return res
}
