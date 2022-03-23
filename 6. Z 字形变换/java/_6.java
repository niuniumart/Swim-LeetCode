

/*import java.util.*;
import org.junit.Assert;*/
public class _Model {

    static class _1st {
        public static void main(String[] args) {
            _1st handler = new _1st();


        }
        public String convert(String s, int numRows) {
            //r表示每一行的索引 [0,numRows-1]
            //flag是 1 或者 -1 按从上到下或者从下到上 两个方向区分正负
            int r = 0, flag = 1;
            //结果列表
            StringBuilder[] sb = new StringBuilder[numRows];
            for (int k = 0; k < numRows; k++) sb[k] = new StringBuilder();
            int i = 0;
            while (i < s.length()) {
                if (r == numRows) {
                    flag = -flag;
                    //区分nowrows 是否为1
                    if (numRows == 1) r -= 1;
                    else r -= 2;
                } else if (r == -1) {
                    flag = -flag;
                    if(numRows == 1) r+=1;
                    else r+=2;
                }

                sb[r].append(s.charAt(i++));
                r += flag;
            }
            StringBuilder ans = new StringBuilder();
            for (int k = 0; k < numRows; k++) ans.append(sb[k]);
            return ans.toString();
        }

    }

}
