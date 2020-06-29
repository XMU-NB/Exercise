package cn.edu.algorithm.greedy;

import java.util.*;

/**
 * 763. 划分字母区间
 *
 * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，
 * 同一个字母只会出现在其中的一个片段。返回一个表示每个字符串片段的长度的列表。
 *
 *
 *
 * 示例 1：
 *
 * 输入：S = "ababcbacadefegdehijhklij"
 * 输出：[9,7,8]
 * 解释：
 * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 *
 *
 *
 * 提示：
 *
 *     S的长度在[1, 500]之间。
 *     S只包含小写字母 'a' 到 'z' 。
 * @author NieBin
 * @create 2020-06-25 10:58
 */
public class PartitionLabels {

    public static void main(String[] args) {
        String S = "ababcbacadefegdehijhklij";
        System.out.println(partitionLabels(S));

    }
    public static List<Integer> partitionLabels(String S) {
        List<Integer> num = new ArrayList<>();
        List[] lists = new List[S.length()];
        char[] chars = S.toCharArray();
        for (char c : chars) {
            for (int i = 0; i < lists.length; i++) {
                if(lists[i]==null) {
                    lists[i] = new ArrayList();
                }
                if(lists[i].isEmpty()){
                    lists[i].add(c);
                    break;
                }
                if (lists[i].contains(c)){
                    for (int j = i+1; j <lists.length ; j++) {
                        if (lists[j]==null||lists[j].isEmpty()){
                            break;
                        }
                        lists[i].addAll(lists[j]);
                        lists[j].clear();
                    }
                    lists[i].add(c);
                    break;
                }
            }
        }
        for (int i = 0; i <lists.length ; i++) {
            if (lists[i]==null||lists[i].isEmpty()){
                break;
            }
            num.add(i,lists[i].size());
        }
        return num;
    }
    //参考答案
    /**
     * 方法一： 贪心 【通过】
     *
     * 思路
     *
     * 策略就是不断地选择从最左边起最小的区间。可以从第一个字母开始分析，假设第一个字母是 'a'，
     * 那么第一个区间一定包含最后一次出现的 'a'。但第一个出现的 'a' 和最后一个出现的 'a'
     * 之间可能还有其他字母，这些字母会让区间变大。举个例子，在 "abccaddbeffe" 字符串中，
     * 第一个最小的区间是 "abccaddb"。
     * 通过以上的分析，我们可以得出一个算法：对于遇到的每一个字母，去找这个字母最后一次出现的位置，
     * 用来更新当前的最小区间。
     *
     * 算法
     *
     * 定义数组 last[char] 来表示字符 char 最后一次出现的下标。定义 anchor 和 j 来表示当前区间的首尾。
     * 如果遇到的字符最后一次出现的位置下标大于 j， 就让 j=last[c] 来拓展当前的区间。
     * 当遍历到了当前区间的末尾时(即 i==j )，把当前区间加入答案，同时将 start 设为 i+1 去找下一个区间。
     */
    public List<Integer> partitionLabels2(String S) {
        int[] last = new int[26];
        for (int i = 0; i < S.length(); ++i)
            last[S.charAt(i) - 'a'] = i;

        int j = 0, anchor = 0;
        List<Integer> ans = new ArrayList();
        for (int i = 0; i < S.length(); ++i) {
            j = Math.max(j, last[S.charAt(i) - 'a']);
            if (i == j) {
                ans.add(i - anchor + 1);
                anchor = i + 1;
            }
        }
        return ans;
    }
}
