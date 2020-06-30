package cn.edu.algorithm.binarySearch;

/**
 * 153. 寻找旋转排序数组中的最小值
 * <p>
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * <p>
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * <p>
 * 请找出其中最小的元素。
 * <p>
 * 你可以假设数组中不存在重复元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,4,5,1,2]
 * 输出: 1
 * <p>
 * 示例 2:
 * <p>
 * 输入: [4,5,6,7,0,1,2]
 * 输出: 0
 *
 * @author NieBin
 * @create 2020-06-29 16:33
 */
public class FndMin {
    public int findMin(int[] nums) {
        int l = 0;
        int h = nums.length - 1;
        while (l <= h) {
            int m = l + (h - l) / 2;
            if (nums[m] > nums[h]) {
                l = m + 1;
            } else {
                h = m - 1;
            }
        }
        return nums[l];
    }
}
