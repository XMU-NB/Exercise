package cn.edu.algorithm.doublepointer;
/**
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。

 示例 1:

 输入: "aba"
 输出: True

 示例 2:

 输入: "abca"
 输出: True
 解释: 你可以删除c字符。

 注意:

 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/valid-palindrome-ii
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Administrator
 *
 */
public class Palindrome {
	public static void main(String[] args) {
		String s1 = "ab";
		String s2 = "dabd";
		String s3 = "vbadbv";
		System.out.println(validPalindrome(s1));
		System.out.println(validPalindrome(s2));
		System.out.println(validPalindrome(s3));
	}
	/*
	 * ˼·��ȫ����
	 */
	public static boolean validPalindrome(String s) {
	   if(s==null) return false;
	   if(s.length()<3) return false;
       int i=0;
       int j=s.length()-1;
       int middle = s.length()/2-1;
       while(i<j) {
    	   char c1 = s.charAt(i);
    	   char c2 = s.charAt(j);
    	   if(i!=middle) {
	    	   if(c1!=c2) {
	    		   return false;
	    	   }else {
	    		   i++;
	    		   j--;
	    	   }
    	   }else if(j==i+1) {
    		   return true;
    	   }else if(c1==c2) {
    		   return true;
    	   }else {
    		   return false;
    	   }
       }
       return false;
    }
	
/*
 * �ο���
 */
	
	public boolean validPalindrome2(String s) {
	    for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
	        if (s.charAt(i) != s.charAt(j)) {
	            return isPalindrome(s, i, j - 1) || isPalindrome(s, i + 1, j);
	        }
	    }
	    return true;
	}

	private boolean isPalindrome(String s, int i, int j) {
	    while (i < j) {
	        if (s.charAt(i++) != s.charAt(j--)) {
	            return false;
	        }
	    }
	    return true;
	}
}
