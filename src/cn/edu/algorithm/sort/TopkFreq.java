package cn.edu.algorithm.sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
/**
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。

 示例 1:

 输入: nums = [1,1,1,2,2,3], k = 2
 输出: [1,2]

 示例 2:

 输入: nums = [1], k = 1
 输出: [1]

 说明：

 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/top-k-frequent-elements
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Administrator
 *
 */
public class TopkFreq {
	//桶排序法
	public List<Integer> topKFrequent(int[] nums, int k) {
		//1、使用HashMap统计元素的值（key）和频率及次数(value)
		Map<Integer,Integer> map = new HashMap<>();
		for(int i=0;i<nums.length;i++) {
			if(map.containsKey(nums[i])) {
				map.put(nums[i],map.get(nums[i])+1);
			}else {
				map.put(nums[i],1);
			}
		}

		//2、桶排序：用一个数组下标对应数出现的频率，对应处存其对应的值（使用List来存对应的值）
		List<Integer> listelement = new ArrayList<>();//对应元素
		List<Integer>[] buck = new List[nums.length+1]; //List类型的数组桶，次数最大为nums.length
		Set<Integer> set = map.keySet();
		for(int key:set){
			if(buck[map.get(key)]==null) {
				buck[map.get(key)] = new  ArrayList<>();
			}
			buck[map.get(key)].add(key);
		}

		//3、从后往前查找k高的元素
		for(int i=buck.length-1;i>0&&listelement.size()<k;i--){
			if(buck[i] == null) continue;
			listelement.addAll(buck[i]);
		}
		return listelement;
	}
}

