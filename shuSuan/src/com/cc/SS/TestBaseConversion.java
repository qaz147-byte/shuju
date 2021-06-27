package com.cc.SS;

/**
 * @ClassName 将十进制数转化为二进制数
 * @Description TODO
 * @Author Administrator
 * @Date 2021/6/26 13:18
 */
public class TestBaseConversion {
    public static void main(String[] args) {
        System.out.println(convert(1000,2));
    }

    public static String convert(int num,int decimal){
        //保存余数
        MyArrayStack stack = new MyArrayStack();
        int remainder=num % decimal;
        while (num!=0){
            stack.push(remainder);
            num=num/decimal;
            remainder=num % decimal;
        }
        //出栈，余数倒序
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.toString();


    }

}
