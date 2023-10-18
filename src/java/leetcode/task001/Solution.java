package leetcode.task001;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.kthFactor(12, 3));
    }

    public int kthFactor(int n, int k) {
        List<Integer> factors = new ArrayList<>();
        for (int i = 1; i <= (int)Math.max(n, k); i++){
            if (n % i == 0)
                factors.add(i);
        }

        factors.forEach(System.out::println);

        if (k <= factors.size()){
            return factors.get(k - 1);
        } else{
            return -1;
        }
    }
}