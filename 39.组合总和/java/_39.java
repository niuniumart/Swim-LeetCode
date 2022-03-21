

/*import java.util.*;
import org.junit.Assert;*/
public class _Model {

    static class _1st {
        public static void main(String[] args) {
            _1st handler = new _1st();


        }

        //递减
        List<List<Integer>> res = new ArrayList<>();


        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            Arrays.sort(candidates);
            dfs(candidates, target, 0, new ArrayList<>());
            return res;
        }


        private void dfs(int[] nums, int target, int idx, List<Integer> sub) {
            if (target < 0) return;
            if (target == 0) {
                res.add(new ArrayList<>(sub));
                return;
            }

            for (int i = idx; i < nums.length; i++) {
                sub.add(nums[i]);
                dfs(nums, target - nums[i], i, sub);
                sub.remove(sub.size() - 1);
            }
        }


    }

    static class _2nd {
        public static void main(String[] args) {
            _2nd handler = new _2nd();
        }

        //累加
        List<List<Integer>> res = new ArrayList<>();
        int target;

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            Arrays.sort(candidates);
            this.target = target;
            dfs(candidates, 0, 0, new ArrayList<>());
            return res;
        }


        private void dfs(int[] nums, int sum, int idx, List<Integer> sub) {
            if (sum > this.target) return;
            if (sum == this.target) {
                res.add(new ArrayList<>(sub));
                return;
            }

            for (int i = idx; i < nums.length; i++) {
                sub.add(nums[i]);
                dfs(nums, sum + nums[i], i, sub);
                sub.remove(sub.size() - 1);
            }
        }}



}
