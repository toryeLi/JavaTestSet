package bSocket.aTcp.aUserServer;

import bSocket.aTcp.UserInfo;

import java.io.BufferedOutputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务器端代码，不能处理多个客户端连接，因为是单线程的，会阻塞,当开启多个客户端连接时，就会报错
 * 注意事项：
 * 1 服务器端序列化的对象全名称必须和反序列化的全名称完全一致
 * 2 序列化和反序列化对象的序列化Id必须一致
 * 3 在网络编程中需要在网络中传输对象必须实现Serializable
 * 4 释放资源的时候流不要使用close方法关闭
 */
public class UserServer {
    private static int port = 5566;//服务器端监听的端口号
    //输入psvm 自动补全main函数
    //ctrl+alt+l 格式化代码
    public static void main(String[] args) {
        ServerSocket serverSocket=null;
        Socket socket=null;
        while (true) {

                /**
                 * 1 快速生成try/catch方法：先写一句代码，选中，按 ctrl+alt+t
                 * 2 删除当前行：Ctrl+Y
                 */
            try {
                serverSocket=new ServerSocket(port);
                //快速生成System.out.println()方法：输入sout
                System.out.println("等待客户端的连接");
                //侦听并接受此套接字的连接；服务器socket，可以获取客户端对应输入流和输出流
                socket=serverSocket.accept();
                System.out.println("端口号："+socket.getPort());
                System.out.println(socket.getInetAddress().getCanonicalHostName()+"连接到了服务器");
                //创建一个反序列化流
                ObjectInputStream ois=new ObjectInputStream(socket.getInputStream());
                Object obj=ois.readObject();
                //创建输出流
                BufferedOutputStream bos=new BufferedOutputStream(socket.getOutputStream());
                if (obj instanceof UserInfo) {
                    UserInfo use = (UserInfo) ois.readObject();
                    //输入sout快速生成System.out.println()
                    System.out.println(use.getPassword()+"---"+use.getUsername());
                    String account=use.getPassword();
                    String password=use.getPassword();
                    //创建输出流
                    if("admin".equals(use.getUsername())&&"123".equals(password)){
                        bos.write("登录成功".getBytes());
                        //ctrl删除当前行
                    }else {
                        bos.write("登录失败".getBytes());
                    }
                } else {
                    System.out.println("UserInfo序列化失败");
                    bos.write("登录失败".getBytes());
                }

                //释放资源
                bos.flush();//刷新此缓冲的输出流
                bos.close();
                ois.close();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                //快捷键：快速生成try/catch,选中某一段代码，按ctrl+alt+t
                try {
                    if(serverSocket!=null){
                        serverSocket.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
