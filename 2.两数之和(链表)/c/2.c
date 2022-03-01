/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */


struct ListNode* addTwoNumbers(struct ListNode* l1, struct ListNode* l2){
    struct ListNode* head = malloc(sizeof(struct ListNode));
    head->next = NULL;
    struct ListNode* crt = head;
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
        struct ListNode* node = malloc(sizeof(struct ListNode));
        node->val = tmpVal % 10;
        node->next = NULL;
        crt->next = node;
        crt = node;
    }
    return head->next;
}
