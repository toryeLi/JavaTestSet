package bSocket.aTcp.aUserServer;

import bSocket.aTcp.UserInfo;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class UserServerM {
    private static int port = 5566;
    int count=0;
    public static void main(String[] args) {
        try {
            //创建服务器端，监听端口
            ServerSocket serverSocket = new ServerSocket(port);
            //如果有客户端连接过来，服务器端会产生一个Socket与之对话
            Socket socket = serverSocket.accept();
           // ThreadPoolExecutor threadPoolExecutor=
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
 class SocketRunnable implements  Runnable{
    Socket socket;
    int count;

     /**
      *
      * @param count  用来记录当前有多少个客户端连接
      * @param socket1 与客户端对话的当前socket
      */
     public SocketRunnable(int count,Socket socket1) {
         this.socket=socket1;
         this.count=count;
     }

     @Override
    public void run() {

         try {
             String str="您是"+count+"位到访者，端口号："+socket.getPort()+";IP:"+socket.getInetAddress().getCanonicalHostName();
             System.out.println(str);
             ObjectInputStream ois=new ObjectInputStream(socket.getInputStream());
             Object obj=ois.readObject();
             BufferedOutputStream bos=new BufferedOutputStream(socket.getOutputStream());
             if(obj instanceof UserInfo){
                 UserInfo userInfo=(UserInfo)obj;
                 System.out.println("用户名："+userInfo.getUsername()+"密码："+userInfo.getPassword());
                 bos.write(("登录成功"+str).getBytes());
             }else {
                 System.out.println("序列化失败");
                 bos.write(("序列化失败"+str).getBytes());
             }
             bos.flush();
             bos.close();
             ois.close();
         } catch (Exception e) {
             e.printStackTrace();
         } finally {
             try {
                 if (socket!=null) {
                     socket.close();
                 }
             } catch (IOException e) {
                 e.printStackTrace();
             }
         }
     }
}
