import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _15 {


    static class _1st {


        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> results = new ArrayList<>();
            //边界
            if (nums == null || nums.length < 3) return results;
            //对nums数组进行排序
            Arrays.sort(nums);
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                if (nums[i] > 0) break;//i作为基准数，如果大于0，后面的数都比这个数大，凑不成0
                if (i > 0 && nums[i] == nums[i - 1]) continue;//去重
                int l = i + 1, r = n - 1;//左右指针
                while (l < r) {
                    //三数之和
                    int sum = nums[i] + nums[l] + nums[r];
                    //找到符合的
                    if (sum == 0) {
                        results.add(Arrays.asList(nums[i], nums[l], nums[r]));
                        //跳过相等重复的，对于l r
                        while (l < r && nums[l + 1] == nums[l]) l++;
                        while (l < r && nums[r - 1] == nums[r]) r--;
                        l++;
                        r--;
                    } else if (sum < 0) l++;//结果小了 扩充双指针左区间
                    else if (sum > 0) r--;//结果大了 缩减双指针右区间
                }
            }
            return results;
        }
    }
}
