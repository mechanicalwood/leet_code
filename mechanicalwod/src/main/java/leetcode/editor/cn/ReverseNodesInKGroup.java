package leetcode.editor.cn;

//给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。 
//
// k 是一个正整数，它的值小于或等于链表的长度。 
//
// 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。 
//
// 进阶： 
//
// 
// 你可以设计一个只使用常数额外空间的算法来解决此问题吗？ 
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], k = 2
//输出：[2,1,4,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,2,3,4,5], k = 3
//输出：[3,2,1,4,5]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2,3,4,5], k = 1
//输出：[1,2,3,4,5]
// 
//
// 示例 4： 
//
// 
//输入：head = [1], k = 1
//输出：[1]
// 
//
// 
// 
//
// 提示： 
//
// 
// 列表中节点的数量在范围 sz 内 
// 1 <= sz <= 5000 
// 0 <= Node.val <= 1000 
// 1 <= k <= sz 
// 
// Related Topics 递归 链表 
// 👍 1391 👎 0

public class ReverseNodesInKGroup{
    public static void main(String[] args) {
        Solution solution = new ReverseNodesInKGroup().new Solution();
        ListNode listNode01 = new ListNode(1);
        ListNode listNode02 = new ListNode(2);
        ListNode listNode03 = new ListNode(3);
        ListNode listNode04 = new ListNode(4);
        ListNode listNode05 = new ListNode(5);
        listNode01.next = listNode02;
        listNode02.next = listNode03;
        listNode03.next = listNode04;
        listNode04.next = listNode05;
        ListNode result = solution.reverseKGroup(listNode01, 2);
        System.out.println(result);
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (null == head || null == head.next || k == 0 || k == 1) {
            return head;
        }
        ListNode tempHead = head;
        ListNode cur = head;
        int step = k;
        while (null != cur && null != cur.next) {
            cur = cur.next;
            step--;
            if (step == 1) {
                // 反转tempHead至cur此段链表
                ListNode curNext = cur.next;
                head = reverseLinkedList(head, tempHead, curNext);
                cur = curNext;
                tempHead = curNext;
                step = k;
            }
        }
        return head;
    }

    private ListNode reverseLinkedList(ListNode head, ListNode tempHead, ListNode tempEnd) {
        ListNode temp = head;
        while (null != temp && temp != tempHead) {
            temp = temp.next;
        }
        // 单链表反转逻辑
        ListNode prev = tempEnd;
        ListNode cur = temp;
        ListNode next = temp.next;
        while (cur != tempEnd) {
            cur.next = prev;
            prev = cur;
            cur = next;
            if (null != next) {
                next = next.next;
            }
        }
        // 接上前面已经反转过的链表
        if (head != tempHead) {
            temp = head;
            while (temp.next != tempHead) {
                temp = temp.next;
            }
            temp.next = prev;
            return head;
        }
        return prev;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}