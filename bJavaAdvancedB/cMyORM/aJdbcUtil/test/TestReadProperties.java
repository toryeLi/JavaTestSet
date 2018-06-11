package cMyORM.aJdbcUtil.test;

import org.junit.Test;

import java.util.ResourceBundle;

public class TestReadProperties {
    @Test
    public void test1(){
        ResourceBundle resourceBundle = ResourceBundle.getBundle("dataSource");
        String url = resourceBundle.getString("jdbc.url");
        System.out.println(url);
    }
}
