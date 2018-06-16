package com.constant;

import cMyORM.dJdbcUtilSelect.config.PropertiesConfiguration;

public enum DriverInfoEnum {
    DRIVER_CLASS {
        @Override
        public String getInfo() {
                return PropertiesConfiguration.getInstance().getProperty("jdbc.driver_class");
              //  return new PropertiesPlaceHolder3().getProperty("jdbc.driver_class");

        }
    },
    URL {
        @Override
        public String getInfo() {
            return PropertiesConfiguration.getInstance().getProperty("jdbc.url");
        }
    },
    USERNAME {
        @Override
        public String getInfo() {
          return   PropertiesConfiguration.getInstance().getProperty("jdbc.username");
        }
    },
    PASSWORD {
        @Override
        public String getInfo() {
            return PropertiesConfiguration.getInstance().getProperty("jdbc.password");
        }
    };
    public abstract String getInfo();
}
