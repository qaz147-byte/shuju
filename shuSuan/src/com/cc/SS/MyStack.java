package com.cc.SS;

public interface MyStack {

    int getSize();
    boolean isEmpty();
    void push(Object e); //压栈、入栈
    Object pop();        //弹栈、出栈
    Object peek();       //返回栈顶元素
}
