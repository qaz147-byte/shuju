package com.cc.SS;


/**
 * @ClassName MySingleList
 * @Description TODO
 * @Author Administrator
 * @Date 2021/6/24 15:06
 */
public class MySingleList implements MyList {
    private Node head;
    private int size;


    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    //在线性表中插入元素

    @Override
    public void insert(int i, Object e) {
        //判断索引值是否越界
        if (i < 0 || i > size) {
            throw new IndexOutOfBoundsException(i + "越界");
        }
        Node newNode = new Node(e, null);
        //头结点为null的情况，链表不存在
        if (head == null) {
            head = newNode;
        } else {
            if (i == 0) {
                //在0的位置插入结点
                newNode.next = head;
                head = newNode;
            } else {
                Node pNode = head;
                for (int x = 1; x < i; x++) {
                    pNode = pNode.next;
                }
                newNode.next = pNode.next;
                pNode.next = pNode;
            }
            //元素个数加0
            size++;
        }
    }


        @Override
        public boolean contains (Object e){

            return indexOf(e)>=0;
        }

        //返回元素e在线性表中第一次出现的索引值
        @Override
        public int indexOf (Object e){
            int i=0;
             Node pNode=head;
             while (pNode !=null){
                 if (e==null &&pNode.data==null){
                     return i;
                 }else if (e!=null && e.equals(pNode.data)){
                    return i;
                 }
                 i++;
                 pNode=pNode.next;
             }
            return -1;
        }

        //从线性表中删除第一个与e相同的元素
        @Override
        public Object remove (Object e){
            int index=indexOf(e);
            if (index<0){
                return null;
            }
            return remove(index);
        }

        //从线性表中删除指定索引的元素
        @Override
        public Object remove ( int i){
            //判断是否越界
            if (i<0 ||i>size){
                throw new IndexOutOfBoundsException(i+"越界");
            }
            Node pNode=head;
            //删除头结点
            if (i==0) {
                head = head.next;
                size--;
                return pNode.data;
            }
            //找到i-1结点
            for (int x=1;x<i;i++){
                pNode=pNode.next;
            }
            Object old=pNode.next.data;
            pNode.next=pNode.next.next;
            size--;

            return old;
        }

        @Override
        public Object replace ( int i, Object e){
            //判断是否越界
            if (i<0 ||i>size){
                throw new IndexOutOfBoundsException(i+"越界");
            }
            //找到i结点
            Node pNode=getNode(i);
            Object old=pNode.data;
            pNode.data=e;
            return old;
        }

        @Override
        public Object get ( int i){
            //判断是否越界
            if (i<0 ||i>size){
                throw new IndexOutOfBoundsException(i+"越界");
            }
            Node pNode=getNode(i);
            return pNode.data;
        }

        private Node getNode(int i){
            if (i<0||i>size){
                return null;
            }
            if (i==0){
                return head;
            }
            //找到i结点
            Node pNode=head;
            for (int x=1;x<i;x++){
                pNode=pNode.next;
            }
            return pNode;
    }

    //在指定元素p前面插入元素e
        @Override
        public boolean insertBefore (Object p, Object e){
        //找p的位置
            int index=indexOf(p);
            if (index<0){
                return false;
            }
            insert(index,e);
            return true;
        }

        @Override
        public boolean insertAfter (Object p, Object e){
            //找p的位置
            int index=indexOf(p);
            if (index<0){
                return false;
            }
            insert(index+1,e);
            return true;
        }


        @Override
        public String toString () {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            Node pNode = head;//临时变量
            while (pNode != null) {
                sb.append(pNode.data);
                if (pNode.next != null) {
                    sb.append(",");
                }
                pNode = pNode.next;  //指针下移
            }

            sb.append("]");

            return sb.toString();
        }

        //定义一个内部类表示单向链表中结点
        private class Node {
            Object data;
            Node next;

            public Node(Object data, Node next) {
                super();
                this.data = data;
                this.next = next;
            }
        }

    }

