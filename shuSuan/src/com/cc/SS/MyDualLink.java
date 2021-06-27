package com.cc.SS;

/**
 * @ClassName MyDualLink
 * @Description TODO
 * @Author Administrator
 * @Date 2021/6/24 16:36
 */
public class MyDualLink implements MyList {
    //定义头结点
    private Node first;
    //定义尾结点
    private Node last;
    //保存元素个数
    private int size;

    private void checkIndex(int i){
        if (i<0||i>size){
            throw new IndexOutOfBoundsException(i+"越界");
        }
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public void insert(int i, Object e) {
        checkIndex(i);
        if (i==0){
            addFirst(e);
        }else if (i==size){
            addLast(e);
        }else {
            Node pNode=getNode(i);
            Node preNode=pNode.prev;
            Node newNode = new Node(e, preNode, pNode);
            preNode.next=newNode;
            pNode.prev=newNode;
            size++;
        }
    }

    //在i结点出添加
    private Node getNode(int i) {
        Node pNode=first;
        for (int x=0;x<i;x++){
            pNode=pNode.next;

        }
        return pNode;
    }

    @Override
    public boolean contains(Object e) {
        return indexOf(e)>=0;
    }

    @Override
    public int indexOf(Object e) {
        int i=0;
        if (e==null){
            for (Node pNode=first;pNode !=null;pNode=pNode.next){
                if (pNode.data==null){
                    return i;
                }
                i++;
            }
        }else {
            for (Node pNode=first;pNode !=null;pNode=pNode.next){
                if (e.equals(pNode.data)){
                    return i;
                }
                i++;
            }
        }
        return -1;
    }
    //从链表中删除元素e的索引值
    @Override
    public Object remove(Object e) {
        int index=indexOf(e);
        if (index<0){
            return null;
        }

        return remove(index);
    }
    //从链表中删除指定索引值的元素，并返回删除的元素
    @Override
    public Object remove(int i) {
        checkIndex(i);
        Node pNode=getNode(i);

        Node prevNode = pNode.prev;
        Node nextNode = pNode.next;

        if (prevNode==null){
            first=nextNode;
        }else {
            prevNode.next=nextNode;
        }
        if (nextNode==null){
            last=prevNode;
        }else {
            nextNode.prev=prevNode;
        }

        size--;
        return pNode.data;
    }

    //修改指定索引值的元素
    @Override
    public Object replace(int i, Object e) {
        checkIndex(i);
        Node pNode=getNode(i);

        Object oldData = pNode.data;
        pNode.data=e;
        return oldData;

    }

    //返回指定索引值
    @Override
    public Object get(int i) {
        checkIndex(i);
        Node pNode=getNode(i);

        return pNode.data;
    }

    @Override
    public boolean insertBefore(Object p, Object e) {
        int index=indexOf(p);
        if (index<0){
            return false;
        }
        insert(index,e);
        return true;
    }

    @Override
    public boolean insertAfter(Object p, Object e) {

        int index=indexOf(p);
        if (index<0){
            return false;
        }
        insert(index+1,e);
        return true;
    }

    private class Node{
        Object data;
        Node prev;
        Node next;

        public Node(Object data, Node prev, Node next) {
            super();
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        for (Node node=first;node!=null;node=node.next){
         sb.append(node.data);
         if (node!=last){
             sb.append(",");
         }
        }
        sb.append("]");
        return sb.toString();
    }

    //在尾部添加元素
    public void addLast(Object e) {
        Node pNode=last;
        Node newNode = new Node(e, last, null);
        if (pNode==null){
            first=newNode;
        }else {
            pNode.next=newNode;
        }
        last=newNode;
        size++;

    }

    //在头部添加元素e
    public void addFirst(Object e) {
        Node pNode=first;
        Node newNode = new Node(e, null, first);
        first=newNode;
        if (pNode==null){
            last=newNode;
        }else {
            pNode.prev=newNode;
        }
        size++;
    }

    //删除第一个元素
    public Object removeFirst(){
        return remove(0);
    }
    //删除最后一个元素
    public Object removeLast(){
        return remove(size-1);
    }
    //返回头元素
    public Object getFirst(){
        return get(0);
    }
    //返回最后一个元素
    public Object getLast(){
        return get(size-1);
    }

}
