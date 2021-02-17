import com.company.actionOnStore.LoginControler;
import com.company.actionOnStore.CreateOrder;
import com.company.actionOnStore.ModifyPass;
import com.company.actionOnStore.RegisterAccount;
import com.company.adminControl.AddProduct;
import com.company.adminControl.DeleteProduct;
import com.company.adminControl.ModifyProducts;

import java.sql.SQLException;

import static com.company.util.UtilClass.s;

public class Main {

    public static void main(String arg[]) throws SQLException, ClassNotFoundException {
        try {
            System.out.println("Do you want to login? \n 1-> yes \n 2-> no, I want an account \n 3->Admin View");
            int userImput = s.nextInt();
            switch (userImput) {
                case 1:
                    /*
                    USER Interface
                    De catologat produsele pe categorii
                     */
                    if (LoginControler.loginStore() == false) {
                        System.out.println("User or Pass is incorect");
                        LoginControler.loginStore();
                    } else {
                        System.out.println("Login succesfully.\n 1->Create a new Order \n 2->change your pass");
                        int loginChoice = s.nextInt();
                        switch (loginChoice) {
                            case 1:
                                //ii arat categoria, dupa optiunile si in final ii produsele filtrate
                                CreateOrder.showProducts();
                                CreateOrder.chooseOrder();
                                break;
                            case 2:
                                ModifyPass.changepass();
                                break;
                            default:
                                System.out.println("Choose an valid option");

                        }
                    }
                    break;
                case 2:
                    RegisterAccount.insertUserImput();
                    break;
                case 3:
                    adminInterface();
                    break;
            }

// de creat o interogare pentru client de a vedea statusul comenzii dupa ce face login, sau change pass
        } catch (Exception e) {
            System.out.println("Something is wrong.");
        }
    }

    private static void adminInterface() throws SQLException, ClassNotFoundException {
        if (LoginControler.loginStore() == false) {
            System.out.println("User or Pass is incorect");
            LoginControler.loginStore();
        } else System.out.println("Hello admin");
        //Aici fac modificari de pret (DE REMEDIAT), adaug sau sterg produse
        //TODO: De vazut cum fac sa fac ceva cu ordere
        System.out.println("What changes do you want? \n 1 -> Modify price \n 2-> Add Product \n 3-> Delete Product");
        int adminImput = s.nextInt();
        switch (adminImput) {
            case 1:
                CreateOrder.showProducts();
                ModifyProducts.ModifyPrice();
                break;
            case 2:
                AddProduct.insertProduct();
                break;
            case 3:
                DeleteProduct.deleteProduct();
                break;
        }
    }
}
