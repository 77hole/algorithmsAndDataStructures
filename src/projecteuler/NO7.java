package projecteuler;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description :
 * @Author : 汤璐蔚
 * @Date: 2020-09-04 15:59
 */

public class NO7 {
    static List<Integer> pool = new ArrayList<>();

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int count  = 0;
        boolean flag =false;
        int i = 1;
        while (count != 10000){
            i = i+2;  //加2.偶数必然不会是质数。能直接删除一半的基数
            for (int num:pool) {
                if (i%num == 0) {
                    flag = true;
                    break;
                }
            }
            if(!flag){
                pool.add(i);
                count++;
            }else {
                flag = false;
            }
        }
        System.out.println(i);

        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
/*
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int antal = 0;

        int testtal = 2;
        int test = 2;
        for ( ; antal != 10001 ; test++)
        {
            testtal = 2;

            for ( ; testtal <= test ; testtal++)
            {
                if (test % testtal == 0 && testtal != test)
                { break; }

                else if (testtal == test)
                { antal += 1; }

            }
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }*/
}
