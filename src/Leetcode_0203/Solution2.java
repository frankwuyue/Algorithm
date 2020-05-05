package Leetcode_0203;

public class Solution2 {
    public static ListNode removeElements(ListNode head, int val, int depth) {
        System.out.print(generateDepthString(depth));
        System.out.println("Call: remove " + val + " in " + head);
        if (head == null) {
            System.out.print(generateDepthString(depth));
            System.out.println("Return: " + head);
            return null;
        }

        ListNode res = removeElements(head.next, val, depth + 1);
        System.out.print(generateDepthString(depth));
        System.out.println("After remove: " + val + ": " + res);

        ListNode rev;
        if (head.val == val) {
            rev = res;
        } else {
            head.next = res;
            rev = head;
        }
        System.out.print(generateDepthString(depth));
        System.out.println("Return: " + rev);
        return rev;
    }

    public static void main(String[] args) {
        int[] num = {1, 2, 6, 3, 4, 5, 6};
        ListNode head = new ListNode(num);
        System.out.println(head);

        ListNode afterRemove = removeElements(head, 6, 0);
        System.out.println(afterRemove);
    }

    private static String generateDepthString(int depth) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            stringBuilder.append("--");
        }
        return stringBuilder.toString();
    }
}
