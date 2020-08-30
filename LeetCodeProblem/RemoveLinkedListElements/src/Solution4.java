// 使用递归算法
// 更加简洁优雅的代码
public class Solution4 {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        head.next = removeElements(head.next, val);

        return head.val == val ? head.next : head;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 6, 5, 6, 8};
        ListNode list = new ListNode(arr);
        System.out.println(list);

        ListNode res = (new Solution2()).removeElements(list, 6);
        System.out.println(res);
    }
}

