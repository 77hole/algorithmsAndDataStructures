package projecteuler;

/**
 * @Description :
 * @Author : 汤璐蔚
 * @Date: 2020-09-03 17:34
 */

public class NO5 {
    public static void main(String[] args) {
        int i = 1;
        int count = 1;

        for(;i<=20;i++){
            if(count%i != 0){
                i = 1;
                count ++;
            }
        }
        System.out.println(count);
    }
}
