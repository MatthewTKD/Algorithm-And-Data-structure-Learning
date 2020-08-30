// 使用递归算法
public class Solution3 {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        ListNode res = removeElements(head.next, val);
        if (head.val == val) {
            return res;
        } else {
            head.next = res;
            return head;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 6, 5, 6, 8};
        ListNode list = new ListNode(arr);
        System.out.println(list);

        ListNode res = (new Solution2()).removeElements(list, 6);
        System.out.println(res);
    }
}

