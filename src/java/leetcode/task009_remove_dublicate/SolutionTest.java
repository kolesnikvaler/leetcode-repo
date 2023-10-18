package leetcode.task009_remove_dublicate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private Solution solution;

    @BeforeEach
    public void initSolution(){
        solution = new Solution();
    }

    @Test
    public void removeDuplicates(){
        int[] nums = {-3,-1,0,0,0,3,3};
        int k = solution.removeDuplicates(nums);

        System.out.println(k + ", nums: " + Arrays.toString(nums));
    }

}