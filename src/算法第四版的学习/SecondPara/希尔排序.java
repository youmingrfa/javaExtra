package 算法第四版的学习.SecondPara;

public class 希尔排序 {
    public class Shell{
        public void sort(Comparable[] a){
            int N = a.length;
            int h = 1;
            while(h < N/3) h = 3*h+1;
            while(h>=1){
                for(int i=h;i<N;i++){
                    for(int j=i;j>=h&&less(a[j],a[j-h]);j-=h)
                        exch(a,j,j-h);
                }
                h/=3;
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
