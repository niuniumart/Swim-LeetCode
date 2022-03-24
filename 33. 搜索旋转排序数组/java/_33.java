

/*import java.util.*;
import org.junit.Assert;*/
public class _33 {

    static class _1st {
        public static void main(String[] args) {
            _1st handler = new _1st();


        }

        public int search(int[] nums, int target) {
            int n = nums.length, l = 0, r = n - 1;
            while (l < r) {
                int m = l + (r - l) / 2;//下取整
                if (nums[m] == target) return m;
                else if (nums[m] >= nums[l]) {//与左端点比较后再与target值比较
                    if (target >= nums[l] && target <= nums[m]) {
                        r = m;
                    } else {
                        l = m + 1;
                    }
                } else if (nums[m] < nums[l]) {
                    if (target > nums[m] && target <= nums[r]) {
                        l = m + 1;
                    } else {
                        r = m;
                    }
                }
            }
            return nums[l] == target ? l : -1;
        }

    }


}
