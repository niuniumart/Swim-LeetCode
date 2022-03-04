import struct.ListNode;

/*import java.util.*;
import org.junit.Assert;*/
public class _19 {

    static class _1st {
        public static void main(String[] args) {
            _1st handler = new _1st();
        }

        /**
         *
         * @param head
         * @param n
         * @return ListNode
         * 「双指针之快慢指针」
         *
         */
        public ListNode removeNthFromEnd(ListNode head, int n) {
            //做一个哑结点，方便最后放回头节点
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            //两个指针：slow 慢指针 fast :快指针
            ListNode slow = dummy, fast = dummy;
            //因为fast从dummy节点出发的，所以走了n+1步
            for (int i = 0; i <= n; i++) fast = fast.next;
            //同时移动快慢指针，两个指针步调一致
            while (fast != null) {
                slow = slow.next;
                fast = fast.next;
            }
            //这时候slow指针停靠的位置是「待删除节点」「前一个」节点
            /**
             * 例如：
             * [1,2,3,4,5]
             * n=2
             * 要删除的节点是倒数第2个节点「4」
             * 到这一步，slow停在「3」节点，slow.next =slow.next.next表示将「3」节点的下一个节点指向「3」节点下下个节点也就是「5」节点，达到删除目标节点「4」的目的
             */
            slow.next = slow.next.next;
            return dummy.next;
        }

    }


}
