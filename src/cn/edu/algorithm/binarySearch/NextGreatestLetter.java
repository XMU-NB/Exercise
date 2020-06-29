package cn.edu.algorithm.binarySearch;

/**
 * 744. 寻找比目标字母大的最小字母
 * <p>
 * 给你一个排序后的字符列表 letters ，列表中只包含小写英文字母。另给出一个目标字母 target，
 * 请你寻找在这一有序列表里比目标字母大的最小字母。
 * <p>
 * 在比较时，字母是依序循环出现的。举个例子：
 * <p>
 * 如果目标字母 target = 'z' 并且字符列表为 letters = ['a', 'b']，则答案返回 'a'
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "a"
 * 输出: "c"
 * <p>
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "c"
 * 输出: "f"
 * <p>
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "d"
 * 输出: "f"
 * <p>
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "g"
 * 输出: "j"
 * <p>
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "j"
 * 输出: "c"
 * <p>
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "k"
 * 输出: "c"
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * letters长度范围在[2, 10000]区间内。
 * letters 仅由小写字母组成，最少包含两个不同的字母。
 * 目标字母target 是一个小写字母。
 *
 * @author NieBin
 * @create 2020-06-25 22:32
 */
public class NextGreatestLetter {
    public char nextGreatestLetter(char[] letters, char target) {
        int l = 0;
        int n = letters.length;
        int h = n - 1;
        while (l <= h) {
            int m = (l + h) / 2;
            if (letters[m] <= target) {//当前的字母比目标小，则比目标大的在后半段
                l = m + 1;
            } else { //当前字母比目标大，在前半段继续查询比目标大的字母。
                h = m - 1;
            }
        }
        //分析：当l=h时,不管是在目标处还是不在目标处，最终结束最后一轮循环后，l最终定位在目标值上。
        return l < n ? letters[l] : letters[0];
    }
}
