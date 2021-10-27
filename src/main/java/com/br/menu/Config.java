package com.br.menu;

import oracle.jdbc.datasource.impl.OracleDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class Config {
    public static final String keyUser = "";
    public  static  final  String KeyPwd = "";
    public  static final  String baseUlr = "";
    //joao
    //RM87894
    //160502
    //-----------
    //kenji
    //RM 87925
    // 080689
    public Connection getConnection() throws SQLException {
        OracleDataSource ods = new OracleDataSource();
        ods.setURL(Config.baseUlr);
        ods.setUser(Config.keyUser);
        ods.setPassword(Config.KeyPwd);
        Connection conn = ods.getConnection();
        return  conn;
    };

}
