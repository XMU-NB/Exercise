package cn.edu.algorithm.doublepointer;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。

 示例 1:

 输入: "hello"
 输出: "holle"

 示例 2:

 输入: "leetcode"
 输出: "leotcede"

 说明:
 元音字母不包含字母"y"

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/reverse-vowels-of-a-string
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Administrator
 *
 */
public class ReverseVowels {
	private final static HashSet<Character> vowels = new HashSet<>(
	        Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
    public static void main(String[] args) {
		String str =" ABCDEfgie";
		System.out.println(reverseVowels(str));
	}
	public static String reverseVowels(String s) {
	    if (s == null) return null;
	    int i = 0, j = s.length() - 1;
	    char[] result = new char[s.length()];
	    while (i <= j) {
	        char ci = s.charAt(i);
	        char cj = s.charAt(j);
	        if (!vowels.contains(ci)) {
	            result[i++] = ci;
	        } else if (!vowels.contains(cj)) {
	            result[j--] = cj;
	        } else {
	            result[i++] = cj;
	            result[j--] = ci;
	        }
	    }
	    return new String(result);
	}
}
