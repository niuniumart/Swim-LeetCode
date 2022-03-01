class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int sum = 0;
        while (left < right) {
            int tmpSum = Math.min(height[left], height[right]) * (right - left);
            sum = Math.max(sum, tmpSum);
            if (height[left] < height[right]) {
                left = left + 1;
            } else {
                right = right - 1;
            }
        } 
        return sum;
    }
}
