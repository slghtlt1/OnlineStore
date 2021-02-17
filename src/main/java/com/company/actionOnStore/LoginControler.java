package com.company.actionOnStore;

import com.company.dBconn.ConnDB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import static com.company.util.UtilClass.conn;
public class LoginControler {
     public static String userName;
    public static boolean loginStore() throws SQLException {
        Scanner s = new Scanner(System.in);

        System.out.println("Please insert your email:");
        String userInserted = s.next();
        System.out.println("Please insert your pass:");
        String passInserted = s.next();
        if (verifyUserPass(userInserted, passInserted)) {
            userName = userInserted;
            return true;
        }
            return false;

    }
        public static boolean verifyUserPass(String user,String pass) throws SQLException{
            Statement st = conn.createStatement();
            String querry = "Select UserEmail, UserPass from Users ";

            ResultSet rs = st.executeQuery(querry);
//Verific daca querry intoarce o linie, return true, altfel false
            while(rs.next()) {
                String userInserted = rs.getString("UserEmail");
                String passInserted = rs.getString("UserPass");
                if (userInserted.equals(user) && passInserted.equals(pass)) {
                    return true;
                }
            }
            return false;
        }
}
