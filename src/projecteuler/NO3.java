package projecteuler;

/**
 * @Description :
 * @Author : 汤璐蔚
 * @Date: 2020-09-02 20:20
 */

public class NO3 {
    public static void main(String[] args) {
        long data = 600851475143L;
        int i = 1;
        while (i != data){
            i++;
            if (data%i==0){
                System.out.println(i);
                data = data/i;
                i = 1;
            }
        }
    }
}
