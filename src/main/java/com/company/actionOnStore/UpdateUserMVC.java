package com.company.actionOnStore;
import static com.company.util.UtilClass.conn;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UpdateUserMVC {
       public static List createMVC() throws SQLException {
           Statement st = conn.createStatement();
           String querry = "Select IDUser, UserEmail, UserPass, UserFirstName, UserLastName," +
                   " UserCity, UserAdress, UserPhone from Users";
           UserModel user = new UserModel();
           List<UserModel> userList = new ArrayList<UserModel>();
           ResultSet rs = st.executeQuery(querry);
           while(rs.next()){
               user.setId(rs.getInt("IDUser"));
               user.setUserEmail(rs.getString("UserEmail"));
               user.setUserPass(rs.getString("UserPass"));
               user.setUserFirstName(rs.getString("UserFirstName"));
               user.setUserLastName(rs.getString("UserLastName"));
               user.setUserCity(rs.getString("UserCity"));
               user.setUserAdress(rs.getString("UserAdress"));
               user.setUserPhone(rs.getString("UserPhone"));
               userList.add(user);
           }
        return userList;
       }
}
