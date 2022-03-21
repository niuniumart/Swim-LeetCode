
import "sort"

var res [][]int
var dic map[int]bool

func combinationSum(candidates []int, target int) [][]int {
	res = make([][]int, 0)
	dic = make(map[int]bool, 0)
	sort.Ints(candidates)
	dfs(candidates, target, []int{}, 0, 0)
	return res
}

func dfs(candidates []int, target int, crt []int, index int, sum int) {
	if sum == target {
		tmp := make([]int, len(crt))
		copy(tmp, crt)
		res = append(res, tmp)
		return
	}
	// 当前层次，每个数字都过一遍
	for i := index; i < len(candidates); i++ {
		sum = sum + candidates[i]
		crt = append(crt, candidates[i])
		if !(sum > target && candidates[i] > 0) {
			// 如果还可以继续用i，那就继续
			if sum+candidates[i] <= target {
				dfs(candidates, target, crt, i, sum)
			} else {
				// 否则选择下一个数字
				dfs(candidates, target, crt, i+1, sum)
			}
		}
		crt = crt[:len(crt)-1]
		sum = sum - candidates[i]
	}
}
