

/*import java.util.*;
import org.junit.Assert;*/
public class _Model {

    static class _1st {
        public static void main(String[] args) {
            _1st handler = new _1st();


        }

   /*
        #### 方法1:暴力递归

- `helper(String s, int start, int end)`
                - 表示`s`从`start`到`end`位置，是否有回文子串

- `base case`:
                - `start == end` : 相等时，说明只有一个字符了，返回`T`
                - `start +1== end`  ：两个字符的时候，比较两个字符是否相等
    */

        public String longestPalindrome(String s) {
            String ans = "";
            for (int i = 0; i < s.length(); i++) {
                for (int j = i; j < s.length(); j++) {
                    if (helper(s, i, j) && j - i + 1 > ans.length()) {
                        ans = s.substring(i, j + 1);
                    }
                }
            }
            return ans;
        }


        private boolean helper(String s, int start, int end) {
            if (start == end) return true;
            if (start + 1 == end) return s.charAt(start) == s.charAt(end);
            boolean ans = false;
            if (s.charAt(start) == s.charAt(end)) {
                ans = helper(s, start + 1, end - 1);
            }
            return ans;
        }


    }

    static class _2nd {


        public static void main(String[] args) {
            _2nd handler = new _2nd();
        }

        /*

        #### 方法2:自顶向下记忆化递归(Top-down)

> 脱胎与方法1，添加记忆化

         */
        Boolean[][] memo;

        public String longestPalindrome(String s) {
            memo = new Boolean[s.length()][s.length()];
            String ans = "";
            for (int i = 0; i < s.length(); i++) {
                for (int j = i; j < s.length(); j++) {
                    if (helper(s, i, j) && j - i + 1 > ans.length()) {
                        ans = s.substring(i, j + 1);
                    }
                }
            }
            return ans;
        }


        private boolean helper(String s, int start, int end) {
            if (start == end) return true;
            if (start + 1 == end) return s.charAt(start) == s.charAt(end);
            if (memo[start][end] != null) return memo[start][end];
            boolean ans = false;
            if (s.charAt(start) == s.charAt(end)) {
                ans = helper(s, start + 1, end - 1);
            }
            return memo[start][end] = ans;
        }
    }


    static class _3rd {
        public static void main(String[] args) {
            _3rd handler = new _3rd();
        }


/*
        #### 方法3:自底向上填表递归(Bottom-up)

- 其中`f[i][j]`表示`s`中，从`i`到`j`是否有回文子串
- `k`为遍历的字符长度，可以为`n`
                - 此时`i=0`,`j=i+k-1=0+n-1=n-1`

                - 条件为当前字符`[i]==[j]`的时候，要么只有两个字符，要么砍头去尾，有回文子串
 */

        public String longestPalindrome(String s) {
            if (s == null || s.length() == 0) return "";
            int n = s.length();
            boolean[][] f = new boolean[n][n];
            for (int i = 0; i < n; ++i) f[i][i] = true;
            int maxLen = 1, start = 0;
            for (int k = 2; k <= n; k++) {
                // System.out.printf("k:%d\n", k);
                for (int i = 0; i < n - k + 1; i++) {
                    int j = i + k - 1;
                    // System.out.printf("i:%d,j:%d\n", i, j);
                    if (s.charAt(i) == s.charAt(j) && (k == 2 || f[i + 1][j - 1])) {
                        f[i][j] = true;
                        if (maxLen < k) {
                            maxLen = k;
                            start = i;
                        }
                    }
                }
            }
            return s.substring(start, start + maxLen);
        }

/*
        另外一种写法

- `k`为遍历的字符长度，可以为`n` 即当`i=0`的时候
 */

        public String longestPalindrome2(String s) {
            if (s == null || s.length() <= 0) return s;
            int n = s.length();
            boolean[][] f = new boolean[n][n];
            for (int i = 0; i < n; i++) f[i][i] = true;
            int maxLen = 1, start = 0;
            for (int i = n - 1; i >= 0; i--) {
                for (int k = 1; k < n - i; k++) {
                    int j = k + i;
                    if (s.charAt(i) == s.charAt(j)) {
                        f[i][j] = (k == 1) || f[i + 1][j - 1];
                    }
                    if (f[i][j] && j - i + 1 > maxLen) {
                        maxLen = j - i + 1;
                        start = i;
                    }
                }
            }
            return s.substring(start, start + maxLen);
        }

//        另外一种写法

        public String longestPalindrome3(String s) {
            int n = s.length();
            //f[j][i] 表示 s[j...i]这个区间的子串是否是回文，true是回文 false不是回文
            boolean[][] f = new boolean[n][n];
            int maxx = 0;//最长的回文子串的长度
            String res = "";//结果
            for (int i = 0; i < n; i++) {//枚举右区间
                for (int j = 0; j <= i; j++) {//枚举左区间，界限是右区间
                    //s[i] == s[j]时，且去掉头尾的字符串是回文子串，当前s[j...i]也是回文子串
                    if (s.charAt(i) == s.charAt(j) && (i - j <= 2 || f[j + 1][i - 1])) {
                        f[j][i] = true;
                    }
                    //更新长度s[0..2]长度是3 2-0+1=3
                    if (f[j][i] && maxx < i - j + 1) {
                        maxx = i - j + 1;
                        res = s.substring(j, i + 1);
                    }
                }
            }
            return res;
        }


    }

    static class _4th {
        public static void main(String[] args) {
            _4th handler = new _4th();
        }

        public String longestPalindrome(String s) {
            if (s == null || s.length() == 0) {
                return "";
            }
            int n = s.length();
            int start = 0, end = 0;
            for (int i = 0; i < n; i++) {
                //获取到当前点i 的奇回文和偶回文的最大长度
                int len1 = expandBySeed(s, i, i);
                int len2 = expandBySeed(s, i, i + 1);
                //取最大长度，然后扩展
                int len = Math.max(len1, len2);
                if (len > (end - start)) {
                    start = i - (len - 1) / 2;
                    end = i + len / 2;
                }
            }
            return s.substring(start, end + 1);
        }


        /**
         * 由中心往两边扩散，返回满足最大回文的长度
         *
         * @param s
         * @param start
         * @param end
         * @return
         */
        private int expandBySeed(String s, int start, int end) {
            int n = s.length();
            while (start >= 0 && end < n && s.charAt(start) == s.charAt(end)) {
                start--;
                end++;
            }
            return end - start - 1;
        }
    }

    static class _5th {
        /*
        #### 方法5:Manacher算法

        > 本动态规划的文章着重讲动态规划，涉及马拉车算法的内容不详细展开，下面的代码取自weiwei大佬的[题解](https://leetcode-cn.com/problems/longest-palindromic-substring/solution/zhong-xin-kuo-san-dong-tai-gui-hua-by-liweiwei1419/)

         */
        public class Solution {

            public String longestPalindrome(String s) {
                // 特判
                int len = s.length();
                if (len < 2) {
                    return s;
                }

                // 得到预处理字符串
                String str = addBoundaries(s, '#');
                // 新字符串的长度
                int sLen = 2 * len + 1;

                // 数组 p 记录了扫描过的回文子串的信息
                int[] p = new int[sLen];

                // 双指针，它们是一一对应的，须同时更新
                int maxRight = 0;
                int center = 0;

                // 当前遍历的中心最大扩散步数，其值等于原始字符串的最长回文子串的长度
                int maxLen = 1;
                // 原始字符串的最长回文子串的起始位置，与 maxLen 必须同时更新
                int start = 0;

                for (int i = 0; i < sLen; i++) {
                    if (i < maxRight) {
                        int mirror = 2 * center - i;
                        // 这一行代码是 Manacher 算法的关键所在，要结合图形来理解
                        p[i] = Math.min(maxRight - i, p[mirror]);
                    }

                    // 下一次尝试扩散的左右起点，能扩散的步数直接加到 p[i] 中
                    int left = i - (1 + p[i]);
                    int right = i + (1 + p[i]);

                    // left >= 0 && right < sLen 保证不越界
                    // str.charAt(left) == str.charAt(right) 表示可以扩散 1 次
                    while (left >= 0 && right < sLen && str.charAt(left) == str.charAt(right)) {
                        p[i]++;
                        left--;
                        right++;

                    }
                    // 根据 maxRight 的定义，它是遍历过的 i 的 i + p[i] 的最大者
                    // 如果 maxRight 的值越大，进入上面 i < maxRight 的判断的可能性就越大，这样就可以重复利用之前判断过的回文信息了
                    if (i + p[i] > maxRight) {
                        // maxRight 和 center 需要同时更新
                        maxRight = i + p[i];
                        center = i;
                    }
                    if (p[i] > maxLen) {
                        // 记录最长回文子串的长度和相应它在原始字符串中的起点
                        maxLen = p[i];
                        start = (i - maxLen) / 2;
                    }
                }
                return s.substring(start, start + maxLen);
            }


            /**
             * 创建预处理字符串
             *
             * @param s      原始字符串
             * @param divide 分隔字符
             * @return 使用分隔字符处理以后得到的字符串
             */
            private String addBoundaries(String s, char divide) {
                int len = s.length();
                if (len == 0) {
                    return "";
                }
                if (s.indexOf(divide) != -1) {
                    throw new IllegalArgumentException("参数错误，您传递的分割字符，在输入字符串中存在！");
                }
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i < len; i++) {
                    stringBuilder.append(divide);
                    stringBuilder.append(s.charAt(i));
                }
                stringBuilder.append(divide);
                return stringBuilder.toString();
            }
        }

//        作者：liweiwei1419
//        链接：https://leetcode-cn.com/problems/longest-palindromic-substring/solution/zhong-xin-kuo-san-dong-tai-gui-hua-by-liweiwei1419/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


    }
}
