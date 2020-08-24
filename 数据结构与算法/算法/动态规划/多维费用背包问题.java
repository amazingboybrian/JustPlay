package 算法.动态规划;/* 2020/8/24 23:41 */

import org.junit.Test;

import java.util.*; //import java.io.*;

/*
474. Ones and Zeroes (Medium)

Leetcode / 力扣

Input: Array = {"10", "0001", "111001", "1", "0"}, m = 5, n = 3
Output: 4

Explanation: There are totally 4 strings can be formed by the using of 5 0s and 3 1s, which are "10","0001","1","0"
这是一个多维费用的 0-1 背包问题，有两个背包大小，0 的数量和 1 的数量。
 */
public class 多维费用背包问题 {
    @Test
    public void test() {
        String[] ss = {"10", "0001", "111001", "1", "0"};
        int m = 5, n = 3;
        int res = findMaxForm(ss, m, n);
        //int res = findMaxForm(null, m, n); //恶意测试
        System.out.println("res = " + res);
    }

    //dp[m][n] = Math.max(1 + dp[m-#0][n-#1], dp[m][n]) 存放StringCount
    public int findMaxForm(String[] strs, int m, int n) {
        //adds 需要对输入进行合法性检查
        if (strs == null || strs.length == 0) {
            return 0;
        }
        int[][] dp = new int[m + 1][n + 1]; //压缩维度为：N 商品/字符串的个数
        dp[0][0] = 0; //初始没有字符串

        for (String str : strs) { //逐个商品 dp  <！str不能为null>
            int zero = 0, one = 0;
            for (char c : str.toCharArray()) {
                if (c == '0') zero++;
                else one++;
            }
            for (int i = m; i >= zero; i--) { //多维费用/容量 dp
                for (int j = n; j >= one; j--) {
                    dp[i][j] = Math.max(dp[i][j], 1 + dp[i - zero][j - one]); //不加 / 加
                }
            }
        }
        return dp[m][n];
    }
}
