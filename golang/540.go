func singleNonDuplicate(nums []int) int {
	left, right := 0, len(nums)-1
	for left < right {
		mid := left + (right-left)/2
		// æ°æ®æ¯æå¯¹çï¼æä»¬æ¯æ¬¡midåå¶æ°ä½ç½®
		if mid%2 == 1 {
			mid = mid - 1
		}
		// æ»¡è¶³ç¹æ®æ°å­åºç°åè§å¾ï¼åå³å¯»æ¾
		if nums[mid] == nums[mid+1] {
			// å 2æ¯ç±äºæ°å­æå¯¹åºç°
			left = mid + 2
		} else {
			// å¦æè§å¾æ¹åï¼å°±åå·¦å¯»æ¾
			right = mid
		}
	}
	return nums[left]
}
