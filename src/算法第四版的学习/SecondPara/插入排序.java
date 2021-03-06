package 算法第四版的学习.SecondPara;

public class 插入排序 {
    public class Insertion{
        public void sort(Comparable[] a){
            int N = a.length;
            for(int i=1;i<N;i++){
                for(int j=i;j>0&&less(a[j],a[j-1]);j--)
                    exch(a,j,j-1);
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
