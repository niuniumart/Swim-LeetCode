

/*import java.util.*;
import org.junit.Assert;*/
public class _Model {

    static class _1st {
        public static void main(String[] args) {
            _1st handler = new _1st();


        }

        /*
         *
         *
            dummy->   1  ->  2   ->  3   ->  4
              prev  first second    nxt
            step1:second.next = first;
            step2:first.next = nxt;
            step3:prev.next = second;
         */
        public ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null) return head;
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            ListNode prev = dummy;
            while (prev.next != null && prev.next.next != null) {
                ListNode first = prev.next;
                ListNode second = prev.next.next;
                ListNode nxt = second.next;
                //step1
                second.next = first;
                //step2
                first.next = nxt;
                //step3
                prev.next = second;
                prev = first;
            }
            return dummy.next;
        }

    }


}
