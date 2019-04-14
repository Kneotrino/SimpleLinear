/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linearsimple;

import java.awt.Color;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import linearsimple.controller.UserController;
import linearsimple.model.User;
import linearsimple.view.MainFrame;
import linearsimple.view.loginPanel;

/**
 *
 * @author Rinoier
 */
public class LinearSimple {

    /**
     * @param args the command line arguments
     */
    
public static boolean  password()
    {        
        List<User> users = userController.findUserEntities();               
        JPasswordField pf = new JPasswordField();        
        loginPanel panel = new loginPanel();
        
        Object[] choices = {"Login", "Batal"};
        Object defaultChoice = choices[0];
        int okCxl = JOptionPane.showOptionDialog(
                null, 
                panel, 
                "Masukan username dan password", 
                JOptionPane.OK_CANCEL_OPTION, 
                JOptionPane.PLAIN_MESSAGE,
                null,
                choices,
                defaultChoice
                );
        System.out.println("okCxl = " + okCxl);
        if (okCxl == 0) {
              String text = panel.getUserField().getText();
              String pass = new String(panel.getPassField().getPassword());
              System.out.println("text = " + text);
              System.out.println("pass = " + pass);
              
              for (User user : users) {
                  if (user.getNama().equals(text)) {
                      if (user.getPass().equals(pass)) {
                          return true;
                      }
                  }
              }
        } 
        
        if (okCxl == -1 || okCxl == 1) {
            System.exit(okCxl);
        }
        return false;
    }    
        static UserController userController;
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("linearsimple.LinearSimple.main()");
        userController = new UserController();
        if (userController.getUserCount() == 0) {
            User user = new User(0, "admin", "admin");
            userController.create(user);
        }
        
        while (!password()) {            
            JOptionPane.showMessageDialog(null, "Password Salah");                        
        }        
        MainFrame.main(args);
    }
    
}
