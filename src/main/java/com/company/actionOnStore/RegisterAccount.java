package com.company.actionOnStore;

import java.sql.SQLException;
import java.sql.Statement;

import static com.company.util.UtilClass.conn;
import static com.company.util.UtilClass.s;

public class RegisterAccount {

    public static void insertUserImput() {
        try {
            Statement st = conn.createStatement();
            System.out.println("Insert your email adress");
            String userEmail = s.next();

            System.out.println("Insert your pass:");
            String userPass = s.next();

            System.out.println("Insert your First Name");
            String userFirstName = s.next();

            System.out.println("Insert your Las Name");
            String userLasName = s.next();

            System.out.println("Insert your City");
            String userCity = s.next();

            System.out.println("Insert your Adress");
            String userAdress = s.next();

            System.out.println("Insert your Phone Number");
            String userPhone = s.next();

            st.executeUpdate("Insert into Store.Users(UserEmail, UserPass, UserFirstName, UserLastName, UserCity, UserAdress, UserPhone) "+
                    "Values('"+userEmail+"', '"+userPass+"', '"+userFirstName+"', '"+userLasName+"', '"+userCity+"', '"+userAdress+"', '"+userPhone+"')");
        }catch (Exception e){
            e.getMessage();
        }
        }
    }
