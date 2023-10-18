package leetcode.task009_remove_dublicate;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 0;
        Set<Integer> set = new TreeSet<>(IntStream.of(nums).boxed().collect(Collectors.toSet()));
        for (Integer i : set) {
            nums[k] = i;
            k++;
        }

        return k;
    }
}
