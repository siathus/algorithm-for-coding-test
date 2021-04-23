package challenge.april_2021.week1.palindrome_linked_list;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean isPalindrome(ListNode head) {
        List<Integer> valueList = new ArrayList<>();

        while (true) {
            valueList.add(head.val);
            if (head.next == null) break;
            head = head.next;
        }

        int endIndex = valueList.size() - 1;
        int startIndex = 0;
        while (startIndex <= endIndex) {
            if (valueList.get(startIndex) != valueList.get(endIndex)) return false;
            startIndex++;
            endIndex--;
        }
        return true;
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
}