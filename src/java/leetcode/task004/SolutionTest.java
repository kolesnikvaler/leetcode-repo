package leetcode.task004;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class SolutionTest {
    private Solution solution;

    @BeforeEach
    public void init(){
        solution = new Solution();
    }

    @Test
    public void permute(){
        List<List<Integer>> mainList = solution.permute(new int[]{1, 2, 3, 4, 5});

        for (int i = 0; i < mainList.size(); i++) {
            mainList.get(i).forEach(integer -> System.out.printf("%d", integer));
            System.out.println();
        }
    }
}