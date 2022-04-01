

import java.util.*;
public class _71 {

    static class _1st {
        public static void main(String[] args) {
            _1st handler = new _1st();


        }


        public String simplifyPath(String path) {
            // 双端队列
            Deque<String> queue = new LinkedList<>();
            // 分割字符
            String[] res = path.split("/");
            for (int i = 0; i < res.length; i++) {
                String s = res[i];
                // . 和 空 跳过
                if (s.equals(".") || s.equals("")) continue;
                    //返回上一级目录
                else if (s.equals("..")) {
                    if (!queue.isEmpty()) {
                        queue.pollLast();
                    }
                } else {//入栈
                    queue.offer(s);
                }
            }
            // 拼接
            StringBuilder sb = new StringBuilder("/");
            while (!queue.isEmpty()) {
                sb.append(queue.poll());
                if (!queue.isEmpty()) {
                    sb.append("/");
                }
            }
            // 判空
            return sb.toString().equals("") ? "/" : sb.toString();
        }


    }

}
