package cMyORM.dJdbcUtilSelect.test;

import cMyORM.dJdbcUtilSelect.handler.mysql.MySqlTemplateHandler;
import cMyORM.dJdbcUtilSelect.jdbc.JDBCUtils5;
import com.entity.Account;

import java.util.concurrent.locks.ReentrantLock;

public class TestTransaction {
    private static cMyORM.dJdbcUtilSelect.handler.HandlerTemplate  template=new MySqlTemplateHandler();
    //ReentrantLock一个可重入的互斥锁lock，它具有与使用synchronized方法
    //和语句所访问的隐式监视锁相同的一些基本行为和语义,但功能更强大
    static ReentrantLock lock=new ReentrantLock();
public static void main(String[] args){
  // save();
    zhuanZhang(2,3,100);
}
    /**
     * 使用事务模拟转账操作
     * @param sourceId
     * @param targerId
     * @param money
     */
    private static void zhuanZhang(int sourceId,int targerId,int money){
        JDBCUtils5 session=new JDBCUtils5();
        try{
            lock.lock();
            Account a=template.queryForObject(Account.class,sourceId);
            Account b=template.queryForObject(Account.class,targerId);
            //开启事务
            session.begin();
            a.setMoney(a.getMoney()-money);//1000
            b.setMoney(b.getMoney()+money);//500
            //更新a和b用户的账号
            template.update(a);
            template.update(b);
            //throw  new
            //事务提交
           // session.rollback();
            session.commit();
        }catch (Exception ex){
            ex.printStackTrace();
            //出现异常,事务回滚
            session.rollback();
        }finally {
            lock.unlock();
        }
    }
    private static void save(){

        Account aa1=new Account();
        aa1.setMoney(1500d);
        aa1.setName("D");
        template.save(aa1);

    }

}
