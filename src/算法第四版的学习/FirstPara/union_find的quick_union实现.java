package 算法第四版的学习.FirstPara;

public class union_find的quick_union实现 {
    public class UF{
        private int[] id;//分量id
        private int count;//分量数量

        public UF(int N){//初始化id数组
            count = N;
            id = new int[N];
            for(int i=0;i<N;i++)
                id[i] = i;
        }
        public int count(){
            return count;
        }
        public boolean connected(int p,int q){
            return find(p) == find(q);
        }
        public int find(int p){//找出分量的名称
            while(p!=id[p])     p = id[p];
            return p;
        }
        public void union(int p,int q){//p和q的根结点统一
            int pRoot = find(p);
            int qRoot = find(q);
            if(pRoot == qRoot)  return;
            id[pRoot] = qRoot;

            count--;
        }
    }
}
