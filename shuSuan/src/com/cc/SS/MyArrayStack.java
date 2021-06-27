package com.cc.SS;

/**
 * @ClassName MyArrayStack
 * @Description TODO
 * @Author Administrator
 * @Date 2021/6/25 17:14
 */
public class MyArrayStack implements MyStack {

    private Object[] elements;
    private static final int DEFAULT_CAPACITY=16;
    private int top;    //栈顶指针

    //构造无参构造，默认初始化
    public MyArrayStack() {
        elements = new Object[DEFAULT_CAPACITY];
    }
    //在构造方法中，指定堆栈的初始化大小
    public MyArrayStack(int initialCapcity){
        elements=new Object[initialCapcity];
    }


    @Override
    public int getSize() {
        return top;
    }

    @Override
    public boolean isEmpty() {
        return top<=0;
    }

    @Override
    public void push(Object e) {
        //判断堆栈是否已满，如果堆栈已满，数组需要扩容
        if (top>=elements.length) {
            //定义一个更大的数组
           Object[] newData=new Object[elements.length*2];
            //把原来的数组内容复制到大的数组
            for (int i=0;i<elements.length;i++){
                newData[i]=elements[i];
            }
            //让原来的数组名指向新的数组
            elements=newData;
        }
        //把元素存储到栈顶指针指向的位置
        elements[top]=e;
        //栈顶指针上移
        top++;
    }

    @Override
    public Object pop() {
        if (top<=0){
            throw new StackOverflowError("栈以空");
        }
        top--;
        return elements[top];
    }

    @Override
    public Object peek() {
        if (top<=0) {
            throw new StackOverflowError("栈以空");
        }
        return elements[top-1];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("[");
        for (int i=top-1;i>=0;i--){
           sb.append(elements[i]);
           if (i>0){
               sb.append(",");
           }

        }

        sb.append("]");
        return sb.toString();
    }
}
