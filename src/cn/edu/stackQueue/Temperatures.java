package cn.edu.stackQueue;

import java.util.Stack;

/**
 * 根据每日 气温 列表，请重新生成一个列表，对应位置的输出是需要再等待多久温度才会升高超过该日的天数。如果之后都不会升高，
 * 请在该位置用 0 来代替。
 *
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 *
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 *
 * 栈的算法思想：将数据数组序号压栈，只要出现大值就把前面比当前值小的所有小值索引删掉并记录差值
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/daily-temperatures
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @auther NieBin
 * @create 2020-05-20 11:20
 */
public class Temperatures {
    public int[] dailyTemperatures(int[] T) {
        int n = T.length;
        int[] dist = new int[n];
        Stack<Integer> indexs = new Stack<>();
        for (int curIndex = 0; curIndex <n ; curIndex++) {
            while (!indexs.isEmpty()&&T[curIndex]>T[indexs.peek()]){
                int preIndex = indexs.pop();
                dist[preIndex] = curIndex-preIndex;
            }
            indexs.push(curIndex);
        }
        return dist;
    }
}
