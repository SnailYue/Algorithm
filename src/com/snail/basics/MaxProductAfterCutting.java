package com.snail.basics;

public class MaxProductAfterCutting {

    /**
     * 题目：把一根绳子剪成多段，并且使得每段的长度乘积最大
     * 思路：动态规划：把分解后的小问题的最优解组合起来得到整个问题的最优解
     * <p>
     * 当剪第一刀时，我们有n-1种选择的可能，也就是剪出来的第一段绳子的长度的可能为1,2,3,....,n-1
     * 因此f(n) = max(f(i) * f(n - i))
     * <p>
     * 时间复杂度：O(n*n)
     * 空间复杂度：O(n)
     *
     * @return
     */
    public static int maxProductAfterCuttingOfDynamicProgramming(int n) {
        int[] val = new int[n + 1];
        val[0] = 0;
        val[1] = 0;
        for (int i = 1; i <= n; i++) {
            int max = 0;
            for (int j = 1; j < i; j++) {
                max = Math.max(max, Math.max(j * (i - j), val[j] * (i - j)));
            }
            val[i] = max;
        }
        return val[n];
    }

    /**
     * 思路：贪婪算法  每一步都可以做出一个贪婪选择。
     * 尽可能多剪长度为3的绳子，并且不允许有长度为1的绳子出现。如果出现了，就从已经切好的长度为3的绳子中拿出一段
     * 与长度为1的绳子重新组合，把他们切成两段长度为2的绳子。
     * <p>
     * 时间复杂度：O(1)
     * 空间复杂度：O(1)
     *
     * @return
     */
    public static int maxProductAfterCuttingOfGreedyAlgorithm(int n) {
        if (n < 2) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        int timeOfThree = n / 3;
        if (n - timeOfThree * 3 == 1) {
            timeOfThree--;
        }
        int timeOfTwo = (n - timeOfThree * 3) / 2;
        return (int) (Math.pow(3, timeOfThree) * (int) Math.pow(2, timeOfTwo));
    }

    public static void testInstance() {
        System.out.println("DynamicProgramming result = " + maxProductAfterCuttingOfDynamicProgramming(10));
        System.out.println("GreedyAlgorithm result = " + maxProductAfterCuttingOfGreedyAlgorithm(10));
    }
}
