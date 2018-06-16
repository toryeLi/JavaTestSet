package cMyORM.dJdbcUtilSelect.config;

import cMyORM.cJdbcUtilAnnotion.constant.ConfigConstant;

import java.io.InputStream;
import java.util.Properties;

public class PropertiesPlaceHolder3 extends Properties {
    private static final long serialVersionUID = 1L;
    private static int countss=0;
    public PropertiesPlaceHolder3() {
        String path = ConfigConstant.PROPERTIES_CONFIG_PATH.getPath();
        try (InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream(path);
        ) {
            if (resourceAsStream != null) {
                countss++;
                this.load(resourceAsStream);
                System.out.println("重写加载了资源文件的次数为：" + countss);
            } else {
                System.out.println("获取资源文件失败，InputStream 为null");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 用来测试单例时，打印
     * @return
     */
    @Override
    public String toString() {
        return this.hashCode()+"";
    }
}
