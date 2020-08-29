// 使用dummyHead
public class Solution2 {
    public ListNode removeElements(ListNode head, int val) {

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.val == val) {
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
            } else {
                prev = prev.next;
            }
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 6, 5, 6, 8};
        ListNode list = new ListNode(arr);
        System.out.println(list);

        ListNode res = (new Solution2()).removeElements(list, 6);
        System.out.println(res);
    }
}
