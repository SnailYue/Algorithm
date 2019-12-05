package com.snail.dynamicplanning;

/**
 * 题目：给定两个字符串s1，s2，找到两个字符串相等时所需删除的字符的ASCII值的最小值
 * <p>
 * 解题思路：
 * dp[i][j]表示s1中前i个字符和s2前j个字符中，删除的最小字符和。
 * 初始化dp[i][0]和dp[0][j].
 * 当s1[i] == s2[j-1]时，那么不需要删除字符，所以dp[i][j] == dp[i-1][j-1].
 * 当s1[i] != s2[j]时，那么比较dp[i-1][j] + s1[i-1]和dp[i][j-1] + s2[j-1]大小，
 * 选择删除s1[i-1]或者s2[j-1].
 */
public class MinASCIISumOfDeleteStrings {

    public static int minimumDeleteSum(String s1, String s2) {
        if (s1.isEmpty() || s2.isEmpty()) {
            return 0;
        }
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i - 1][0] + s1.charAt(i - 1);
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = dp[0][j - 1] + s2.charAt(j - 1);
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j] + s1.charAt(i - 1) > dp[i][j - 1] + s2.charAt(j - 1) ? dp[i][j - 1] + s2.charAt(j - 1) : dp[i - 1][j] + s1.charAt(i - 1);
                }
            }
        }
        return dp[m][n];
    }

    public static void testInstance() {
        String s1 = "delete";
        String s2 = "leet";
        System.out.println("result = " + minimumDeleteSum(s1, s2));
    }

}
