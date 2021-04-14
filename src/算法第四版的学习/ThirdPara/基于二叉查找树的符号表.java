package 算法第四版的学习.ThirdPara;

import java.util.Stack;

public class 基于二叉查找树的符号表 {

    /**
     * The type Bst.
     *
     * @param <Key>   the type parameter
     * @param <Value> the type parameter
     * 很难理解，但是加油！
     */
    public class BST<Key extends Comparable,Value>{

        private Node root;

        public class Node{
            private Key key;
            private Value val;
            private Node left,right;
            private int N;
            public Node(Key key,Value val,int N){
                this.key = key;this.val = val;this.N = N;
            }
        }

        public int size(){
            return size(root);
        }

        private int size(Node x){
            if(x == null)   return 0;
            else            return x.N;
        }

        public Value get(Key key){
            return get(root,key);
        }

        private Value get(Node x,Key key){
            if(x == null)   return null;
            int cmp = x.key.compareTo(key);
            if(cmp<0)       return get(x.right,key);
            else if(cmp>0)  return get(x.left,key);
            else            return x.val;
        }

        public void put(Key key,Value val){
            root = put(root,key,val);
        }

        private Node put(Node x,Key key,Value val){
            //如果key存在以x为根结点的子树中则更新它的值
            //否则将以key和val为键值对的新结点插入到该子树中
            if(x == null)   return new Node(key,val,1);
            int cmp = key.compareTo(x.key);
            if(cmp<0)   x.left = put(x.left,key,val);
            else if(cmp>0)  x.right =  put(x.right,key,val);
            else            x.val = val;

            x.N = size(x.left)+size(x.left)+1;
            return x;
        }

        public Key min(){
            return min(root).key;
        }

        private Node min(Node x){
            if(x.left == null)  return x;
            else                return min(x.left);
        }

        public Key max(){
            return max(root).key;
        }

        private Node max(Node x){
            if(x.right == null)     return x;
            else                    return max(x.right);
        }

        public Key floor(Key key){
            Node x = floor(root,key);
            if(x == null)   return null;
            else            return x.key;
        }

        private Node floor(Node x,Key key){
            if(x == null)   return null;
            int cmp = key.compareTo(x.key);
            if(cmp == 0)    return x;
            if(cmp<0)       return floor(x.left,key);
            Node t = floor(x.right,key);
            if(t != null)   return t;
            else            return x;
        }

        public Key ceiling(Key key){
            Node x = ceiling(root,key);
            if(x == null)   return null;
            else            return x.key;
        }

        private Node ceiling(Node x,Key key){
            if(x == null)   return null;
            int cmp = key.compareTo(x.key);
            if(cmp == 0)    return x;
            if(cmp>0)       return ceiling(x.right,key);
            Node t = ceiling(x.left,key);
            if(t != null)   return t;
            else            return x;
        }

        public Key select(int k){
            return select(root,k).key;
        }

        private Node select(Node x,int k){
            if(x == null)   return null;
            int t = size(x);
            if(t>k)         return select(x.left,k);
            else if(t<k)    return select(x.right,k);
            else            return x;
        }

        public int rank(Key key){
            return rank(root,key);
        }

        private int rank(Node x,Key key){
            if(x == null)   return 0;
            int cmp = key.compareTo(x.key);
            if(cmp<0)       return rank(x.left,key);
            else if(cmp>0)  return 1+size(x.left)+size(x.right);
            else            return size(x.left);
        }

        public void deleteMin(){
            root = deleteMin(root);
        }

        private Node deleteMin(Node x){
            if(x.left == null)  return x.right;
            x.left = deleteMin(x.left);
            x.N = size(x.left)+size(x.right)+1;
            return x;
        }

        public void delete(Key key){
            root = delete(root,key);
        }

        private Node delete(Node x,Key key){
            if(x == null)   return null;
            int cmp = key.compareTo(x.key);
            if(cmp<0)       x.left = delete(x.left,key);
            else if(cmp>0)  x.right = delete(x.right,key);
            else{
                if(x.right == null)     return x.left;
                if(x.left == null)      return x.right;
                Node t = x;
                x = min(t.right);
                x.right = deleteMin(t.right);
                x.left = t.left;
            }
            x.N = size(x.left)+size(x.right)+1;
            return x;
        }

        public Iterable<Key> keys(){
            return keys(min(),max());
        }

        public Iterable<Key> keys(Key lo,Key hi){
            Stack<Key> queue = new Stack<>();
            keys(root,queue,lo,hi);
            return queue;
        }

        private void keys(Node x, Stack<Key> queue,Key lo,Key hi){
            if(x == null) return;
            int cmplo = lo.compareTo(x.key);
            int cmphi = hi.compareTo(x.key);
            if(cmplo<0)     keys(x.left,queue,lo,hi);
            if(cmplo<=0 && cmphi >= 0)  queue.push(x.key);
            if(cmphi>0)                 keys(x.right,queue,lo,hi);
        }

    }

}
