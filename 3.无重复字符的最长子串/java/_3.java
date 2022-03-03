import java.util.HashSet;
import java.util.Set;

public class _3 {
    static class _1st {

        public static void main(String[] args) {
            _1st handler = new _1st();

        }

        /**
         * 借助set控制滑窗
         *
         * @param s
         * @return
         */
        public int lengthOfLongestSubstring(String s) {
            Set<Character> set = new HashSet<>();
            int maxLen = 0;//最大长度
            int i = 0, j = 0;//滑窗
            while (i < s.length() && j < s.length()) {
                //滑窗右区间j还可以外扩（不在set集合内，说明该字符满足非重复字符的条件）
                if (!set.contains(s.charAt(j))) {
                    set.add(s.charAt(j++));//右移滑窗
                    maxLen = Math.max(maxLen, j - i);//更新滑窗大小
                } else {
                    //一直移动到不出现s.charAt(j)字符为止
                    set.remove(s.charAt(i++));
                }
            }
            return maxLen;
        }
    }

    static class _2nd {
        public static void main(String[] args) {
            _2nd handler = new _2nd();

        }

        public int lengthOfLongestSubstring(String s) {
            int n = s.length(), l = 0, r = 0;
            //数组控制滑窗,arr记录的当前字符从右往左看，第一次出现的位置（下标索引）
            int[] arr = new int[128];
            int maxLen = 0;
            while (r < n) {
                //窗口左边界出现位置（从右往左看，第一次出现该字符的位置）
                l = Math.max(l, arr[s.charAt(r)]);
                //更新窗口的大小
                maxLen = Math.max(maxLen, r - l + 1);
                //滑窗右边界进来时，不断更新/覆盖滑窗右边界字符的位置
                arr[s.charAt(r)] = 1 + r;
                r++;
            }
            return maxLen;
        }
    }
}
