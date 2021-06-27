package com.cc.SS;

/**
 * @ClassName MyStackTest
 * @Description TODO
 * @Author Administrator
 * @Date 2021/6/25 17:24
 */
public class MyStackTest {
    public static void main(String[] args) {
        MyArrayStack stack = new MyArrayStack();

        System.out.println(stack.isEmpty());
        System.out.println(stack.getSize());

        stack.push("aa");
        stack.push("bb");
        stack.push("cc");
        stack.push("dd");
        System.out.println(stack);

        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack);
    }

}
