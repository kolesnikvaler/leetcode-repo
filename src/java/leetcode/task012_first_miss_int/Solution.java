package leetcode.task012_first_miss_int;

import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.firstMissingPositive(new int[]{0,2,2,1,1}));
    }

    public int firstMissingPositive(int[] nums) {
        TreeSet<Integer> set = IntStream.of(nums).boxed()
                .filter(x -> x > 0)
                .collect(Collectors.toCollection(TreeSet::new));
        int res = 1;

        for (Integer num : set) {
            if (num.equals(res))
                res++;
            else
                return res;
        }

        return res;
    }
}
