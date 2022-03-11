

/*import java.util.*;
import org.junit.Assert;*/
public class _Model {

    static class _1st {
        public static void main(String[] args) {
            _1st handler = new _1st();


        }

        List<List<Integer>> resList = new ArrayList<>();

        public List<List<Integer>> permute(int[] nums) {

            if (nums == null || nums.length == 0) return resList;
            List<Integer> levelList = new ArrayList<>();
            int n = nums.length;
            for (int num : nums) levelList.add(num);
            backtrace(levelList, n, 0);
            return resList;
        }

        /**
         * @param levelList 当前的结果列表
         * @param n         nums的length
         * @param index     当前处理到idx
         */
        private void backtrace(List<Integer> levelList, int n, int index) {
            if (index == n) {
                resList.add(new ArrayList<>(levelList));
                return;
            }
            for (int i = index; i < n; i++) {
                Collections.swap(levelList, index, i);
                backtrace(levelList, n, index + 1);
                Collections.swap(levelList, index, i);
            }
        }
    }


}


}
