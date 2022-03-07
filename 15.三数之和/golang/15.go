import "sort"

func threeSum(nums []int) [][]int {
	sort.Ints(nums)
	res := [][]int{}
	for i := 0; i < len(nums)-2; i++ {
		n := nums[i]
		if n > 0 { //如果开始的最小都大于0，直接退出
			break
		}
		if i > 0 && nums[i] == nums[i-1] { //产生了重复
			continue
		}
		//此时我们已经选出了第一个数,其实下面的步骤和两数之和是一样的了
		l := i + 1
		r := len(nums) - 1
		for l < r {
			n1 := nums[l]
			n2 := nums[r]
			if n1+n2+n == 0 {
				res = append(res, []int{n1, n2, n})
				// 去重
				for l < r && nums[l] == n1 {
					l++
				}
				for l < r && nums[r] == n2 {
					r--
				}
			} else if n1+n2+n < 0 {
				l++
			} else {
				r--
			}
		}
	}
	return res
}
