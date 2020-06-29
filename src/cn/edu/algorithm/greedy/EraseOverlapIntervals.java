package cn.edu.algorithm.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 * <p>
 * 注意:
 * <p>
 * 可以认为区间的终点总是大于它的起点。
 * 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [ [1,2], [2,3], [3,4], [1,3] ]
 * <p>
 * 输出: 1
 * <p>
 * 解释: 移除 [1,3] 后，剩下的区间没有重叠。
 * <p>
 * 示例 2:
 * <p>
 * 输入: [ [1,2], [1,2], [1,2] ]
 * <p>
 * 输出: 2
 * <p>
 * 解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
 * <p>
 * 示例 3:
 * <p>
 * 输入: [ [1,2], [2,3] ]
 * <p>
 * 输出: 0
 * <p>
 * 解释: 你不需要移除任何区间，因为它们已经是无重叠的了
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/non-overlapping-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Administrator
 */

//1
public class EraseOverlapIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1, 100}, {11, 22}, {1, 11}, {2, 12}};//[[1,100],[11,22],[1,11],[2,12]]
        int overlapIntervals = eraseOverlapIntervals(intervals);
        System.out.println(overlapIntervals);
    }

    //1、贪心思路
    // 1）从区间集合 intvs 中选择一个区间 x，这个 x 是在当前所有区间中结束最早的（end 最小）。
    // 2）把所有与 x 区间相交的区间从区间集合 intvs 中删除。
    // 3）重复步骤 1 和 2，直到 intvs 为空为止。之前选出的那些 x 就是最大不相交子集。
    public static int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0||intervals.length==1) {
            return 0;
        }
        //Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        int count = 0;
        int[]p = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if(p[1]>intervals[i][0]){
                count++;
            }else {
                p = intervals[i];
            }
        }
        return count;
    }


    //2、个人错误思路，花了三天，记录一下
    public static int eraseOverlapIntervals2(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        list.addAll(Arrays.asList(intervals));
        int num = 0;
        int i = 0;
        while (i < list.size() - 1) {
            boolean flag = true;
            for (int j = i + 1; j < list.size(); j++) {
                int[] temp1 = list.get(i);
                int[] temp2 = list.get(j);
                int length1 = temp1[1] - temp1[0];
                int length2 = temp2[1] - temp2[0];
                if (isOverlap(temp1, temp2)) {
                    if (length1 > length2) {
                        i++;
                        num++;
                        flag = false;
                        break;
                    } else {
                        list.remove(j);
                        j--;
                        num++;
                    }
                }
            }
            if (flag) {
                i++;
            }
        }
        return num;
    }

    private static boolean isOverlap(int[] temp1, int[] temp2) {
        boolean a = temp1[0] >= temp2[1];
        boolean b = temp2[0] >= temp1[1];
        return !(a || b);
    }
}
