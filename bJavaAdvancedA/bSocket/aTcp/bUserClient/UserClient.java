package bSocket.aTcp.bUserClient;

import bSocket.aTcp.UserInfo;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class UserClient {
 private static  int port=5566;
 private static String host="localhost";
//快速生成main函数，输入首字母：psvm
    public static void main(String[] args) {
        Socket sockte=null;
        Scanner scanner=null;
        try {
            scanner=new Scanner(System.in);
            sockte=new Socket(host,port);
            ObjectOutputStream oos=new ObjectOutputStream(sockte.getOutputStream());
            UserInfo user=new UserInfo();
            System.out.println("请输入用户名：");
             user.setUsername(scanner.next());
            System.out.println("请输入密码：");
            user.setPassword(scanner.next());
            oos.writeObject(user);//序列化到输出流
            oos.flush();//释放资源
            BufferedInputStream bis=new BufferedInputStream(sockte.getInputStream());
            byte[] buffer=new byte[1024];
            int len=0;
            while ((len=bis.read(buffer))!=-1){
                String context=new String(buffer,0,len);
                System.out.println(context);
            }
            sockte.shutdownOutput();
            sockte.shutdownInput();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (sockte!=null) {
                    sockte.close();
                }
                if (scanner!=null) {
                    scanner.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
