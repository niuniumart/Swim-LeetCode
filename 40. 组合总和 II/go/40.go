package main

import (
	"sort"
)

var res [][]int
var dic map[int]bool

func combinationSum2(candidates []int, target int) [][]int {
	sort.Ints(candidates)
	res = make([][]int, 0)
	dic = make(map[int]bool, 0)
	var m []int = make([]int, 0)
	dfs(candidates, target, 0, m, 0)
	return res
}

func dfs(candidates []int, target int, index int, crt []int, sum int) {
	if sum == target {
		tmp := make([]int, len(crt))
		copy(tmp, crt)
		res = append(res, tmp)
		return
	}
	for i := index; i < len(candidates); i++ {
		if i > 0 && candidates[i] == candidates[i-1] && !dic[i-1] {
			continue
		}
		sum += candidates[i]
		crt = append(crt, candidates[i])
		dic[i] = true
		if !(sum > target && candidates[i] >= 0) {
			dfs(candidates, target, i+1, crt, sum)
		}
		crt = crt[:len(crt)-1]
		sum -= candidates[i]
		dic[i] = false
	}
}
