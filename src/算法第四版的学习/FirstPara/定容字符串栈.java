package 算法第四版的学习.FirstPara;

public class 定容字符串栈 {
    public class FixedCapacityStackOfString{
        private String a[];
        private int N;
        public FixedCapacityStackOfString(int cap){
            a = new String[cap];
        }
        public boolean isEmpty(){
            return N == 0;
        }
        public int size(){
            return N;
        }
        public void push(String item){
            a[N++] = item;
        }
        public String pop(){
            return a[--N];
        }
    }
}