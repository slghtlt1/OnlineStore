package com.company.actionOnStore;

public class UserView {
    public static void userPrintDetails(int id,String userEmail, String userPass, String userFirstName,
             String userLastName, String userCity, String userAdress, String userPhone){
        System.out.println("User:");
        System.out.println("id: "+ id);
        System.out.println("Email: "+userEmail);
        System.out.println("Pass: "+userPass);
        System.out.println("First Name: "+userFirstName);
        System.out.println("Last Name: "+userLastName);
        System.out.println("City: "+userCity);
        System.out.println("Adress: "+userAdress);
        System.out.println("Phone: "+userPhone);
    }
}
