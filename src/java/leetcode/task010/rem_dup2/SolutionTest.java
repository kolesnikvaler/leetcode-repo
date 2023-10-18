package leetcode.task010.rem_dup2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class SolutionTest {
    private Solution solution;

    @BeforeEach
    public void initSol() {
        solution = new Solution();
    }

    @Test
    public void removeDup() {
        int[] nums = {1, 1, 1, 2, 3, 3, 5, 3, 3, 3, 3};
        int[] expected = {1, 1, 2, 3, 3, 5};
        int k = solution.removeDuplicates(nums);

        System.out.println(k + ", nums: " + Arrays.toString(nums));

        for (int i = 0; i < k; i++) {
            Assertions.assertSame(expected[i], nums[i]);
        }
    }
}