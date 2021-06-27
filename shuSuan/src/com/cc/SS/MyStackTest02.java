package com.cc.SS;

/**
 * @ClassName MyStackTest02
 * @Description TODO
 * @Author Administrator
 * @Date 2021/6/25 17:57
 */
public class MyStackTest02 {
    public static void main(String[] args) {
        MyLinkStack stack = new MyLinkStack();

        System.out.println(stack.isEmpty());
        System.out.println(stack.getSize());

        stack.push("aa");
        stack.push("bb");
        stack.push("cc");
        stack.push("dd");

        System.out.println(stack);

        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack);
    }

}
