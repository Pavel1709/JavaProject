/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factoruexample;

import java.util.ArrayList;
import java.sql.Date;

/**
 *
 * @author pavel1709
 */
public class Reserver {
     
     static ArrayList<Reserve> reserveList = new ArrayList<>();
     public void addReservation(User user, Bookable book, Date date) {
      reserveList.add(new Reserve( user, book, date));
     }
     public void addReservation(User user, Journal journal, Date date ) {
      reserveList.add(new Reserve( user, journal, date ));
     }
     public void removeReservation(User user, Bookable book ) {
      reserveList.remove(findReserve(user, book));
     }
     public void removeReservation(User user, Journal journal) {
      reserveList.remove(findReserve(user, journal));
     }
     int findReserve(User user, Bookable book) {
        for (int i=0;i < reserveList.size(); i++ ) {
          if  ((reserveList.get(i).getUser().equals(user) && (reserveList.get(i).getBook().equals(book) ) )) {
              return i;
          }
              
        }
          return -1;
    }
     int findReserve(User user, Journal journal) {
        for (int i=0;i < reserveList.size(); i++ ) {
          if  ((reserveList.get(i).getUser().equals(user) && (reserveList.get(i).getJournal().equals(journal) ) )) {
              return i;
          }
              
        }
          return -1;
    }
     
     static boolean checkReserve(Bookable book) {
        for (int i = 0; i <reserveList.size(); i++ ) {
         if  (reserveList.get(i).getBook().equals(book)) {
          return true;
        }          
     }
     return false;
    }
     static boolean checkReserve(Journal journal) {
        for (int i = 0; i <reserveList.size(); i++ ) {
         if  (reserveList.get(i).getBook().equals(journal)) {
          return true;
        }          
     }
     return false;
    }
}