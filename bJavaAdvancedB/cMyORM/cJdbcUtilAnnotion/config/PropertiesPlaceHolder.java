package cMyORM.cJdbcUtilAnnotion.config;


import cMyORM.cJdbcUtilAnnotion.constant.ConfigConstant;

import java.io.InputStream;
import java.util.Properties;

/**
 * 资源文件处理器
 */
public class PropertiesPlaceHolder extends Properties {
    private static final long serialVersionUID = 1L;
   public PropertiesPlaceHolder(){
       String path = ConfigConstant.PROPERTIES_CONFIG_PATH.getPath();
       System.out.println("资源文件为："+path);
       try(InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream(path);
       ){
           this.load(resourceAsStream);
       }catch (Exception ex){
           System.out.println("加载资源文件时报错，错误信息为"+ex.getMessage());
       }

    }
}
