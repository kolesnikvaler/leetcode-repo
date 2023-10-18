package leetcode.task005;

import java.util.*;
import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) {

    }

    public List<List<Integer>> permute(int[] nums) {
        Set<List<Integer>> mainList = new HashSet<>();
        if (nums.length == 1) {
            List<Integer> l1 = new ArrayList<>();
            l1.add(nums[0]);
            mainList.add(l1);
            return mainList.stream().toList();
        }

        List<Integer> numsList = IntStream.of(nums).boxed().toList();

        for (int i : nums) {
            List<Integer> l1 = new ArrayList<>();
            l1.add(i);
            recursive(l1, numsList, mainList);
        }

        return mainList.stream().toList();
    }

    protected static void recursive(List<Integer> list, List<Integer> nums, Set<List<Integer>> mainList) {
        for (int i : nums) {
            List<Integer> l2 = new ArrayList<>(list);

            if (Collections.frequency(nums, i) > Collections.frequency(l2, i)) {
                l2.add(i);

                if (l2.size() == nums.size()) {
                    mainList.add(l2);
                }
                else
                    recursive(l2, nums, mainList);
            }
        }
    }
}
