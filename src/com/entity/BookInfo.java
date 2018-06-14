package com.entity;

import com.annotantion.Colum;
import com.annotantion.PK;
import com.annotantion.Table;

import java.io.Serializable;

/**
 * 图书信息类
 * @author Administrator
 *
 */
@Table("t_book") // 表名和类名的映射注解
public class BookInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@PK // 标注主键
	@Colum(value = "book_id", type = Colum.DataBaseType.MYSQL) // 属性名和表中字段的映射注解
	private Integer bookId;

    @Override
    public String toString() {
        return "BookInfo{" +
                "bookId=" + bookId +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", bookPrice=" + bookPrice +
                ", bookName='" + bookName + '\'' +
                '}';
    }

    /**
	 * 作者
	 */
	@Colum("book_author")
	private String bookAuthor;

    @Override
    public int hashCode() {
        return this.getBookAuthor().hashCode()+this.getBookName().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this==obj) {
            return true;
        }
        if (obj instanceof BookInfo) {
            BookInfo bookInfo=(BookInfo)obj;
            return this.getBookName()==bookInfo.getBookName()&&this.getBookAuthor()==bookInfo.getBookAuthor();
        }else {
            return false;
        }

    }

    /**
	 *  书价格
	 */
	@Colum("book_price")
	private Double bookPrice;
	@Colum("book_name")
	private String bookName;


	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public Double getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(Double bookPrice) {
		this.bookPrice = bookPrice;
	}
}
