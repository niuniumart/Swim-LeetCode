

import java.util.*;

//import org.junit.Assert;
public class _7 {

    static class _1st {
        public static void main(String[] args) {
            _1st handler = new _1st();
//            System.out.printf("%d\n%d", Integer.MAX_VALUE, Integer.MIN_VALUE);
            System.out.println(handler.reverse(Integer.MAX_VALUE));//0
        }

        /**
         * @param x
         * @return res
         * MAX : 2147483647
         * MIN :-2147483648
         * <p>
         * 题目中有「假设环境不允许存储 64 位整数（有符号或无符号）。」的要求，因此代码中不不能有long类型
         * 对于MAX：
         * 情况1：拿掉最末位的数 2147483647->214748364
         * 假如当前的res为214748365 如果再加上一位比如说1
         * 214748365 -> 2147483651 这是大于MAX的，会导致溢出，提前退出
         * 情况2：拿掉最末位的数 2147483647->214748364
         * 假如当前的res为214748364，则需要判断紧接着的一位数是否比MAX的最末尾7数字大，如果大，就会溢出
         * 对于MIN：
         * 有情况1和情况2两种情况
         */

        public int reverse(int x) {
            int res = 0;
            while (x != 0) {
                //取当前数的最末位数
                int t = x % 10;
                //判断是否溢出
                if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && t > 7)) {
                    return 0;
                }
                if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && t < -8)) {
                    return 0;
                }
                //组装res，消掉x的最末位
                res = res * 10 + t;
                x /= 10;
            }
            return res;
        }

    }

    static class _2nd {
        public static void main(String[] args) {
            _2nd handler = new _2nd();
        }

        /**
         * 使用了long类型，不符合题意
         *
         * @param x
         * @return
         */
        public int reverse(int x) {
            //控制正反数
            int sign = 1;
            if (x < 0) {
                sign = -1;
                x = -x;
            }
            long res = 0;
            while (x > 0) {
                res = res * 10 + x % 10;
                x /= 10;
                //如果发生溢出，提前结束
                if (res >= Integer.MAX_VALUE) return 0;
            }
            return (int) res * sign;
        }
    }

}
