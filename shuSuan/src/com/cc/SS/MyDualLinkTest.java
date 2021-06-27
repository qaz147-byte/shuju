package com.cc.SS;

import javax.xml.bind.SchemaOutputResolver;

/**
 * @ClassName MyDualLinkTest
 * @Description TODO
 * @Author Administrator
 * @Date 2021/6/24 17:18
 */
public class MyDualLinkTest {
    public static void main(String[] args) {
        MyDualLink myDualLink = new MyDualLink();

        System.out.println(myDualLink.getSize());
        System.out.println(myDualLink.isEmpty());

        myDualLink.insert(0,"aa");
        myDualLink.insert(0,"bb");
        myDualLink.insert(0,"cc");
        myDualLink.insert(0,"dd");

        System.out.println(myDualLink);


        System.out.println("============");
        System.out.println(myDualLink.indexOf("aa"));
        System.out.println(myDualLink.indexOf("bb"));
        System.out.println(myDualLink.indexOf("cc"));
        System.out.println(myDualLink.indexOf("qq"));
        System.out.println(myDualLink);

        System.out.println("=====");
        System.out.println(myDualLink.remove(0));
        System.out.println(myDualLink);

        System.out.println("==========");
        myDualLink.replace(0,"qq");
        System.out.println(myDualLink.get(1));
        System.out.println(myDualLink);

        System.out.println("=========");

        myDualLink.insertBefore("bb","xx");
        myDualLink.insertAfter("bb","yy");
        System.out.println(myDualLink);

        System.out.println("=========");
        myDualLink.addFirst("TT");
        myDualLink.addLast("MM");
        System.out.println(myDualLink);
        System.out.println(myDualLink.getFirst());
        System.out.println(myDualLink.getLast());
        System.out.println(myDualLink.removeFirst());
        System.out.println(myDualLink.removeLast());
        System.out.println(myDualLink);
    }

}
