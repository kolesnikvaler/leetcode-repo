package leetcode.task008_merge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class SolutionTest {
    private Solution solution;

    @BeforeEach
    public void init(){
        solution = new Solution();
    }

    @Test
    public void removeElement(){
        int[] nums = {1, 2, 0, 2, 5, 5};
        int val = 2;
        int k = solution.removeElement(nums, val);
        System.out.println(k + ", arr: " + Arrays.toString(nums));

    }


}