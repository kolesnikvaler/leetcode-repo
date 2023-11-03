package leetcode.task011_list_node;

import java.math.BigInteger;

public class Arithmetic {
    public static void main(String[] args) {
        Arithmetic arithmetic = new Arithmetic();

        ListNode node_1 = new ListNode(1);
        ListNode l1 = node_1;
        for (int i = 0; i < 29; i++) {
            node_1.next = new ListNode(0);
            node_1 = node_1.next;
            if (i == 28){
                node_1.next = new ListNode(1);
            }
        }



        ListNode l2 = new ListNode(5);


        ListNode next_1 = new ListNode(4);
        ListNode next_2 = new ListNode(6);

        l2.next = next_1;
        next_1.next = next_2;

        //1000000000000000000000000000001
        System.out.println(l1);
        System.out.println(l2);

        System.out.println(arithmetic.addTwoNumbers(l1, l2));
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder builder = new StringBuilder();
        ListNode node = l1;
        while (node != null){
            builder.append(node.val);
            node = node.next;
        }
        BigInteger num_1 = new BigInteger(builder.reverse().toString());

        builder = new StringBuilder();
        node = l2;
        while (node != null){
            builder.append(node.val);
            node = node.next;
        }
        BigInteger num_2 = new BigInteger(builder.reverse().toString());
        BigInteger result = num_1.add(num_2);
        builder = new StringBuilder(result.toString()).reverse();

        node = new ListNode();
        ListNode res = node;

        char[] chars = builder.toString().toCharArray();
        for (int i = 0; i < chars.length; i++) {
            node.val = Integer.parseInt(String.valueOf(chars[i]));
            if (i == chars.length - 1)
                break;
            node.next = new ListNode();
            node = node.next;
        }

        return res;
    }

}