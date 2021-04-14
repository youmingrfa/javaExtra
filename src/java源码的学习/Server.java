package java源码的学习;

/*TCP通信的服务器端：接收到客户端的请求，读取客户端发送的数据，给客户端回写数据。
 * 表示服务器的类:
 *   java.net.ServerSocket :次类实现服务器端套接字
 * 构造方法：
 *   ServerSocket(int port) 创建绑定到特定端口的服务器套接字
 * 成员方法：
 *   Socket accept() 返回客户端的Socket对象
 *
 * 实现步骤：
 *   1.创建服务器ServerSocket对象和系统要指定的端口
 *   2.使用ServerSocket中accept方法，获取请求客户端的Socket对象
 *   3.使用Socket中getInputStream方法获取网络字节输入流InputStream对象
 *   4.使用字节输入流read方法，读取客户端发送的数据
 *   5.使用Socket对象中的getOutputStream方法，获取字节输入流对象
 *   6.使用字节输出流中的write方法给客户端回写数据
 *   7.释放资源
 *   */

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8889);
        Socket sc = ss.accept();
        InputStream is = sc.getInputStream();
        byte [] bytes = new byte[1024];
        int len = is.read(bytes);
        System.out.println(new String(bytes,0,len));
        OutputStream os = sc.getOutputStream();
        os.write("山下美月".getBytes());
        ss.close();



    }
}