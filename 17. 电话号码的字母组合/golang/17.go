var res []string

func letterCombinations(digits string) []string {
	var numDic map[string]string = map[string]string{
		"2": "abc",
		"3": "def",
		"4": "ghi",
		"5": "jkl",
		"6": "mno",
		"7": "pqrs",
		"8": "tuv",
		"9": "wxyz",
	}
	res = make([]string, 0)
	length := len(digits)
	dfs(numDic, digits, length, 0, "")
	return res

}

func dfs(numDic map[string]string, digits string,
	length, index int, pre string) {
	if index >= length {
		if pre != "" {
			res = append(res, pre)
		}
		return
	}
	digit := string(digits[index])
	letters := numDic[digit]
	for i := 0; i < len(letters); i++ {
		letter := letters[i]
		dfs(numDic, digits, length, index+1, pre+string(letter))
	}
	return
}
