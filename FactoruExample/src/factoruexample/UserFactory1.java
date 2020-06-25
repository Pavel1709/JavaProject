/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factoruexample;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author pavel1709
 */
public class UserFactory1 {
    static int amountOfUsers = 100;
    public UserFactory1() {
        
    }
    public User createUser(double rn) throws IOException {
        if (rn < 0.75) {
            return new Student() ;
        }
        else {
            return new Teacher();
        }
    }
    static ArrayList<User> usersArray= new ArrayList<User>();
    public ArrayList<User>  createUsers(int num_of_users) throws IOException {
         for (int i = 0; i < num_of_users; i++) {
        double rn = Math.random() ;
        usersArray.add(createUser(rn));
        
    }

         return usersArray;
    }

    
}
