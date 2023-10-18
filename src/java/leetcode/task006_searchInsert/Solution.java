package leetcode.task006_searchInsert;

import java.math.BigInteger;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.searchInsert(new int[]{1,2}, 2));
        System.out.println(solution.multiply("2795820576851", "95369034579"));
//        System.out.println(123 * 456);
    }

    public int searchInsert(int[] nums, int target) {
        int index = Arrays.binarySearch(nums, target);
        if (index >= 0)
            return index;
        else {
            return Math.abs(index) - 1;
        }
    }

    public String multiply(String num1, String num2) {
        BigInteger bigInteger_1 = new BigInteger(num1);
        BigInteger bigInteger_2 = new BigInteger(num2);

        BigInteger bigInteger_3 = bigInteger_1.multiply(bigInteger_2);
        return bigInteger_3.toString();
    }
}
