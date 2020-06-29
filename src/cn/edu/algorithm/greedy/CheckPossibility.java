package cn.edu.algorithm.greedy;

/**
 * 665. 非递减数列
 * <p>
 * 给你一个长度为 n 的整数数组，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。
 * <p>
 * 我们是这样定义一个非递减数列的： 对于数组中所有的 i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [4,2,3]
 * 输出: true
 * 解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。
 * <p>
 * 示例 2:
 * <p>
 * 输入: nums = [4,2,1]
 * 输出: false
 * 解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
 *
 * @author NieBin
 * @create 2020-06-22 23:12
 */
public class CheckPossibility {
    public boolean checkPossibility(int[] nums) {
        if (nums.length <= 2) {
            return true;
        }
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= nums[i-1]) {
                continue;
            }
            if (count == 1) {
                return false;
            }
            count++;
            if (i - 2 >= 0 && nums[i] < nums[i-2]) {
                nums[i] = nums[i - 1];
            } else {
                nums[i - 1] = nums[i];
            }
        }
        return true;
    }
}
