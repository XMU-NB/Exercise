package cn.edu.vivo;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author NieBin
 * @create 2020-06-07 17:11
 */
public class CeShi {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        while (in.hasNext()) {
//            //int i = in.nextInt()
//            String s1 = in.next();
//            String s2 = in.nextLine();
//            //System.out.println(i);
//            System.out.println(s1);
//            System.out.println(s2);
//        }

        int[][] a = {{1,2},{2,3},{3,3}};
        int[] b = new int[5];
        Arrays.fill(b,0);
        b[1] = 2;
        //Arrays.fill(b,0,1,2);
        System.out.println(Arrays.toString(b));
        System.out.println(Arrays.binarySearch(b,2));
        List<int[]> ints = Arrays.asList(a);
        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt));
        }
    }
}
