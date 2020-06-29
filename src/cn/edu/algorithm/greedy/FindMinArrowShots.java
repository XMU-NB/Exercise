package cn.edu.algorithm.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 在二维空间中有许多球形的气球。对于每个气球，提供的输入是水平方向上，气球直径的开始和结束坐标。
 * 由于它是水平的，所以y坐标并不重要，因此只要知道开始和结束的x坐标就足够了。开始坐标总是小于结束坐标。
 * 平面内最多存在10^4气球。
 *
 * 一支弓箭可以沿着x轴从不同点完全垂直地射出。在坐标x处射出一支箭，
 * 若有一个气球的直径的开始和结束坐标为 xstart，xend， 且满足  xstart ≤ x ≤ xend，
 * 则该气球会被引爆。可以射出的弓箭的数量没有限制。 弓箭一旦被射出之后，可以无限地前进。
 * 我们想找到使得所有气球全部被引爆，所需的弓箭的最小数量。
 *
 * Example:
 *
 * 输入:
 * [[10,16], [2,8], [1,6], [7,12]]
 *
 * 输出:
 * 2
 *
 * 解释:
 * 对于该样例，我们可以在x = 6（射爆[2,8],[1,6]两个气球）和 x = 11（射爆另外两个气球）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-number-of-arrows-to-burst-balloons
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author NieBin
 * @create 2020-06-14 22:39
 */
public class FindMinArrowShots {
    /*本题的主要思路：
    1.我们不需要考虑气球开始的坐标(即Xstart)，只考虑结束坐标(即Xend);
    2.我们箭的射出坐标也仅仅只需要考虑结束坐标；
    3.以结束坐标进行排序(按各结束从小到大的顺序进行排序)；
    4.遍历气球列表，取结束坐标为箭的坐标，考虑结束坐标是否可以穿破下一个气球即可，
    若不能，就需要第二根箭，若能跳过判断下一个即可
    */
    public int findMinArrowShots(int[][] points) {
        if(points.length==0||points.length == 1){
            return points.length;
        }
        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));
        int[] arrow = points[0];
        int arrowNum = 1;
        for (int i = 1; i < points.length; i++) {
            if (points[i][1]<arrow[1]){
                arrow = points[i];
                arrowNum++;
            }
        }
        return arrowNum;
    }
}
