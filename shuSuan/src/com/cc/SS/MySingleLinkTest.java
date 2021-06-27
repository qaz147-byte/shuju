package com.cc.SS;

/**
 * @ClassName MySingleLinkTest
 * @Description TODO
 * @Author Administrator
 * @Date 2021/6/24 15:25
 */
public class MySingleLinkTest {

    public static void main(String[] args) {
        MySingleList link = new MySingleList();

        System.out.println(link.getSize());
        System.out.println(link.isEmpty());

        link.insert(0,"aa");
        link.insert(0,"bb");
        link.insert(0,"cc");
        System.out.println(link);

        System.out.println(link.indexOf("aa"));
        System.out.println(link.indexOf("bb"));
        System.out.println(link.indexOf("xx"));
        System.out.println(link);

        System.out.println("=============");
        System.out.println(link.remove("xx"));
        System.out.println(link.remove("bb"));
        System.out.println(link);

        System.out.println("===========");
        System.out.println(link.get(0));
        System.out.println(link.replace(0,"CC"));
        System.out.println(link);

        System.out.println("=========");
        System.out.println(link.insertBefore("CC","XX"));
        System.out.println(link);
    }
}
