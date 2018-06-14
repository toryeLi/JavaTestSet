package cMyORM.dJdbcUtilSelect.config;

import cMyORM.cJdbcUtilAnnotion.constant.ConfigConstant;

import java.io.InputStream;
import java.util.Properties;

public class PropertiesPlaceHolder3 extends Properties {
    private static final long serialVersionUID = 1L;

    public PropertiesPlaceHolder3() {
        String path = ConfigConstant.PROPERTIES_CONFIG_PATH.getPath();
        try (InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream(path);
        ) {
            if (resourceAsStream != null) {
                this.load(resourceAsStream);
            } else {
                System.out.println("获取资源文件失败，InputStream 为null");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
