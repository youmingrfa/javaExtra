package 算法第四版的学习.SecondPara;

public class 自顶向下的归并排序 {
    public class Merge{
        private Comparable[] aux;
        public void sort(Comparable[] a){
            aux = new Comparable[a.length];

        }
        private void sort(Comparable[] a,int lo,int hi){
            if(hi<=lo)      return;
            int mid = lo+(hi-lo)/2;
            sort(a,lo,mid);
            sort(a,mid+1,hi);
            sort(a,lo,hi);
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
