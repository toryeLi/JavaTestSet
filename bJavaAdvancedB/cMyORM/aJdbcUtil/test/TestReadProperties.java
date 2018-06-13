package cMyORM.aJdbcUtil.test;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.ResourceBundle;

public class TestReadProperties {
    @Test //资源国际化
    public void test1(){
        ResourceBundle resourceBundle = ResourceBundle.getBundle("dataSource");
        String url = resourceBundle.getString("jdbc.url");
        String username = resourceBundle.getString("jdbc.username");
        System.out.println(url);
        System.out.println(username);
    }
    @Test
    public void test2(){
        System.out.println("--"+new MyProperties().getProperty("jdbc.url")+"--");
    }
    private class MyProperties extends Properties{
        public MyProperties(){
            InputStream in = this.getClass().getClassLoader().getResourceAsStream("dataSource.properties");
            try {
                this.load(in);
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
