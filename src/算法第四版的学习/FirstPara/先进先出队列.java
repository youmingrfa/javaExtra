package 算法第四版的学习.FirstPara;

import java.util.Iterator;

public class 先进先出队列 {
    public class Queue<Item> implements Iterable<Item> {
        private Node first;//指向最早添加的结点的链接
        private Node last;//指向最近添加的结点的链接
        private int N;//队列中的元素数量
        private class Node{//定义了结点的嵌套类
            Item item;
            Node next;
        }
        public boolean isEmpty(){
            return N==0;
        }
        public int size(){
            return N;
        }
        public void enqueue(Item item){//向表尾添加元素
            Node oldlast = last;
            last = new Node();
            last.item = item;
            last.next = null;
            if(isEmpty())   first = last;
            else            oldlast.next = last;
            N++;
        }
        public Item dequeue(){//从表头删除元素
            Item item = first.item;
            first = first.next;
            if(isEmpty())   last = null;
            N--;
            return item;
        }
        @Override
        public Iterator<Item> iterator() {
            return new ListIterator();
        }
        private class ListIterator implements Iterator<Item> {//支持后进先出的迭代
            private Node current = first;
            @Override
            public boolean hasNext(){
                return current!=null;
            }
            @Override
            public Item next(){
                Item item = current.item;
                current = current.next;
                return item;
            }
            @Override
            public void remove(){

            }
        }
    }
}
