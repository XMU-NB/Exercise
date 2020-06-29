package cn.edu.vivo;
/**
 * 输入：n s
 * 输出：可以插入的方案
 * <p>
 * 举个栗子：
 * <p>
 * 输入：
 * 5
 * 10000
 * 输出：
 * 2
 * 10101
 */

import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int a = in.nextInt();
            String s1 = in.next();
            char[] s = s1.toCharArray();
            int n = 0;
            if(s1.length()<=2){
                if (s1.equals("0")||s1.equals("00")) n++;
            }else {
                for (int i = 0; i < s.length; i++) {
                    if (i == 0 && s[i + 1] == '0' && s[i] == '0') {
                        s[i] = '1';
                        n++;
                    }

                    if (i < s.length - 1 && i > 0) {
                        char c1 = s[i - 1];
                        char c2 = s[i];
                        char c3 = s[i + 1];
                        if (c1 == '0' && c3 == '0' && c2 == '0') {
                            s[i] = '1';
                            n++;
                        }
                    }

                    if (i == s.length - 1 && s[i - 1] == '0' && s[i] == '0') {
                        s[i] = '1';
                        n++;
                    }
                }
            }
            System.out.println(n);
        }
    }
}