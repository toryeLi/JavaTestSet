package cMyORM.dJdbcUtilSelect.demo.book;

import com.entity.BookInfo;

import java.util.List;

public interface BookDAO {
    void save(BookInfo bookInfo);

    /**
     *
     * @param bookInfo 更新的值
     * @param condition  条件实体
     */
    void update(BookInfo bookInfo,BookInfo condition);

    /**
     * 查询所有字段的数据，没有条件
     * @param claxx
     * @param <T>
     * @return
     */
    <T> List<T> queryForList(Class<T> claxx);
    List<BookInfo> getBookInfos();
    List<BookInfo> getBookInfos(BookInfo condition);
}
