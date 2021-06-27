package com.cc.SS;

import sun.java2d.pipe.AAShapePipe;

import java.util.Arrays;

/**
 * @ClassName MyArrayTest
 * @Description TODO
 * @Author Administrator
 * @Date 2021/6/24 10:06
 */
public class MyArrayTest {
    public static void main(String[] args) {
        MyArrayList list1 = new MyArrayList();

        System.out.println(list1.isEmpty());
        System.out.println(list1.getSize());

        //添加元素
        list1.insert(0,"aa");
        list1.insert(1,"bb");
        list1.insert(2,"cc");

        System.out.println(list1.isEmpty());
        System.out.println(list1.getSize());

        //把线性表中的值打印出来
        System.out.println(list1);
        System.out.println("=============");
        //元素的索引值
        System.out.println(list1.indexOf("aa"));
        System.out.println(list1.indexOf("bb"));
        System.out.println(list1.indexOf("cc"));
        System.out.println(list1.contains("aa"));
        System.out.println(list1.contains("bb"));

        //删除
        list1.remove("dd");
        System.out.println(list1);
        list1.remove("bb");
        System.out.println(list1);
        list1.remove(0);
        System.out.println(list1);

        System.out.println("=======");
        list1.insert(0,"qq");
        list1.insert(0,"ww");
        list1.insert(0,"ee");
        System.out.println(list1);
        list1.replace(0,"YY");
        System.out.println(list1);

        //返回指定索引值
        System.out.println(list1.get(0));
        System.out.println(list1.get(1));
        System.out.println(list1.get(2));
        System.out.println(list1);

        //前插和后插
        System.out.println("==========");
        list1.insertBefore("ww", "aa");
        System.out.println(list1);
        list1.insertAfter("ww","oo");
        System.out.println(list1);
        list1.insertAfter("TT","BB");
        System.out.println(list1);
        list1.insertAfter("PP","CC");
        System.out.println(list1);
    }

}
