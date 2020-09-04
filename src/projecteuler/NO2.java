package projecteuler;

/**
 * @Description :
 * @Author : 汤璐蔚
 * @Date: 2020-09-02 20:05
 */

public class NO2 {
    public static void main(String[] args) {
        int i = 1;
        int j = 1;
        int sum = 0;
        while (i < 4000000){
            int tep = i; //将上一次和缓存
            i  = i+j;
            if(i%2 == 0){
                sum += i;
            }
            j = tep; //将缓存值赋值给后一位
        }
        System.out.println(sum);
    }
}
