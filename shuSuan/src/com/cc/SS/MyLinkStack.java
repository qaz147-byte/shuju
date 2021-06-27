package com.cc.SS;

/**
 * @ClassName MyLinkStack
 * @Description TODO
 * @Author Administrator
 * @Date 2021/6/25 17:45
 */
public class MyLinkStack implements MyStack{

    private Node top;
    private int size;

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public void push(Object e) {
        //根据元素结点，插入链表的头部
        Node pNode = new Node(e, top);
        //修改top栈顶指针指向新的结点
        top=pNode;
        size++;

    }

    @Override
    public Object pop() {
        if (size<1){
            throw new StackOverflowError("栈以空");
        }
        Object oldData=top.data;
        top=top.next;
        size--;
        return oldData;
    }

    @Override
    public Object peek() {
        if (size<1){
            throw new StackOverflowError("栈以空");
        }
        return top.data;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("[");
        for (Node pNode=top;pNode!=null;pNode=pNode.next){
            sb.append(pNode.data);
            if (pNode.next!=null){
                sb.append(",");
            }
        }

        sb.append("]");
        return sb.toString();
    }

    private class Node{
        Object data;  //存储数据
        Node next;    //存储下个结点

        public Node(Object data, Node next) {
            super();
            this.data = data;
            this.next = next;
        }
    }
}
