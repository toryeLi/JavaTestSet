package cMyORM.dJdbcUtilSelect.demo.book.impl;

import cMyORM.dJdbcUtilSelect.demo.book.BookDAO;
import cMyORM.dJdbcUtilSelect.handler.HandlerTemplate;
import cMyORM.dJdbcUtilSelect.handler.mysql.MySqlTemplateHandler;
import com.entity.BookInfo;

import java.util.List;

public class BookDAOImpl implements BookDAO {
    HandlerTemplate template=new MySqlTemplateHandler();
    @Override
    public void save(BookInfo bookInfo) {
        template.save(bookInfo);
    }

    @Override
    public void update(BookInfo bookInfo, BookInfo condition) {
        int row = template.update(bookInfo, condition);
        System.out.println(row > 0 ? "更新成功" : "更新失败");
    }

    @Override
    public <T> List<T> queryForList(Class<T> claxx) {
        return template.queryForList(claxx);
    }
}
