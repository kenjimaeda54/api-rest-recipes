package com.br.menu;

import oracle.jdbc.datasource.impl.OracleDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class Config {
    public static final String keyUser = "RM87925";
    public  static  final  String KeyPwd = "080689";
    public  static final  String baseUlr = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";


    public Connection getConnection() throws SQLException {
        OracleDataSource ods = new OracleDataSource();
        ods.setURL(Config.baseUlr);
        ods.setUser(Config.keyUser);
        ods.setPassword(Config.KeyPwd);
        Connection conn = ods.getConnection();
        return  conn;
    };

}
