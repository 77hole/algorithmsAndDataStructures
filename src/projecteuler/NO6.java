package projecteuler;

/**
 * @Description :
 * @Author : 汤璐蔚
 * @Date: 2020-09-04 15:40
 */

public class NO6 {
    public static void main(String[] args) {
        int sum = 0;
        int sun2 = 0;
        for(int i = 1;i<=100;i++){
            sum += (int)Math.pow(i,2);
            sun2 += i;
        }
        int pow = (int)Math.pow(sun2, 2);
        int d = pow - sum;
        System.out.println(d);
    }
}
