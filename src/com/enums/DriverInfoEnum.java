package com.enums;
import cMyORM.cJdbcUtilAnnotion.config.PropertiesPlaceHolder;
public enum DriverInfoEnum {
    DRIVER_CLASS {
        @Override
        public String getInfo() {
                return new PropertiesPlaceHolder().getProperty("jdbc.driver_class");

        }
    },
    URL {
        @Override
        public String getInfo() {
            return new PropertiesPlaceHolder().getProperty("jdbc.url");
        }
    },
    USERNAME {
        @Override
        public String getInfo() {
            return new PropertiesPlaceHolder().getProperty("jdbc.username");
        }
    },
    PASSWORD {
        @Override
        public String getInfo() {
            return new PropertiesPlaceHolder().getProperty("jdbc.password");
        }
    };
    public abstract String getInfo();
}
