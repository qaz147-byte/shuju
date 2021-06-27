package com.cc.SS;

public interface MyList {
    int getSize();  //返回线性表中的个数
    boolean isEmpty();
    void insert(int i,Object e);
    boolean contains(Object e);
    int indexOf(Object e);
    Object remove(Object e); //在线性表中第一个与e相同的元素，并返回该元素
    Object remove(int i);
    Object replace(int i,Object e);
    Object get(int i);
    boolean insertBefore(Object p,Object e);//在元素p之前插入元素e
    boolean insertAfter(Object p,Object e);

}
