package leetcode.task010.rem_dup2;

import java.util.*;
import java.util.stream.IntStream;

public class Solution {

    public int removeDuplicates(int[] nums) {

        List<Integer> list = new ArrayList<>(IntStream.of(nums).boxed().toList());
        TreeSet<Integer> treeSet = new TreeSet<>(list);

        int k = 0;
        for (Integer i : treeSet) {
            if (Collections.frequency(list, i) > 1) {
                nums[k++] = i;
            }
            nums[k++] = i;
        }
//        Arrays.fill(nums, k, nums.length, 0);
        return k;
    }
}
