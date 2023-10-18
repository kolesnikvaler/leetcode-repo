package leetcode.task002;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] num1 = new int[]{1, 2, 6};
        int[] num2 = new int[]{10, 12, 13};
        System.out.println(solution.isMatch("abc", "a***abc"));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] num3 = IntStream.concat(Arrays.stream(nums1), Arrays.stream(nums2)).toArray();
        Arrays.sort(num3);
        if (num3.length % 2 == 0){
            return (double) (num3[num3.length/2] + num3[num3.length/2-1]) / 2;
        } else
            return num3[num3.length/2];
    }

    public boolean isMatch(String s, String p) {
        return s.matches(p);
    }
}
