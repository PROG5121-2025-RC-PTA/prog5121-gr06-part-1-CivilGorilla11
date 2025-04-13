package chatapplogin;

import java.util.Scanner ;
import javax.swing.JOptionPane;
public class ST10091295_Part1_POE {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner inputKey = new Scanner(System.in);
        
        String userName;
        String password;
        String cellphone;
        
        userName = JOptionPane.showInputDialog(null, "Enter Username:");
        password = JOptionPane.showInputDialog(null, "Enter Password:");
        cellphone = JOptionPane.showInputDialog(null, "Enter a number( ensure number has a SA code):");
        
        Login login = new Login();
        
        boolean checkUserName = login.checkUserName(userName);
       
        boolean checkPasswordComplexity = login.checkPasswordComplexity(password);
        
        boolean checkCellPhoneNumber = login.checkCellPhoneNumber(cellphone);
        
        String registerUser = login.registerUser(userName, password, cellphone);
        
        JOptionPane.showMessageDialog(null, registerUser);
        
        boolean loginUser ;
        
        
        String loginStatus;
       
        
        if (registerUser.equals("User successfully registered")) {
            String loginUserName = JOptionPane.showInputDialog(null, "Enter Login Username:");
            {
            if (loginUserName == null){
                JOptionPane.showMessageDialog(null, "Login cancelled");
                System.exit(0);
            }
            String loginpassword = JOptionPane.showInputDialog(null, "Enter Password to Login");
            if(loginpassword == null){
                JOptionPane.showMessageDialog(null,"Login cancelled");
                System.exit(0);
            }
            
         //login.storedCredentials( userName, password);
         
         loginUser = login.loginUser(userName, password, loginUserName, loginpassword);
         loginStatus = login.loginStatus(loginUserName, loginpassword);
         
         JOptionPane.showMessageDialog(null, loginStatus);
         System.exit(0);
        
         
            }
        }
    }
        
    }
    

