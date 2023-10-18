package leetcode.task007_findSubstring;

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
    public void findSubstring(){
        String s = "wordgoodgoodgoodbestword";
        String[] words = {"word","good","best","word"};
        List<Integer> list = solution.findSubstring(s, words);

        list.forEach(System.out::println);
    }

    @Test
    public void test(){
        String s = "barfoothefoobarman";
        String[] words = {"foo","bar"};
        List<Integer> list = solution.findSubstring(s, words);

        list.forEach(System.out::println);
    }

    @Test
    public void secondTest(){
        String s = "foobarfoobar";
        String[] words = {"foo","bar"};
        List<Integer> list = solution.findSubstring(s, words);

        list.forEach(System.out::println);
    }

    @Test
    public void collapseTest(){
        String s = "bcabbcaabbccacacbabccacaababcbb";
        String[] words = {"c","b","a","c","a","a","a","b","c"};
        List<Integer> list = solution.findSubstring(s, words);

        list.forEach(System.out::println);
    }
}