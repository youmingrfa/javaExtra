package 算法第四版的学习.FirstPara;

public class union_find的加权quick_union实现 {
    public class WeightedQuickUnionUF{
        private int[] id;//父链接数组
        private int[] sz;//(由触点索引的)各个根结点所对应的分量的大小
        private int count;//连通分量的数量
        public WeightedQuickUnionUF(int N){
            count = N;
            id = new int[N];
            for(int i=0;i<N;i++)    id[i] = i;
            sz = new int[N];
            for(int i=0;i<N;i++)    sz[i] = 1;
        }
        public int count(){
            return count;
        }
        public boolean connexted(int p,int q){
            return find(p) == find(q);
        }
        public int find(int p){//跟随链接找到根结点
            while(p!=id[p])     p = id[p];
            return p;
        }
        public void union(int p,int q){
            int i = find(p);
            int j = find(q);
            if(i == j)  return;
            //将小树的根结点连接到大树的根结点
            if(sz[i]<sz[j]){
                id[i] = j;
                sz[j] += sz[i];
            } else{
                id[j] = i;
                sz[i] += sz[j];
            }
            count--;
        }
     }
}
