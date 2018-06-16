package cMyORM.dJdbcUtilSelect.test;

import cMyORM.dJdbcUtilSelect.demo.book.impl.BookDAOImpl;
import com.entity.BookInfo;

import java.util.List;
import java.util.Random;

/**
 * 线程池测试
 */
public class TestDataSourcePooled {
    private static Random random = new Random(500);
    private static Random bookRandom = new Random(5);
    private static String[] bookName=new String[5];
    public static void main(String[] args){



        bookName[0]="java";
        bookName[1]="C#";
        bookName[2]="css";
        bookName[3]="sql server";
        bookName[4]="mysql";
        pooled();
       // insertData();
    }
    public static void add(){

    }

    /**
     * 多线程测试
     */
    public static void pooled(){
        for (int i = 0; i < 50; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    selectData();
                }
            }).start();
        }
    }
    protected static void insertData(){
        BookDAOImpl bookDAO = new BookDAOImpl();
        BookInfo bookInfo=new BookInfo();
      //  System.out.println(Thread.currentThread().getName());
        bookInfo.setBookAuthor(Thread.currentThread().getName());
        bookInfo.setBookPrice((random.nextInt(50000)*0.01));
        bookInfo.setBookName(bookName[bookRandom.nextInt(5)]);
       bookDAO.save(bookInfo);
    }
    protected static void selectData(){
        BookDAOImpl bookDAO = new BookDAOImpl();
        List<BookInfo> bookInfos = bookDAO.getBookInfos();
      //  System.out.println(bookInfos.toString());
    }
    public static void fff(String aa,String... bb){
        System.out.println(aa);
        System.out.println(bb);

    }
}
