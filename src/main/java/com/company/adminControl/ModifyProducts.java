package com.company.adminControl;
import com.company.actionOnStore.CreateOrder;
import com.mysql.cj.protocol.Resultset;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.company.util.UtilClass.conn;
import static com.company.util.UtilClass.s;

public class ModifyProducts {
    private static String productValue;
    private static int adminImput;
    public static void ModifyPrice(){
        try {
            CreateOrder.showProducts();
            System.out.println("\n Choose id from the product that you want to modify");
            adminImput = s.nextInt();
            System.out.println("\n Insert the new value for ID: "+adminImput);
            productValue = s.next();
            if(verifyID())
                applyModif();
                System.out.println("Prices matches");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    private static boolean verifyID() throws SQLException {
        Statement st = conn.createStatement();
        String querry = "Select ProductID from Products";
        ResultSet rs = st.executeQuery(querry);
        while(rs.next()){
        int productID = rs.getInt("ProductID");
        if(productID == adminImput)
            return true;
        }
        return false;
    }
    private static void applyModif() throws SQLException {
        Statement st = conn.createStatement();
        String querry = "UPDATE Users " +
                " Set ProductPrice = '"+productValue+"'" +
                " WHERE ProductName = "+adminImput+"";
    }

}
