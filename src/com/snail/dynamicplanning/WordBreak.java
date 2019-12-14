package com.snail.dynamicplanning;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目：给定一个非空的字符串s和一个包含非空字符串的字典wordDict，判定s是否可以拆分成一个或多个字典中出现的单纯。
 * <p>
 * 解题思路：
 * 这个方法的想法是对于给定的字符串（ss）可以被拆分成子问题 s1s1 和 s2s2 。
 * 如果这些子问题都可以独立地被拆分成符合要求的子问题，那么整个问题 ss 也可以满足。
 * 也就是，如果 "catsanddog" 可以拆分成两个子字符串 "catsand" 和 "dog" 。
 * 子问题 "catsand" 可以进一步拆分成 "cats" 和 "and" ，这两个独立的部分都是字典的一部分，
 * 所以 "catsand" 满足题意条件，再往前，"catsand" 和 "dog" 也分别满足条件，
 * 所以整个字符串 "catsanddog" 也满足条件。
 * 现在，我们考虑dp 数组求解的过程。我们使用 n+1 大小数组的 dp ，其中 n 是给定字符串的长度。
 * 我们也使用 2 个下标指针 i 和 j ，其中 i 是当前字符串从头开始的子字符串s的长度，j 是当前子字符串s的拆分位置，拆分成 s(0,j) 和 s(j+1,i)
 * 为了求出dp 数组，我们初始化dp[0] 为 true ，这是因为空字符串总是字典的一部分。 dp 数组剩余的元素都初始化为 false 。
 * 我们用下标 i 来考虑所有从当前字符串开始的可能的子字符串。对于每一个子字符串，我们通过下标 j 将它拆分成 s1
 * 和 s2（注意 i 现在指向s2的结尾）。
 * 为了将dp[i] 数组求出来，我们依次检查每个dp[j] 是否为true ，也就是子字符串s1是否满足题目要求。
 * 如果满足，我们接下来检查 s2是否在字典中。
 * 如果包含，我们接下来检查 s2是否在字典中，
 * 如果两个字符串都满足要求，我们让dp[i] 为true ，否则令其为false 。
 */
public class WordBreak {

    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }


    public static void testInstance() {
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        System.out.println("result = " + wordBreak(s, wordDict));
    }
}
