package cn.edu.algorithm.doublepointer;

import java.util.ArrayList;
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
public class ReverseVowels2 {
	private final static ArrayList<Character> vowel = new ArrayList<>(
			Arrays.asList('a','e','i','u','o','A','E','I','U','O'));
	public static void main(String[] args) {
		String str =" ABCDEfgie";
		String str2 =" bBCDdefgdd";
		System.out.println(reverseVowels2(str));
		System.out.println(reverseVowels2(str2));
	}
	public static String reverseVowels2(String a) {
		int i=0;
		int j = a.length()-1;
		char[] result = new char[a.length()];
		while(i<=j) {
			char s1 = a.charAt(i);
			char s2 = a.charAt(j);
			if(!vowel.contains(s1)) {
				result[i++] = s1;
			}
			if(!vowel.contains(s2)) {
				result[j--] = s2;
			}else if(vowel.contains(s1)) {
				result[i++]=s2;
				result[j--]=s1;
			}	
		}
		return new String(result);
	}
}
