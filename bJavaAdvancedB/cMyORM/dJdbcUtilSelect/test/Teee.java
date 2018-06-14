package cMyORM.dJdbcUtilSelect.test;

import cMyORM.dJdbcUtilSelect.JDBCUtils3;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Teee {
    public static void main(String[] args){
        Connection conn = JDBCUtils3.getConnection();
        try {
            DatabaseMetaData data = conn.getMetaData();
            ResultSet tables = data.getTables(conn.getCatalog(), null, null,new String[]{"TABLE"});
            while (tables.next()) {
                String tableName = tables.getString("TABLE_NAME");
                System.out.println(tableName);

            }
            System.out.println("--------------------------------------------");
            ResultSet foreignKeyResultSet = data.getImportedKeys(conn.getCatalog(),null,"t_user");
            while(foreignKeyResultSet.next()){
                String pkTablenName = foreignKeyResultSet.getString("PKTABLE_NAME");
                String pkColumnName = foreignKeyResultSet.getString("FKCOLUMN_NAME");
                System.out.println(pkTablenName+","+pkColumnName);
            }


        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
