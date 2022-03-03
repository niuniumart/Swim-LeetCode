import "math"

func reverse(x int) int {
	var res int
	for x != 0 {
		num := x % 10
		// 负数是越来越小，所以一旦低于阈值，后面就只会更小
		// 正数是越来越大，所以一旦超过阈值，也无可挽回
		if res < math.MinInt32/10 || res > math.MaxInt32/10 {
			return 0
		}
		// 和阈值/10相同时候，比较最后一位，避免越界
		if (res == math.MinInt32 &&
			num < math.MinInt32%10) ||
			(res == math.MaxInt32/10 &&
				num > math.MaxInt32/10) {
			return 0
		}
		x = x / 10
		res = res*10 + num
	}
	return res
}
