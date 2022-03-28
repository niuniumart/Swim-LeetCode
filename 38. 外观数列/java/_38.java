

/*import java.util.*;
import org.junit.Assert;*/
public class _38 {

    static class _1st {
        public static void main(String[] args) {
            _1st handler = new _1st();


        }

        public String countAndSay(int n) {
            String res = "1";
            for (int i = 2; i <= n; i++) {
                String cur = "";
                char[] ch = res.toCharArray();
                for (int j = 0; j < ch.length; ) {
                    int k = j + 1;
                    while (k < ch.length && ch[j] == ch[k]) k++;
                    int cnt = k - j;
                    cur += cnt + "" + ch[j];
                    j = k;
                }
                res = cur;
            }
            return res;
        }

    }

    static class _2nd {
        public static void main(String[] args) {
            _2nd handler = new _2nd();
        }

        public String countAndSay(int n) {
            String str = "1";
            for (int i = 2; i <= n; i++) {
                StringBuilder sb = new StringBuilder();
                char prev = str.charAt(0);
                int cnt = 1;
                for (int j = 1; j < str.length(); j++) {
                    char cur = str.charAt(j);
                    if (cur == prev) cnt++;
                    else {
                        sb.append(cnt).append(prev);
                        cnt = 1;
                        prev = cur;
                    }
                }
                sb.append(cnt).append(prev);
                str = sb.toString();
            }
            return str;
        }

    }


}
