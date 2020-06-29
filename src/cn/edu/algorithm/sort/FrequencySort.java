package cn.edu.algorithm.sort;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
 *
 * 示例 1:
 *
 * 输入: "tree"
 *
 * 输出: "eert"
 *
 * 解释: 'e'出现两次，'r'和't'都只出现一次。 因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
 *
 * 示例 2:
 *
 * 输入: "cccaaa"
 *
 * 输出: "cccaaa"
 *
 * 解释: 'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。 注意"cacaca"是不正确的，因为相同的字母必须放在一起。
 *
 * 示例 3:
 *
 * 输入: "Aabb"
 *
 * 输出: "bbAa"
 *
 * 解释: 此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。 注意'A'和'a'被认为是两种不同的字符。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-characters-by-frequency
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Administrator
 *
 */
public class FrequencySort {
	public static void main(String[] args) {
		String s = " ";
		System.out.println(s);
		String s2 = frequencySort(s);
		System.out.println(s2);
	}

	public static String frequencySort(String s) {
		if (s==null||s.equals("")) return s;
		// 1、使用HashMap key=字符，value=频数
		Map<Character, Integer> map = new HashMap<>();
		// Set<Character> set = map.keySet();
		for (int i = 0; i < s.length(); i++) {
			char p = s.charAt(i);
			map.put(p, map.getOrDefault(p, 0) + 1);
		}
		/*Set<Character> ss = map.keySet();
		for (Iterator<Character> iterator = ss.iterator(); iterator.hasNext();) {
			Character key = iterator.next();
			System.out.println(key + "--" + map.get(key));
		}*/
		/*
		 * 2、桶排序：生成一StringBuilder 类型的数组，数组长度为s.length()+1, 数组下标为频数[1,s.length]
		 */
		StringBuilder[] str = new StringBuilder[s.length() + 1];
		Set<Character> set = map.keySet();
		for (char c : set) {
			int i = map.get(c);
			if (str[i] == null) {
				str[i] = new StringBuilder();
			}
			int n=i;//i个重复的字母
			while (n>0) {
				str[i].append(c);
				n--;
			}
		}
		/*for (StringBuilder sp : str) {
			System.out.print(sp + " ");
		}*/
		//System.out.println();

		// 后序遍历
		int temp = str.length - 1;// 后序遍历第一个非空的下标
		while (temp > 0 && str[temp] == null) {
			temp--;
		}
		for (int j = temp - 1; j > 0; j--) {// 从temp下一个开始加入非空到temp中
			if (str[j] == null) {
				continue;
			}
			str[temp].append(str[j]);
		}
	/*	if(str[temp]==null) {
			return null;
		}*/
		return str[temp].toString();
	}

}