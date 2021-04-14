package 算法第四版的学习.SecondPara;

public class 堆排序 {
    /**
     * The type Heap sort.
     * 排序的思路：
     * 第一阶段先使用sink()排序前N/2元素获得整个数组中的最大的元素
     * 实质是先从倒数第二层和倒数第一层中找出最大的元素，然后在这些较大的元素中不断地上升比较，结束时最大元素位于数组第一个位置
     * 第二阶段是将最大的元素不断地交换到数组的尾部，数组遍历长度减一，然后使用sink()获得当前数组的最大元素，以此如此，直到元素只剩下一个，此时数组已经递增排序了
     * 这里需要注意：
     * 因为第一阶段已经将较大的元素放置在前N/2的位置了，所以可以将尾部元素sink()后得到此时数组的最大元素，也就是必须依赖第一阶段
     * 并不是sink()方法可以获得最大元素，sink()方法只是将一个元素类似插入排序，插到了合适的位置而已
     */
    public class heapSort{
        public void sort(Comparable[] a){
            int N = a.length;
            for(int k = N/2; k >= 1;k--)
                sink(a,k,N);
            while(N>1){
                exch(a,1,N--);
                sink(a,1,N);
            }
        }
        private void swim(Comparable[] a,int k){
            while(k > 1 && less(a,k/2,k)){
                exch(a,k/2,k);
                k = k/2;
            }
        }
        private void sink(Comparable[] a,int k,int N){
            while(2*k <= N){
                int j = 2*k;
                if(j < N &&less(a,j,j+1))     j++;
                if(!less(a,k,j))  break;
                exch(a,k,j);
                k = j;
            }
        }
        private boolean less(Comparable[] a,int i,int j){
            return a[i].compareTo(a[j]) < 0;
        }
        private void exch(Comparable[] a,int i,int j){
            Comparable t = a[i];
            a[i] = a[j];
            a[j] = t;
        }
    }
}
