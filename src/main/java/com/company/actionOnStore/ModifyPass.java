package com.company.actionOnStore;

import static com.company.util.UtilClass.conn;
import static com.company.util.UtilClass.s;

import com.company.util.UtilClass;
import com.mysql.cj.protocol.Resultset;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ModifyPass {
    public static void changepass() {

        System.out.println("Do you wanna change your password? \n 1->yes  2->no");
        int userOption = s.nextInt();
        switch (userOption) {
            case 1:
                updatePass();
            case 2:
                System.out.println("Please do something else");
            default:
                System.out.println("Choose an valid option");
        }
    }

    private static void updatePass() {
        try {
            System.out.println("Please insert your current password");
            String userImput = s.next();
            Statement statement = conn.createStatement();
            if (verifyPass(userImput) == true) {
                insertPassDB(userImput);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    private static boolean verifyPass(String userImput) throws SQLException {
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("Select UserPass from Store.Users Where  UserPass='" + userImput + "'");
        if (rs.next())
            return true;
        return false;
    }

    private static void insertPassDB(String userImput) throws SQLException {
        Statement st = conn.createStatement();
        System.out.println("Enter your new pass");
        String userNewPass = s.next();
        System.out.println("Confirm your pass");
        String userNewPassConfirm = s.next();
        String userQuerryPass = "Insert into Store.Users(UserPass) Values('" + userNewPass + "') where UserPass = '" + userImput + "'";
        if (userNewPass.equals(userNewPassConfirm))
            st.executeUpdate(userQuerryPass);
        else System.out.print("Something is wrong, please repet.");

    }
}
