package cn.edu.algorithm.binarySearch;

/**
 * 540. 有序数组中的单一元素
 *
 * 给定一个只包含整数的有序数组，每个元素都会出现两次，唯有一个数只会出现一次，找出这个数。
 *
 * 示例 1:
 *
 * 输入: [1,1,2,3,3,4,4,8,8]
 * 输出: 2
 *
 * 示例 2:
 *
 * 输入: [3,3,7,7,10,11,11]
 * 输出: 10
 *
 * 注意: 您的方案应该在 O(log n)时间复杂度和 O(1)空间复杂度中运行。
 * @author NieBin
 * @create 2020-06-26 9:45
 */
public class SingleNonDuplicate {

    //时间和空间复杂度不满足要求
    public int singleNonDuplicate(int[] nums) {
        if (nums.length==1){
            return nums[0];
        }
        for (int i = 0; i < nums.length; i++) {
            if (i==0){
                if(nums[i]!=nums[i+1]) {
                    return nums[i];
                }
            }else if (i==nums.length-1){
                if(nums[i]!=nums[i-1]) {
                    return nums[i];
                }
            }else{
                if(nums[i]!=nums[i-1]&&nums[i]!=nums[i+1]) {
                    return nums[i];
                }
            }
        }
        return 0;
    }
    //参考令 index 为 Single Element 在数组中的位置。在 index 之后，数组中原来存在的成对状态被改变。
    // 如果 m 为偶数，并且 m + 1 < index，那么 nums[m] == nums[m + 1]；m + 1 >= index，
    // 那么 nums[m] != nums[m + 1]。
    public int singleNonDuplicate2(int[] nums) {
        int l = 0;
        int h = nums.length-1;
        while (l<h){
            int m = l+(h-l)/2;
            if (m%2==1){
                m--;//防止mid是奇数，是的话则左移一位,目标位在偶数位置
            }
            if(nums[m]==nums[m+1]){
                l = m+2; //说明目标数在[mid+2,h]
            }else{
                h = m;  //否则目标数在[l,mid]
            }
        }
        return nums[h];
    }
}
