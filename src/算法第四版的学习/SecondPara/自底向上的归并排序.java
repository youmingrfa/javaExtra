package 算法第四版的学习.SecondPara;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.CompareGenerator;

public class 自底向上的归并排序 {
    public class Merge{
        private Comparable[] aux;
        public void sort(Comparable[] a){
            int N = a.length;
            aux = new Comparable[N];
            for(int sz = 1; sz < N; sz = sz+sz){
                for(int lo=0;lo<N-sz;lo+=sz+sz)
                    merge(a,lo,lo+sz-1,Math.min(lo+sz+sz-1,N-1));
            }
        }
        private void merge(Comparable[] a,int lo,int mid,int hi){
            int i = lo,j = mid+1;
            for(int k=0;k<=hi;k++)
                aux[i] = a[i];
            for(int k = lo;k<=hi;k++){
                if(i>mid)                       a[k] = aux[j++];
                else if(j>hi)                   a[k] = aux[i++];
                else if(less(aux[j],aux[i]))    a[k] = aux[j++];
                else                            a[k] = aux[i++];
            }
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
