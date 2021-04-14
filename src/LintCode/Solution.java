package LintCode;

import java.util.*;

public class Solution {

    public class ListNode{
        private int val;
        private ListNode next;
        public ListNode(int val){
            this.val = val;
            this.next = null;
        }
    }

    public class TreeNode{
        private int val;
        private TreeNode left,right;
        public TreeNode(int val){
            this.val = val;
            this.left = this.right = null;
        }
    }

    public List<List<Integer>> calcYangHuisTriangle(int n) {
        List<Integer> col = new ArrayList<>();
        List<List<Integer>> row = new ArrayList<>();
        if(n==0)    return row;
        col.add(0,1);
        row.add(col);
        if(n==1)    return row;
        col = new ArrayList<>();
        col.add(0,1);col.add(1,1);
        row.add(col);
        if(n==2)    return row;
        int t = 2;
        while(t!=n){
            col = new ArrayList<>();
            col.add(0,1);
            for(int i=0;i<t-1;i++){
                int temp = row.get(t-1).get(i)+row.get(t-1).get(i+1);
                col.add(temp);
            }
            col.add(1);
            row.add(col);
            t++;
        }
        return row;
    }


//    public static void main(String[] args){
//        String str = "abcde";
//
//        System.out.println(str.substring(0,1)+str.substring(2));
//    }

}
