package 算法第四版的学习.SecondPara;

public class 基于堆的优先队列 {

    /**
     * The type Max pq.
     * @param <Key> the type parameter
     * 主要实现优先队列：插入元素和删除最大元素
     * insert()思路是首先插入一个元素到数组的最后一个。然后上浮（swim）到合适的位置，则堆的有序化恢复
     * delMax()思路是首先获得数组第一个元素，然后将数组的最后一个元素放到第一个位置上，然后下沉（sink）到合适的位置，则堆的有序化恢复
     * swim()思路是将一个元素不断地与k/2位置上的元素（父结点）进行比较，大于则交换，继续比较，小于等于则停止；或已经到达数组的第一个位置
     * sink()思路是将一个元素不断地与2*k和2*k+1位置上的最大元素进行比较，小于则交换，继续比较，小于等于则停止‘或已经到达数组的最后一个位置
     */
    public class MaxPQ<Key extends Comparable<Key>>{

        private Key[] pq;
        private int N = 0;

        public MaxPQ(int maxN){
            pq = (Key[]) new Comparable[maxN+1];
        }

        public boolean isEmpty(){
            return pq.length == 0;
        }

        public int size(){
            return pq.length;
        }

        public void insert(Key v){
            pq[++N] = v;
            swim(N);
        }
        public Key delMax(){
            Key max = pq[1];
            exch(1,N--);
            pq[N+1] = null; //避免对象游离
            sink(1);
            return max;
        }
        private void swim(int k){
            while(k > 1 && less(k/2,k)){
                exch(k/2,k);
                k = k/2;
            }
        }
        private void sink(int k){
            while(2*k <= N){
                int j = 2*k;
                if(j < N &&less(j,j+1))     j++;
                if(!less(k,j))  break;
                exch(k,j);
                k = j;
            }
        }
        private boolean less(int i,int j){
            return pq[i].compareTo(pq[j]) < 0;
        }
        private void exch(int i,int j){
            Key t = pq[i];
            pq[i] = pq[j];
            pq[j] = t;
        }
    }
}
