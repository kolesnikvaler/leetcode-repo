package leetcode.task005;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

class SolutionTest {
    private Solution solution;

    @BeforeEach
    public void init(){
        solution = new Solution();
    }

    @Test
    public void test(){
        List<List<Integer>> mainList = solution.permute(new int[]{-1,2,-1,2,1,-1,2,1});

//        -1,2,-1,2,1,-1,2,1

        /*for (int i = 0; i < mainList.size() - 1; i++) {
            for (int j = i + 1; j < mainList.size(); j++) {
                if (mainList.get(i) != null && mainList.get(i).equals(mainList.get(j)))
                    mainList.set(j, null);
            }
        }*/

        for (int i = 0; i < mainList.size(); i++) {
            mainList.get(i).forEach(integer -> System.out.printf("%d ", integer));
            System.out.println();
        }

    }

    @Test
    public void secondTest(){
        Set<List<Integer>> setList = new HashSet<>();

        int[] nums = new int[]{-1,2,-1,2,1,-1,2,1};

        final List<Integer> numsList = IntStream.of(nums).boxed().toList();


        ExecutorService service = Executors.newFixedThreadPool(nums.length);



        for (int i : numsList) {
            final List<Integer> l1 = new ArrayList<>();
            l1.add(i);
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    Solution.recursive(l1, numsList, setList);
                }
            };
            service.execute(runnable);
        }
        service.shutdown();
        try {
            service.awaitTermination(380, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
        }


        for (List<Integer> list : setList) {
            list.forEach(integer -> System.out.printf("%d ", integer));
            System.out.println();
        }

    }

}