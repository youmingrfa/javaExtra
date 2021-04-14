package java源码的学习;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/*TCP通信的客户端：向服务器发送链接请求，给服务器发送数据，读取服务器回写的数据
 * JAVA中表示客户端的类：
 *   java.net.Socket:该类实现客户端套接字。
 *   套接字：包含了IP地址和端口号的网络单位
 * 构造方法：
 *   Socket(String host,int port) 创建一个流套接字并将其连接到指定的主机上
 *   参数：
 *       host    服务器主机的名称/IP地址
 *       port    服务器的端口号
 *  成员方法:
 *   OutputStream getOutputStream() 返回此套接字的输出流
 *   InputStream getInputStream() 返回此套接字的输入流
 *   void close() 关闭此套接字
 *  实现步骤：
 *   1.创建一个客户端对象Socket，构造方法指定服务器IP和端口
 *   2.使用Socket方法getOutputStream获取字节输出流
 *   3.使用字节输出流中的write方法，给服务器发送数据
 *   4.使用Socket方法getInputStream获取字节输入流
 *   5.使用字节输入流中的read方法，读取服务器回写的数据
 *   6.释放套接字。
 *  注意：必须使用Socket返回的字节输入输出流。
 *       服务器必须先启动，否则会抛出异常。(第一次握手失败)*/
public class Client {
    public static void main(String[] args) throws IOException {
        Socket sc = new Socket("127.0.0.1",8889);
        OutputStream os = sc.getOutputStream();
        Scanner in = new Scanner(System.in);
        String message = in.next();
        os.write(message.getBytes());
        InputStream is = sc.getInputStream();
        byte [] bytes= new byte[1024];
        int len = is.read(bytes);
        System.out.println(new String (bytes,0,len));
        sc.close();
    }
}