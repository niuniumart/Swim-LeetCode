

/*import java.util.*;
import org.junit.Assert;*/
public class _34 {

    static class _1st {
        public static void main(String[] args) {
            _1st handler = new _1st();


        }

        public int[] searchRange(int[] nums, int target) {
            int[] res = new int[]{-1, -1};
            if (nums == null || nums.length == 0) return res;
            int n = nums.length;
            int l = 0, r = n - 1;
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (nums[mid] < target) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            if (nums[l] == target) res[0] = l;

            l = 0;
            r = n - 1;
            while (l < r) {
                int mid = l + (r - l + 1) / 2;
                if (nums[mid] > target) {
                    r = mid - 1;
                } else {
                    l = mid;
                }
            }
            if (nums[l] == target) res[1] = l;
            return res;
        }
    }


}
