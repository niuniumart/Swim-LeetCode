package main

import "fmt"

func main() {
	height := []int{1, 8, 6, 2, 5, 4, 8, 3, 7}
	sum := maxArea(height)
	fmt.Printf("max area: %d\n", sum)
}

func maxArea(height []int) int {
	sum, left, right := 0, 0, len(height)-1
	for left < right {
		tmpSum := min((height[left]), height[right]) * (right - left)
		sum = max(sum, tmpSum)
		if height[left] < height[right] {
			left = left + 1
		} else {
			right = right - 1
		}
	}
	return sum
}

func max(x, y int) int {
	if x < y {
		return y
	}
	return x
}

func min(x, y int) int {
	if x > y {
		return y
	}
	return x
}
