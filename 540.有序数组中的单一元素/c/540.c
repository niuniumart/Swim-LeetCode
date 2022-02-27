int singleNonDuplicate(int* nums, int numsSize){
    int left = 0;
    int right = numsSize - 1;
    while (left < right) {
    	// 数据是成对的，我们每次mid取偶数位置
        int mid = (left + right) / 2;
        if (mid % 2 == 1) {
            mid = mid - 1;
        }
	// 满足特殊数字出现前规律，向右寻找
        if (nums[mid] == nums[mid+1]) {
            left = mid + 2;
        } else {
            right = mid;
        }
    }
    return nums[left];
}
