package cMyORM.aJdbcUtil.enums;

import cMyORM.aJdbcUtil.config.PropertiesPlaceHollder;

public enum DriverInfoEnum {
    DRIVER_CLASS {
        @Override
        public String getInfo() {
            return new PropertiesPlaceHollder().getProperty("jdbc.driver_class");
        }
    },
    URL {
        @Override
        public String getInfo() {
            return new PropertiesPlaceHollder().getProperty("jdbc.url");
        }
    },
    USERNAME {
        @Override
        public String getInfo() {
            return new PropertiesPlaceHollder().getProperty("jdbc.username");
        }
    },
    PASSWORD {
        @Override
        public String getInfo() {
            return new PropertiesPlaceHollder().getProperty("jdbc.password");
        }
    };

    public abstract String getInfo();
}
