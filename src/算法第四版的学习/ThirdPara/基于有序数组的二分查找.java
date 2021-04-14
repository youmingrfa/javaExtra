package 算法第四版的学习.ThirdPara;

import java.util.Stack;

public class 基于有序数组的二分查找 {

    public class BinarySearchST<Key extends Comparable<Key>, Value>{

        private Key[] keys;
        private Value[] vals;
        private int N;

        public BinarySearchST(int capacity){
            keys = (Key[]) new Comparable[capacity];
            vals = (Value[]) new Object[capacity];
        }

        public int size(){
            return N;
        }

        public boolean isEmpty(){
            return N == 0;
        }

        public Value get(Key key){
            if(isEmpty())   return null;
            int i = rank(key);
            if(i<N && keys[i].compareTo(key) == 0)  return vals[i];
            else                                    return null;
        }

        public void put(Key key,Value val){
            int i = rank(key);
            if(i<N && keys[i].compareTo(key) == 0){
                vals[i] = val;
                return;
            }
            for(int j = N;j>i;j--){
                keys[j] = keys[j-1];
                vals[j] = vals[j-1];
            }
            keys[i] = key;vals[i] = val;
            N++;
        }

        public void delete(Key key){
            int i = rank(key);
            if(i<N && key.compareTo(keys[i]) != 0)  return ;
            for(int j = i;j<N-1;j++){
                keys[j] = keys[j+1];
                vals[j] = vals[j+1];
            }
            N--;
        }

        //非递归版本
        public int rank(Key key){
            int lo = 0,hi = N-1;
            while(lo<=hi){
                int mid = lo+ (hi-lo)/2;
                int cmp = key.compareTo(keys[mid]);
                if(cmp<0)       hi = mid-1;
                else if(cmp>0)  lo = mid+1;
                else            return mid;
            }
            return lo;
        }

        //递归版本
        public int recursionRank(Key key,int lo,int hi){
            if(hi<lo)   return lo;
            int mid = lo+(hi-lo)/2;
            int cmp = key.compareTo(keys[mid]);
            if(cmp>0)       return recursionRank(key,mid+1,hi);
            else if(cmp<0)  return recursionRank(key,lo,mid-1);
            else return mid;
        }

        public boolean contains(Key key){
            for(int i=0;i<N;i++)
                if(key.compareTo(keys[i]) == 0)
                    return true;
            return false;
        }

        public Key min(){
            return keys[0];
        }

        public Key max(){
            return keys[N-1];
        }

        public Key select(int k){
            return keys[k];
        }

        public Key ceiling(Key key){
            int i = rank(key);
            return keys[i];
        }

        public Key floor(Key key){
            int i = rank(key);
            if(key.compareTo(keys[i]) == 0)     return key;
            if(i>0)     return keys[i-1];
            else        return null;
        }

        public Iterable<Key> keys(Key lo,Key hi){
            Stack<Key> s = new Stack<Key>();
            for(int i=rank(lo);i<rank(hi);i++)
                s.push(keys[i]);
            if(contains(hi))
                s.push(keys[rank(hi)]);
            return s;
        }

    }

}
