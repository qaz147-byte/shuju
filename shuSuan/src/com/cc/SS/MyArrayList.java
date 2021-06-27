package com.cc.SS;

/**
 * @ClassName MyArrayList
 * @Description TODO
 * @Author Administrator
 * @Date 2021/6/24 9:09
 */
public class MyArrayList implements MyList {

    private Object[] elements;
    private static final int DEFAULT_CAPACITY=16;
    private int size;

    public MyArrayList() {
        elements=new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(int initialCapacity) {
        elements=new Object[initialCapacity];
    }

    //返回元素的个数
    @Override
    public int getSize() {
        return size;
    }

    //判断线性表是否为空
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    //在线性表的i位置插入元素e
    @Override
    public void insert(int i, Object e) {
        if (i<0 || i>size){
            throw new IndexOutOfBoundsException(i+"越界");
        }
        //如果数组已经满了，对数组进行扩容
        if (size >=elements.length){
            expandSpace();
        }
        //从i开始，把元素往后移
        for (int j=size;j>i;j--){
            elements[j]=elements[j-1];
        }
        //把元素e存储到i位置
        elements[i]=e;
        //把元素的个数增1
        size++;


    }

    //数组扩容
    private void expandSpace(){
        //定义一个更大的数组
       Object[] newElements= new Object[elements.length*2];
       //把原来数据的内容复制到新的数组中
        for (int i=0;i<elements.length;i++){
            newElements[i]=elements[i];
        }
       //把原来的数组名指向新数组
        elements=newElements;

    }

    //判断当前线性表是否包含元素e
    @Override
    public boolean contains(Object e) {
        return indexOf(e)>=0;
    }

    @Override
    public int indexOf(Object e) {
        //遍历数组
        if (e==null) {
        for (int i=0;i<size;i++){
           if (elements[i]==null){
                return i;
           }
         }
        }else {
            for (int i = 0; i < size; i++) {
                if (e.equals(elements[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    //删除线性表中第一个与e相同的元素
    @Override
    public Object remove(Object e) {
        //获得线性表中的索引值
        int index = indexOf(e);
        if (index<0){
            return null;
        }
        return remove(index);
    }
    //删除指定索引值的元素
    @Override
    public Object remove(int i) {
        //判断i是否越界
        if (i<0 || i>=size){
            throw new IndexOutOfBoundsException(i+"越界");
        }
        //把要删除的元素保存起来
        Object old = elements[i];

        for (int j=i;j<size-1;j++)
        {
            elements[j]=elements[j+1];
        }
        //把最后的元素置为null
        elements[size-1]=null;
        //修改元素个数
        size--;
        return old;
    }

    //把索引值为i的元素替换为e
    @Override
    public Object replace(int i, Object e) {
        if (i<0 || i>=size) {
            throw new IndexOutOfBoundsException(i + "越界");
        }
        Object old = elements[i];
        //替换
        elements[i]=e;
        return old;
    }
    //返回指定位置的元素
    @Override
    public Object get(int i) {
        if (i<0 || i>=size) {
            throw new IndexOutOfBoundsException(i + "越界");
        }
        return elements[i];
    }

    //在指定元素p之前插入元素e
    @Override
    public boolean insertBefore(Object p, Object e) {
        //确定元素p在线性表中的位置
        int index = indexOf(p);
        if (index<0){
            return false;
        }
        //插入元素
        insert(index,e);
        return true;
    }

    @Override
    public boolean insertAfter(Object p, Object e) {

        //确定元素p在线性表中的位置
        int index = indexOf(p);
        if (index<0){
            return false;
        }
        //插入元素
        insert(index+1,e);
        return true;
    }

    //重写toString方法
    @Override
    public String toString() {
        //把线性表当中的每个元素连接起来
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i=0;i<size;i++){
            sb.append(elements[i]);
            if ( i< size-1){
                sb.append(",");
            }
        }
        sb.append("]");

        return sb.toString();
    }
}
