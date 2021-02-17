package com.company.adminControl;
import static com.company.util.UtilClass.conn;
import static com.company.util.UtilClass.s;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AddProduct {
    private static String nameImput;
    private static String priceImput;
    private static String weightImput;
    private static String cpuImput;
    private static String ramImput;
    private static String cameraImput;
    private static String osImput;

    public static void insertProduct(){
        try {
            Statement st = conn.createStatement();
            imputProduct();
            String querry = "Insert into Store.Products(ProductName, ProductPrice, ProductWeight, ProductCpu, ProductRam, ProductCameras, ProductOS) " +
                    "Values('" + nameImput + "','" + priceImput + "','" + weightImput + "','" + cpuImput + "','" + ramImput + "','" + cameraImput + "', '" + osImput + "')";
            st.executeUpdate(querry);
            System.out.println("Product added succesfully!");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        }

    private static void imputProduct(){
        System.out.println("Insert Product Name:");
        nameImput = s.next();
        System.out.println("Price value:");
        priceImput = s.next();
        System.out.println("Weight value:");
        weightImput = s.next();
        System.out.println("CPU value:");
        cpuImput = s.next();
        System.out.println("RAM value:");
        ramImput = s.next();
        System.out.println("Camera value:");
        cameraImput = s.next();
        System.out.println("OS name:");
        osImput = s.next();
    }
}
