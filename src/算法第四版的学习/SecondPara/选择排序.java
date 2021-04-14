package 算法第四版的学习.SecondPara;

public class 选择排序 {
    public class Selection{
        public void sort(Comparable[] a){
            int N = a.length;
            for(int i=0;i<N;i++){
                int min = i;
                for(int j=i;j<N;j++)
                    if(less(j,min))     min = j;
                exch(a,i,min);
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
