package 算法第四版的学习.SecondPara;

public class 三向切分的快速排序 {
    public class Quick3way{
        private void sort(Comparable[] a,int lo,int hi){
            if(hi <= lo)    return;
            int lt = lo,i = lo+1,gt = hi;
            Comparable v = a[lo];
            while(i <= gt){
                int cmp = a[i].compareTo(v);
                if(cmp < 0)         exch(a,lt++,i++);
                else if(cmp > 0)    exch(a,i,gt--);
                else                i++;
            }
            sort(a,lo,lt-1);
            sort(a,gt+1,hi);
        }
        private boolean less(Comparable v,Comparable w){
            return v.compareTo(w)<0;
        }
        private void exch(Comparable[] a,int i,int j){
            Comparable t= a[i];
            a[i] = a[j];
            a[j] = t;
        }
    }
}
