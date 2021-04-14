package 算法第四版的学习.ThirdPara;

public class 基于无序链表的顺序查找 {

    /**
     * The type Sequential search st.
     *
     * @param <Key>   the type parameter
     * @param <Value> the type parameter
     *
     * 缺少了size(),keys(),delete()方法的实现，有时间挑战一下，对应书本第236-237页
     */
    public class SequentialSearchST<Key,Value>{

        private Node first;

        private class Node{//链表结点的定义

            Key key;
            Value val;
            Node next;

            public Node(Key key,Value val,Node next){
                this.key = key;
                this.val = val;
                this.next = next;
            }
        }

        public Value get(Key key){
            for(Node x = first;x != null;x = x.next)
                if(key.equals(x.key))
                    return x.val;
            return null;
        }

        public void put(Key key,Value val){
            for(Node x = first;x != null;x = x.next)
                if(key.equals(x.key)){
                    x.val = val;
                    return ;
                }
            first = new Node(key,val,first);
        }

    }

}
