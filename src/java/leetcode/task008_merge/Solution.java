package leetcode.task008_merge;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = new int[7];
        nums1[0] = 10;
        nums1[1] = 12;
        nums1[2] = 23;
        nums1[3] = 134;

        solution.merge(nums1, 4, new int[]{20, 5, 2}, 3);
        System.out.println(Arrays.toString(nums1));

    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m; i < n + m; i++) {
            nums1[i] = nums2[i - m];
        }
        Arrays.parallelSort(nums1);
    }

    public int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                nums[i] = Integer.MAX_VALUE;
            } else
                k++;
        }

        Arrays.sort(nums);
        return k;
    }
}
