/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factoruexample;

import java.util.ArrayList;

/**
 *
 * @author pavel1709
 */
public class Debter {
    static ArrayList<Debt> debtList = new ArrayList<>();
    void addDebt(User user, Bookable book) {
        if (user.books.contains(book)) {
        debtList.add(new Debt(user, book));
     }
    }
    void addDebt(User user, Journal journal) {
        if (user.books.contains(journal)) {
        debtList.add(new Debt(user, journal));
        }
    }
    int findDebt(User user, Bookable book) {
        for (int i=0;i < debtList.size(); i++ ) {
          if  ((debtList.get(i).getUser().equals(user) && (debtList.get(i).getBook().equals(book) ) )) {
              return i;
          }
              
        }
          return -1;
    }
    int findDebt(User user, Journal journal) {
        for (int i=0;i < debtList.size(); i++ ) {
          if  ((debtList.get(i).getUser().equals(user) && (debtList.get(i).getJournal().equals(journal) ) )) {
              return i;
          }
              
        }
          return -1;
    }
    
      int findUserWithDebt(User user) {
       for (int i=0;i < debtList.size(); i++ ) {
          if  ( debtList.get(i).getUser().equals(user) ) {
              return i;
          }
              
        }
          return -1;
    }

    void removeDebt(User user, Bookable book) {
        debtList.remove(findDebt(user, book));
    }
}
