package com.company.adminControl;
import com.company.actionOnStore.CreateOrder;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.company.util.UtilClass.conn;
import static com.company.util.UtilClass.s;

public class DeleteProduct {
    private static String adminImput;

    public static void deleteProduct() {
        try {
            System.out.println("Insert ProductName that you want to delete:");
            adminImput = s.next();
            if (verifyProduct())
                executeDelete();
            else System.out.println("MUIE");

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    private static boolean verifyProduct() throws SQLException {
        Statement st = conn.createStatement();
        String querry = "Select ProductName from Products";
        //DELETE FROM table_name WHERE condition;
        ResultSet rs = st.executeQuery(querry);
        while(rs.next()){
            String productID = rs.getString("ProductName");
            if(productID.equals(adminImput))
                return true;
        }
        return false;
    }
    private static void executeDelete() throws SQLException {
        Statement st = conn.createStatement();
        String querry = "Delete from Store.Products where ProductName = '"+adminImput+"'";
        st.executeUpdate(querry);
    }
}
