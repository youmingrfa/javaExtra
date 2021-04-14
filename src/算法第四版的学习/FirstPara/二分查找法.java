package 算法第四版的学习.FirstPara;

import java.util.Arrays;

public class 二分查找法 {
    public class BinarySearch{
        public int rank(int key,int[] a){
            //数组必须是有序的
            int lo = 0;
            int hi = a.length - 1;
            while (lo <= hi) {
                int mid = lo+(hi-lo)/2;
                if(key < a[mid])    hi = mid-1;
                else if(key>a[mid]) lo = mid+1;
                else                return mid;

            }
            return -1;
        }
    }
}
