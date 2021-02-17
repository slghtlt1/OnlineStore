package com.company.dBconn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnDB {
    public static Connection createConn(){
        try {
            Class.forName(DBUtil.DRIVER);
            return DriverManager.getConnection(DBUtil.URL, LoginDB.USER, LoginDB.PASS);
        } catch (Exception e) {
            System.out.println("Exception catched at conn with db");

        }
        return null;
    }
}