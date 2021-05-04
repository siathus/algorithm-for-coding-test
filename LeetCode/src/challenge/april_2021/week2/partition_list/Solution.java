package challenge.april_2021.week2.partition_list;

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
    public ListNode partition(ListNode head, int x) {
        ListNode lessPartition = null;
        ListNode lessPartitionHead = null;
        ListNode greaterPartition = null;
        ListNode greaterPartitionHead = null;

        while (head != null) {
            if (head.val >= x) {
                if (greaterPartitionHead == null) {
                    greaterPartition = greaterPartitionHead = new ListNode(head.val);
                } else {
                    greaterPartition.next = new ListNode(head.val);
                    greaterPartition = greaterPartition.next;
                }
            } else {
                if (lessPartitionHead == null) {
                    lessPartition = lessPartitionHead = new ListNode(head.val);
                } else {
                    lessPartition.next = new ListNode(head.val);
                    lessPartition = lessPartition.next;
                }
            }
            head = head.next;
        }
        if (lessPartitionHead == null) {
            return greaterPartitionHead;
        } else if (greaterPartitionHead == null) {
            return lessPartitionHead;
        }

        lessPartition.next = greaterPartitionHead;
        return lessPartitionHead;
    }

    public class ListNode {

        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
