package 算法第四版的学习.SecondPara;

public class 快速排序 {
    public class Quick{
        public void sort(Comparable[] a){
            sort(a,0,a.length-1);
        }

        private void sort(Comparable[] a,int lo,int hi){
            if(hi<=lo)  return;
            int j = partition(a,lo,hi);
            sort(a,lo,j-1);     //排序数组左半部分
            sort(a,j+1,hi);     //排序数组右半部分
        }

        private int partition(Comparable[] a,int lo,int hi){
            int i = lo,j = hi+1;
            Comparable v = a[lo];
            while(true){
                while(less(a[++i],v))   if(i == hi) break;
                while(less(v,a[--j]))   if(j == lo) break;
                if(i >= j)  break;
                exch(a,i,j);
            }
            exch(a,lo,hi);
            return j;
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
