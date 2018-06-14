package cMyORM.dJdbcUtilSelect.test;

import cMyORM.dJdbcUtilSelect.demo.book.BookDAO;
import cMyORM.dJdbcUtilSelect.demo.book.impl.BookDAOImpl;
import com.entity.BookInfo;

import java.util.Iterator;
import java.util.List;

public class JdbcTest3 {
    public static void main(String[] args) {
//        com.entity.LoginInfo login = new LoginInfo();
//        login.setLoginAccount("aa");
//        login.setLoginPass("bb");
//        login.setLoginId(5);
//        LoginDAOImpl3 loginDAOImpl3 = new LoginDAOImpl3();
//        loginDAOImpl3.update(login);
        //=======================================================
//       BookInfo bookInfo=new BookInfo();
//        bookInfo.setBookAuthor("A");
//        bookInfo.setBookPrice(25.5d);
       BookDAO bookDAO=new BookDAOImpl();
////        bookDAO.save(bookInfo);
//        BookInfo bookInfo2=new BookInfo();
//        bookInfo2.setBookAuthor("C#1");
//        bookInfo2.setBookPrice(26.5d);
//        System.out.println(bookInfo.equals(bookInfo2));
//        if(bookInfo.equals(bookInfo2)){
//            System.out.println("是同一个对象");
//        }else {
//            bookDAO.update(bookInfo2,bookInfo);
//        }
        BookInfo bookInfo2=new BookInfo();
        List<BookInfo> bookInfos = bookDAO.queryForList(BookInfo.class);
        Iterator<BookInfo> iterator = bookInfos.iterator();
        while (iterator.hasNext()) {
           BookInfo bo= iterator.next();
            System.out.println(bo.toString());
        }
    }
}
