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
public class Recorder {
    static int e = 0;
     static ArrayList<Record> recordList = new ArrayList<>();
     public static void addRecord(User user,Bookable book, Date date) {
      recordList.add(new Record( e, user, book, date));
      e++;
     }
     public static void addRecord(User user,Journal journal, Date date) {
      recordList.add(new Record( e, user, journal, date));
      e++;
     }
     public static Record findRecord(Bookable book,User user) {
        
         for (int rh = 0; rh <  recordList.size() ; rh++) {
             if (checkBook(rh , book) && checkUser(rh, user)) {
              //    System.out.println(recordList.get(rh).getBook().getName());
                 return recordList.get(rh) ;
             }
         }
         return null;
     }
     public Record findRecord(Journal journal,User user) {
         for (int ih = 0; ih <  recordList.size(); ih++) {
             if (checkJournal(ih , journal) && checkUser(ih, user)) {
//                 System.out.println(recordList.get(ih).getBook().getName());
                 return recordList.get(ih) ;
             }
         }
         return null;
     }
     public static boolean checkUser(int i, User user) {
         if  (recordList.get(i).getUser().getName().equals(user.getName()) ) {
           if ( recordList.get(i).getUser().getSurname().equals(user.getSurname())) {
               if ( recordList.get(i).getUser().getPatronim().equals(user.getPatronim())) {
                   return true;
               }
           }
         }
         return false;
    }
     public static boolean checkBook(int i, Bookable book) {
         return recordList.get(i).getBook().getName().equals(book.getName());
    }
       public boolean checkJournal(int i, Journal journal) {
         if  (recordList.get(i).getJournal().getName().equals(journal.getName())  ) {
            if (recordList.get(i).getJournal().getYear() == journal.getYear() ) {
                if(recordList.get(i).getJournal().getVolume() == journal.getVolume()) {
                   return true;
               }
            }
         }
         return false;
    }
}