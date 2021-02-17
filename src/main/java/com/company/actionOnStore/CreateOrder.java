package com.company.actionOnStore;

import com.company.dBconn.ConnDB;
import com.company.util.UtilClass;

import static com.company.util.UtilClass.conn;
import static com.company.util.UtilClass.s;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class CreateOrder {
    private static int maxSpaces = 0;
    private static String userImput1;
    private static int randomNr1;


    //introduc in tabelul de comenzi o noua comanda, utilizand datele pe care le am de la client
//ar trebui sa fac drop la ce articole sunt
    public static void showCategory() throws SQLException {
        Statement st = conn.createStatement();
        String querry = "Select * from Store.ProductCategories";
        ResultSet rs = st.executeQuery(querry);
        System.out.println("OS:");
        while (rs.next()) {
            String osProd = rs.getString("OS");
            System.out.println(osProd);
        }
    }

    public static void chooseOption() throws SQLException {
        Statement st = conn.createStatement();

        System.out.println("\nInsert your category:");
        String userChoice = s.next();
        String querry = "Select * from Store.ProductOption where ProductOSs = '" + userChoice + "'";
        ResultSet rs = st.executeQuery(querry);
        while (rs.next()) {
            String prodCpu = rs.getString("ProductCPU");
            System.out.println(prodCpu);
        }

    }

    public static void showProducts() throws SQLException, ClassNotFoundException {
        Statement st = UtilClass.conn.createStatement();
        showCategory();
        chooseOption();
        System.out.println("\nInsert your option:");
        String userChoice = s.next();
        String querry = "SELECT * FROM Store.Products where ProductCpu = '" + userChoice + "'";
        ResultSet rs = st.executeQuery(querry);

        System.out.println("ProductId \t ProductName \t ProductPrice \t ProductWeight \t ProductCpu \t ProductRam \t ProductCameras" +
                "\t ProductOS");

        while (rs.next()) {
            String userID = rs.getString("ProductId");
            String productName = rs.getString("ProductName");
            String pruductPrice = rs.getString("ProductPrice");
            String productWeight = rs.getString("ProductWeight");
            String productCpu = rs.getString("ProductCpu");
            String productRam = rs.getString("ProductRam");
            String productCamera = rs.getString("ProductCameras");
            String productOS = rs.getString("ProductOS");
            System.out.println(userID + "\t" + maxSpace(productName, maxSpaces) + "\t" + pruductPrice + "\t" + productWeight + "\t" +
                    productCpu + "\t" + productRam + "\t" + productCamera + "\t" + productOS);

        }
    }

    static String maxSpace(String var, int maxSpaces) {
        int aux = 0;
        int varInt = var.length();
        if (maxSpaces < varInt) {
            maxSpaces = varInt;
            String nrSpaces = "";
            for (int i = 0; i < maxSpaces; i++) {
                nrSpaces = nrSpaces.concat(" ");
            }
            var = var.concat(nrSpaces);
            return var;
        } else
            return var;
    }


    public static void chooseOrder() throws SQLException {
        Statement st = conn.createStatement();
        String querry = "SELECT * FROM Store.Products";
        ResultSet rs = st.executeQuery(querry);

        if (checkIfProductExist()) {
            insertOrder();
            insertOrderDetail();

        } else System.out.println("Choose an valid product");

    }


    private static boolean checkIfProductExist() throws SQLException {
        System.out.println("Insert your product name: ");
        userImput1 = s.next();
        Statement st = conn.createStatement();
        String querry = "Select ProductName from Store.Products where ProductName = '" + userImput1 + "'";
        ResultSet rs = st.executeQuery(querry);
        if (rs.equals(userImput1))
            return false;
        else
            return true;
    }

    private static void insertOrderDetail() throws SQLException {
        try {
            Statement st = conn.createStatement();
            randomNr1 = UtilClass.random.nextInt(1000);
            String insertOrderDetail = "Insert into Store.OrderDetail(IDOrders, OrderAWB, OrderPrice, OrderQuantity)" + " Values('" + orderID() + "', '" + Integer.toString(randomNr1) + "', '" + priceOrder() + "', '1')";
            st.executeUpdate(insertOrderDetail);
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    private static void insertOrder() {
        try {
            int randomNr1 = UtilClass.random.nextInt(100);
            int randomNr2 = UtilClass.random.nextInt(1000);
            Statement st = conn.createStatement();
            int random = UtilClass.random.nextInt(100);
            String insertOrder = "Insert into Store.Orders(IDUsers, OrderNr, OrderName, OrderAdress, OrderPayment, OrderCity, OrderPhone, OrderAWB) "
                    + "Values('" + userID() + "','" + randomNr1 + "','" + userImput1 + "','" + adressInsert() +
                    "','card','" + cityInsert() + "','" + phoneInsert() + "','" + randomNr2 + "');";
            st.executeUpdate(insertOrder);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static String adressInsert() throws SQLException {
        String querry = "Select UserAdress from Store.Users Where UserEmail = '" + LoginControler.userName + "'";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(querry);
        if (rs.next()) {
            String getAdress = rs.getString("UserAdress");
            return getAdress;
        }
        return null;
    }

    private static String cityInsert() throws SQLException {
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("Select UserCity from Store.Users Where UserEmail = '" + LoginControler.userName + "'");
        if (rs.next()) {
            String getCity = rs.getString("UserCity");
            return getCity;
        }
        return null;
    }

    private static String phoneInsert() throws SQLException {
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("Select UserPhone from Store.Users Where UserEmail = '" + LoginControler.userName + "'");
        if (rs.next()) {
            String getPhone = rs.getString("UserPhone");
            return getPhone;
        }
        return null;
    }

    private static String priceOrder() throws SQLException {
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("Select ProductPrice from Store.Products Where ProductName = '" + userImput1 + "'");
        if (rs.next()) {
            String getPrice = rs.getString("ProductPrice");
            return getPrice;
        }
        return null;
    }

    private static int userID() throws SQLException {
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("Select IDUsers from Store.Users Where  UserEmail= '" + LoginControler.userName + "'");
        if (rs.next()) {
            int getID = rs.getInt("IDUsers");
            return getID;
        }
        return -1;
    }

    private static int orderID() throws SQLException {
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("Select IDOrder from Store.Orders Where  OrderName= '" + userImput1 + "'");
        if (rs.next()) {
            int orderID = rs.getInt("IDOrder");
            return orderID;
        }
        return -1;
    }
}
