
package chatapplogin;


public class LoginTest {
    
    private String saveduserName;
    private String savedpassword;
    
    public LoginTest() {
        
    }
    public void storedValues(String userName, String password) {
        this.saveduserName = userName ;
        this.savedpassword = password ;
    }
    
    
    public boolean checkUserName(String userName){
        if (userName == null || !userName.contains("_") || userName.length() > 5) {
            return false;
        }else {
            return true ;
        }
          
        }
    public boolean checkPasswordComplexity(String password) {
        if (password == null || password.length() > 8 ) {
            return false ;
        } 
        String caps = ".*[A-Z].*" ;
        String digits = ".*\\d.*";
        String special = ".*[!@#$%^&*(),.?\":{}|<>].*";
        if(password.matches(digits) && password.matches(caps) && password.matches(special)) {
            return true ;
        
        } 
        return false ;
    }
    public boolean checkCellPhoneNumber(String cellphone) {
        if (cellphone == null || cellphone.length() > 12 || cellphone.length() < 4) {
            return false ;
          
        } 
        String countryCode = "+27" ;
        String firstThreeSpaces = cellphone.substring(0, 3);
        int fourthNum = Character.getNumericValue(cellphone.charAt(3));
        
        if(firstThreeSpaces.equals(countryCode) && fourthNum >= 6 && fourthNum <= 8) {
            return true ;
        } return false;
    }
    public String registerUser(String userName, String password, String cellphone) {
        boolean authUsername = checkUserName(userName);
        boolean authPassword = checkPasswordComplexity(password);
        boolean authNumber = checkCellPhoneNumber(cellphone);
        
        if(authUsername && authPassword && authNumber) {
            return "User has been registered" ;
        }
        return "Registration Failed!!!";
    }
    
    public boolean loginUser(String loginuserName, String loginpassword, String saveduserName, String savedpassword) {
        if(loginuserName == null || loginpassword == null || saveduserName == null || savedpassword == null) {
            return false;
        } return loginuserName.equals(saveduserName) && loginpassword.equals(savedpassword);
        
    }
    public String loginStatus(String loginuserName, String loginpassword){
        if (loginuserName == null || loginpassword == null){
            return "Failed to Login";
        }
        boolean validUsername = checkUserName(loginuserName);
        boolean validPassword = checkPasswordComplexity(loginpassword);
        
        if (validUsername && validPassword && loginuserName.equals(saveduserName) && loginpassword.equals(savedpassword)){
            return "Login was successful";
            
        } return "Failed to Login";
    }
       
    
}
