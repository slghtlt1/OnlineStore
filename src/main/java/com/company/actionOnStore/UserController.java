package com.company.actionOnStore;

public class UserController {
    private UserModel model;
    private UserView view;

    public UserController(UserModel model, UserView view){
        this.model = model;
        this.view = view;
    }

    public void setUserId(int id){
        model.setId(id);
    }
    public int getUserID(){
        return model.getId();
    }

    public void setUserEmail(String userEmail){
        model.setUserEmail(userEmail);
    }
    public String getUserEmail(){
        return model.getUserEmail();
    }

    public void setUserPass(String userPass){
        model.setUserPass(userPass);
    }
    public String getUserPass() {
        return model.getUserPass();
    }

    public void setUserFirstName(String userFirstName){
        model.setUserFirstName(userFirstName);
    }
    public String getUserFirstName(){
        return model.getUserFirstName();
    }

    public void setUserLastName(String userLastName){
        model.setUserLastName(userLastName);
    }
    public String getUserLastName(){
        return model.getUserLastName();
    }

    public void setUserCity(String userCity){
        model.setUserCity(userCity);
    }
    public String getUserCity(){
        return model.getUserCity();
    }

    public void setUserAdress(String userAdress){
        model.setUserAdress(userAdress);
    }
    public String getUserAdress(){
        return model.getUserAdress();
    }

    public void setUserPhone(String userPhone){
        model.setUserPhone(userPhone);
    }
    public String getUserPhone(){
        return model.getUserPhone();
    }

//    public void updateView(){
//       // view.userPrintDetails(model.getId(), model.getUserEmail(), model.getUserAdress(), model.getUserFirstName(),
//                model.getUserCity(), model.getUserAdress(), model.getUserPhone());
//    }

}
