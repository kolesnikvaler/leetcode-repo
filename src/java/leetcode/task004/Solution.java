package leetcode.task004;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        /*Solution solution = new Solution();
        List<List<Integer>> mainList = solution.permute(new int[]{1, 2, 3});

        for (int i = 0; i < mainList.size(); i++) {
            mainList.get(i).forEach(integer -> System.out.printf("%d", integer));
            System.out.println();
        }*/
    }



    public List<List<Integer>> permute(int[] nums) {
        Set<List<Integer>> mainSet = new HashSet<>();
        if (nums.length == 1){
            List<Integer> l1 = new ArrayList<>();
            l1.add(nums[0]);
            mainSet.add(l1);
            return mainSet.stream().toList();
        }



        for (int i : nums) {
            final List<Integer> l1 = new ArrayList<>();
            l1.add(i);
            recursive(l1, nums, mainSet);
        }

        return mainSet.stream().toList();
    }

    private static void recursive(List<Integer> list, int[] nums, Set<List<Integer>> mainSet){
        for (int i : nums) {
            List<Integer> l2 = new ArrayList<>(list);

            if (!l2.contains(i)){
                l2.add(i);

                if (l2.size() == nums.length)
                    mainSet.add(l2);
                else
                    recursive(l2, nums, mainSet);
            }
        }
    }
}