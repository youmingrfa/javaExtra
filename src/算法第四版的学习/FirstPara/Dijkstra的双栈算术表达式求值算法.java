package 算法第四版的学习.FirstPara;
import java.util.Scanner;
import java.util.Stack;

public class Dijkstra的双栈算术表达式求值算法 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Stack<String> ops = new Stack<>();
        Stack<Double> vals = new Stack<>();
        while(in.hasNext()){//读取字符，如果是运算符则压入栈
            String s = in.next();
            if      (s.equals("("))                        ;
            else if (s.equals("+"))             ops.push(s);
            else if (s.equals("-"))             ops.push(s);
            else if (s.equals("*"))             ops.push(s);
            else if (s.equals("/"))             ops.push(s);
            else if (s.equals("sqrt"))          ops.push(s);
            else if (s.equals(")")){//如果字符为“)”，弹出运算符合操作数，计算结果并压入栈
                String op = ops.pop();
                double v = vals.pop();
                if     (op.equals("+"))      v = vals.pop() + v;
                else if(op.equals("-"))      v = vals.pop() - v;
                else if(op.equals("*"))      v = vals.pop() * v;
                else if(op.equals("/"))      v = vals.pop() / v;
                else if(op.equals("sqrt"))   v = Math.sqrt(v);
                vals.push(v);
            }//如果字符既非运算符也不是括号，将它作为Double值压入栈
            else vals.push(Double.parseDouble(s));
        }
        System.out.println(vals.pop());
    }
}
