package cMyORM.aJdbcUtil.config;

import cMyORM.aJdbcUtil.constant.ConfigConstant;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 资源文件处理器
 */
public class PropertiesPlaceHollder extends Properties {
    private static final long serialVersionUID = 7907113498148160479L;
    public PropertiesPlaceHollder(){
        String path = ConfigConstant.PROPERTIES_CONFIG_PATH.getPath();
        System.out.println("PropertiesPlaceHollder:"+path);
        try {
            this.getClass().getClassLoader();
            InputStream in = this.getClass().getClassLoader().getResourceAsStream(path);
            this.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过key获取值的方法
     * @param key
     * @return
     */
    public String getValueByKey (String key){
       return getProperty(key);
    }
}
