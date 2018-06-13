package cMyORM.bJdbcUtil.config;

import cMyORM.bJdbcUtil.constant.ConfigConstant;

import java.io.InputStream;
import java.util.Properties;

public class PropertiesPlaceHolder extends Properties {
    private static final long serialVersionUID=1L;

    public PropertiesPlaceHolder() {
        String path = ConfigConstant.PROPERTIES_CONFIG_PATH.getPath();
        try(InputStream in= this.getClass().getClassLoader().getResourceAsStream(path);){
            this.load(in);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

}
