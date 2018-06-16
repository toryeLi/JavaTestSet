package com.constant;

import cMyORM.dJdbcUtilSelect.config.PropertiesConfiguration;

/**
 * 获取连接池配置
 */
public enum PoolEnum {
    /**
     * 初始化连接数
     */
    INITIAL_SIZE {
        @Override
        public String getInfo() {
          //  return new PropertiesPlaceHolder().getProperty("initialsize");
            return PropertiesConfiguration.getInstance().getProperty("initialsize");
        }
    },
    /**
     * 连接增长数
     */
    INCREASE_SIZE {
        @Override
        public String getInfo() {
            return PropertiesConfiguration.getInstance().getProperty("increasesize");
        }
    },
    /**
     * 最大连接数
     */
    MAX_SIZE {
        @Override
        public String getInfo() {
           return PropertiesConfiguration.getInstance().getProperty("maxsize");
        }
    },
    /**
     * 超时时间
     */
    TIMEOUT
    {
        @Override
        public String getInfo() {
            return PropertiesConfiguration.getInstance().getProperty("timeout");
        }
    };

    public abstract String getInfo();
}
