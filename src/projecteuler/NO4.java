package projecteuler;

/**
 * @Description :
 * @Author : 汤璐蔚
 * @Date: 2020-09-02 20:34
 */

public class NO4 {
    public static void main(String[] args) {
        int i = 901;
        for (;i<1000;i++){
            for (int j = 900;j<1000;j++){
                int sum = i*j;
                for (int k = 1;k<=3 ;k++){
                    //---------------------获取前半段---------------------------
                    //获取被取模数
                    int data1 = (int)((int)(sum/Math.pow(10,k))*Math.pow(10,k));
                    //获取子位
                    int data2 = sum%data1;
                    //截取需要对比的数字
                    int data3 = (int)(data2 /Math.pow(10,k-1));
                    //---------------------获取后半段---------------------------
                    //获取被取模数
                    int data4 = (int)(sum/Math.pow(10,6-k));
                    //获取子位
                    int data5 =  0;
                    if(k-1 == 0){}else {
                        data5 =  (int)((int)(data4/Math.pow(10,k-1))*Math.pow(10,k-1));
                    }
                    int data6 = (int)data4;
                    //截取需要对比的数字
                    if(data5 != 0){
                        data6  = (int)(data4%data5);
                    }

                    if(data3 != data6){
                        break;
                    }
                    if (k==3){
                        System.out.println(sum);
                    }
                }
            }
        }
    }
}
