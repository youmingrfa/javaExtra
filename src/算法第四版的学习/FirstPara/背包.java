package 算法第四版的学习.FirstPara;

import java.util.Iterator;

public class 背包 {
    public class Bag<Item> implements Iterable<Item> {
        private Node first;//链表的首结点
        private class Node{//定义了结点的嵌套类
            Item item;
            Node next;
        }
        public void add(Item item){
            Node oldfirst = first;
            first.item = item;
            first.next = oldfirst;
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
