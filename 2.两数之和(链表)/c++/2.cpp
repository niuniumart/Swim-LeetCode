/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        ListNode* head = new(ListNode);
        head->next = NULL;
        ListNode* crt = head;
        int inherit = 0;
        while(true) {
            if (l1 == NULL && l2 == NULL && inherit == 0) {
                break;
            }
            int tmpVal = inherit;
            if (l1 != NULL) {
                tmpVal = tmpVal + l1->val;
                l1 = l1->next;
            }
            if (l2 != NULL) {
                tmpVal = tmpVal + l2->val;
                l2 = l2->next;
            }
            inherit = tmpVal / 10;
            ListNode* node = new(ListNode);
            node->val = tmpVal % 10;
            node->next = NULL;
            crt->next = node;
            crt = node;
        }
        return head->next;
    }
};
