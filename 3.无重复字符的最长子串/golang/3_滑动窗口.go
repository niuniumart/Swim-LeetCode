func lengthOfLongestSubstring(s string) int {
	maxLength, crtLength, t := 0, 0, -1
	var dic = make(map[byte]int, 0)
	for i := 0; i < len(s); i++ {
		// 从之前达到的位置t继续
		for j := t + 1; j < len(s); j++ {
			pos, ok := dic[s[j]]
			// 出现了重复，达到了以i起步的最长，清理并跳出
			if ok && pos >= i {
				maxLength = max(maxLength, crtLength)
				// 到下个位置，所以要去掉位置i
				crtLength = crtLength - (pos - i + 1)
				t = j - 1
				i = pos
				break
			}
			// 没有重复，长度增加
			t = j
			crtLength++
			dic[s[j]] = j
		}
	}
	maxLength = max(maxLength, crtLength)
	return maxLength
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
