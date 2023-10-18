package leetcode.task007_findSubstring;

import java.util.*;

public class Solution {
    public static void main(String[] args) {

    }

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new ArrayList<>();
        int length = words.length;
        if ((words.length * words[0].length()) > s.length())
            return list;


        Set<String> set = new HashSet<>();

        List<String> wordList = new ArrayList<>();

        List<String> strings = new ArrayList<>(Arrays.asList(words));

        for (String word : words) {
            wordList.add(word);
            recursive(wordList, strings, set, length);
            wordList = new ArrayList<>();
        }


        List<String> endList = new ArrayList<>(set);

        endList.forEach(System.out::println);

        int index = -1;
        for (int i = 0; i < endList.size(); i++) {

            if ((index = s.indexOf(endList.get(i), index + 1)) != -1){
                list.add(index);
                i--;
                continue;
            }

            index = -1;
        }


        return list;
    }

    protected static void recursive(List<String> wordList, List<String> words, Set<String> set, int length) {
        for (String s : words) {
            List<String> newWordList = new ArrayList<>(wordList);

            int wordLength = newWordList.size();
            if (wordLength == length) {
                StringBuilder builder = new StringBuilder();
                boolean flag = true;
                for (String str : words) {
                    if (Collections.frequency(newWordList, str) != Collections.frequency(words, str)) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    for (String str : newWordList) {
                        builder.append(str);
                    }

                    set.add(builder.toString());
                }
            } else {

                newWordList.add(s);

                recursive(newWordList, words, set, length);
            }
        }
    }
}
