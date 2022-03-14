

/*import java.util.*;
import org.junit.Assert;*/
public class _Model {

    static class _1st {
        public static void main(String[] args) {
            _1st handler = new _1st();


        }

        int N;
        Integer[] memo;//返回当前位置索引curr跳到最后位置的最小步数

        public int jump(int[] nums) {
            N = nums.length;
            memo = new Integer[N];
            return helper(nums, 0);
        }

        /**
         * 返回当前位置索引curr跳到最后位置的最小步数
         *
         * @param nums 数组
         * @param curr 当前所处的位置
         * @return
         */
        public int helper(int[] nums, int curr) {
            //当curr跳到末尾或者跳过末尾的时候，递归结束
            if (curr >= N - 1) return 0;
            if (memo[curr] != null) return memo[curr];
            int ans = Integer.MAX_VALUE / 2;
            //对于当前的curr索引，最多可以跳nums[curr]步，最少我们从1开始起跳，0没有意义，出去了
            for (int i = 1; i <= nums[curr]; i++) {
                //当前的索引是curr，可以跳i步，到i+curr ，每做一次，就跳了一次
                ans = Math.min(ans, helper(nums, i + curr) + 1);
            }
            return memo[curr] = ans;
        }

    }

    static class _2nd {
        public static void main(String[] args) {
            _2nd handler = new _2nd();
        }

        public int jump(int[] nums) {
            int N = nums.length, INF = Integer.MAX_VALUE / 2;
            int[] f = new int[N];
            //初始化
            f[0] = 0;
            for (int i = 1; i < N; i++) {
                f[i] = INF;//初始化一个最大值
                //从j跳到i，如果j 加上 j能跳的步数 nums[j] 比i位置还要远
                //min{f[i],j跳步的位置这个位置之前花了f[j]+这一步}
                for (int j = 0; j < i; j++) {
                    if (j + nums[j] >= i) f[i] = Math.min(f[i], f[j] + 1);
                }
            }
            return f[N - 1];
        }
    }


    static class _3rd {
        public static void main(String[] args) {
            _3rd handler = new _3rd();
        }
    }

    static class _4th {
        public static void main(String[] args) {
            _4th handler = new _4th();
        }
    }
}
