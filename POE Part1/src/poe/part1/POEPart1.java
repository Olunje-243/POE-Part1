/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package poe.part1;

import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class POEPart1 {
   static class UserLogIn {

        private String userName;
        private String password;
        private String cellPhone;
        private String firstName;
        private String lastName;
        private String enteredUsername;
        private String enteredPassword;

        public UserLogIn(String userName, String password, String cellPhone,
                         String firstName, String lastName,
                         String enteredPassword, String enteredUsername) {
            this.userName = userName;
            this.password = password;
            this.cellPhone = cellPhone;
            this.firstName = firstName;
            this.lastName = lastName;
            this.enteredPassword = enteredPassword;
            this.enteredUsername = enteredUsername;
        }

         
        public boolean checkUserName() {
            return userName.contains("_") && userName.length() <= 5;
        }

        
        public boolean checkPassword() {
            return password.matches(".*[A-Z].*") &&
                   password.matches(".*[0-9].*") &&
                   password.matches(".*[~!@#$%^&*()_+=-].*") &&
                   password.length() >= 8;
        }

        
        public boolean checkCellPhoneNumber() {
            String regex = "^\\+\\d{1,3}\\d{7,10}$";
            return Pattern.matches(regex, cellPhone);
        }

        
        public String registerUser() {
            if (!checkUserName()) {
                return "Username is not correctly formatted.";
            } else if (!checkPassword()) {
                return "Password is not correctly formatted.";
            } else if (!checkCellPhoneNumber()) {
                return "Cellphone number is not correctly formatted.";
            } else {
                return "User successfully registered.";
            }
        }

        
        public boolean loginUser() {
            return enteredUsername.equals(userName)
                    && enteredPassword.equals(password);
        }

        
        public String returnLoginStatus(boolean status) {
            if (status) {
                return "Welcome " + firstName + ", it is great to see you again.";
            } else {
                return "Username or password incorrect, please try again.";
            }
        }
    }

 
    public static void main(String[] args) {

        UserLogIn user = new UserLogIn(
                "kyl_1",        // username
                "Ch&&sec@ke99!",     // password
                "+27838968976", // cellphone
                "Kyle",         // first name
                "Adams",          // last name
                "Ch&&sec@ke99!",     // entered password
                "kyl_1"         // entered username
        );

       
        System.out.println(user.registerUser());

        
        boolean loginStatus = user.loginUser();

        
        System.out.println(user.returnLoginStatus(loginStatus));
    }
}
            

       
    
      