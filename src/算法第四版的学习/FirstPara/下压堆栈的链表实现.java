package 算法第四版的学习.FirstPara;

import java.util.Iterator;

public class 下压堆栈的链表实现 {
    public class Stack<Item> implements Iterable<Item> {
        private Node first; //栈顶（最近添加的元素)
        private int N;      //元素数量
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
        public void push(Item item){//向栈顶添加元素
            Node oldfirst = first;
            first = new Node();
            first.item = item;
            first.next = oldfirst;
            N++;
        }
        public Item pop(){//从栈顶删除元素
            Item item = first.item;
            first = first.next;
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
