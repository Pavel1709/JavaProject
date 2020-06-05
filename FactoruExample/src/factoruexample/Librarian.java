/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factoruexample;

import java.util.ArrayList;
import java.sql.Date;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author pavel1709
 */
public class Librarian {
      //Date date;     
    static ArrayList<User> registratedUsers = new ArrayList<>();
    Library lib = new Library();
    Debter debter = new Debter();
    Reserver r = new Reserver(); 
    Recorder rr = new Recorder();
    Random rand = new Random();
    Timer timer = new Timer();
    int h;
    void registrateUser(User user) {
        
            for(User u : registratedUsers) {
                 if (! ((u.getName().equals(user.getName())) && (u.getSurname().equals(user.getSurname())) && (u.getPatronim().equals(user.getPatronim() )) ) ) {
                     if(!registratedUsers.contains(user)) {
                       registratedUsers.add(user);
                     }
                     
                 }      
            }     
    }
    void registrateUser1(User user) {
  
                     if(!registratedUsers.contains(user)) 
                       registratedUsers.add(user);
                    
    }
    boolean checkReg(User user) {
        if (registratedUsers.contains(user))
          
            return true;
                 //}
        else
            return false;
    }
    boolean lookForBook(Bookable book) {
        if (lib.availableBooks.containsKey(book)) {
            if (lib.availableBooks.get(book) > 0) {
            return true;
            }
        }
        return false;
    }
    boolean lookForJournal(Journal journal) {
        if (lib.availableJournals.containsKey(journal)) {
            if (lib.availableJournals.get(journal) > 0) {
            return true;
            }
        }
        return false;
    }
     boolean checkDebt(User user) {
         int i = debter.findUserWithDebt(user);
        if (i != -1) {
            return true;  
        }
      return false;
    }
    public void givebook( User user, Bookable book) {
          h  += rand.nextInt(7300000);
          long ll = 9999999999l;
          Date date = new Date((System.currentTimeMillis() - ll ) + h);
        if (checkReg(user)) {
           if (!checkDebt(user)) {
               if (lookForBook(book)) { 
                   if (!Reserver.reserveList.isEmpty() && !Reserver.checkReserve(book)) {
                       user.takeBook(book);
                       Recorder.addRecord( user,book, date);
                       lib.takeBook(book);
                       
                      
                   }
                   else {
                       System.out.println("Просим прощения, данная книга уже зарезервирована. Хотите взять другую книгу?");
                           Scanner sss = new Scanner(System.in);
                            String ssss = sss.nextLine();
                            if (ssss.equals("да") || ssss.equals("Да")|| ssss.equals("ДА")||ssss.equals("Д")||ssss.equals("д")|| ssss.equals("Y")||ssss.equals("y")|| ssss.equals("Yes")|| ssss.equals("yes") || ssss.equals("YES")) {
                             givebook(user,Manipulator.BookDataManipulator.bookList.get(rand.nextInt(Manipulator.BookDataManipulator.bookList.size())));
                            }
                   }
               }
               else {
                   System.out.println(book.getName()+ " не в наличии. Хотите зарезервировать?");
                   Scanner s = new Scanner(System.in);
                   String ss = s.nextLine();
                   if ((ss.equals("да") || ss.equals("Да")|| ss.equals("ДА")||ss.equals("Д")||ss.equals("д")|| ss.equals("Y")||ss.equals("y")|| ss.equals("Yes")|| ss.equals("yes") || ss.equals("YES"))) {
                       if(!Reserver.checkReserve(book)) {
                        r.addReservation(user, book, date);
                       }
                       else {
                           System.out.println("Просим прощения, данная книга уже зарезервирована. Хотите взять другую книгу?");
                           Scanner sss = new Scanner(System.in);
                            String ssss = sss.nextLine();
                            Bookable l = Manipulator.BookDataManipulator.bookList.get(rand.nextInt(Manipulator.BookDataManipulator.bookList.size()));
                            if (ssss.equals("да") || ssss.equals("Да")|| ssss.equals("ДА")||ssss.equals("Д")||ssss.equals("д")|| ssss.equals("Y")||ssss.equals("y")|| ssss.equals("Yes")|| ssss.equals("yes") || ssss.equals("YES")) {
                             givebook(user,l);
                             Recorder.addRecord( user,l,date);
                            }
                       }
                   }
               }
           }
           else {
               System.out.println(user.getName()+" "+user.getSurname()+ " имеет задолженности. Верните книги прежде чем взять новую.");
           }
           
        }
        else {
            
                 
            System.out.println(user.getName()+" " + user.getPatronim()+" "+user.getSurname() + " не зарегистрирован в библиотеке, зарегистрировать?(да или нет)");
            Scanner s = new Scanner(System.in);
            String ss = s.nextLine();
                   if ((ss.equals("да") || ss.equals("Да")|| ss.equals("ДА")||ss.equals("Д")||ss.equals("д")|| ss.equals("Y")||ss.equals("y")|| ss.equals("Yes")|| ss.equals("yes") || ss.equals("YES"))) {
             registrateUser1(user);
             givebook(user,book);
            }
              
            }
        
    }
     public void giveJournal( User user, Journal journal) {
           h += rand.nextInt(7300000);
           long ll = 9999999999l;
          Date date = new Date(System.currentTimeMillis() - ll + h);
        if (checkReg(user)) {
           if (!checkDebt(user)) {
               if (lookForJournal(journal)) { 
                   if (!Reserver.checkReserve(journal)) {
                       user.takeJournal(journal);
                       Recorder.addRecord( user,journal, date);
                       lib.takeJournal(journal);
//                       timer.checkTimeOfRecod(rr.findRecord(journal, user)); 
                   }
                   else {
                       System.out.println("Просим прощения, данный журнал уже зарезервирован. Хотите взять другой ?");
                           Scanner sss = new Scanner(System.in);
                            String ssss = sss.nextLine();
                            if (ssss.equals("да") || ssss.equals("Да")|| ssss.equals("ДА")||ssss.equals("Д")||ssss.equals("д")|| ssss.equals("Y")||ssss.equals("y")|| ssss.equals("Yes")|| ssss.equals("yes") || ssss.equals("YES")) {
                             giveJournal(user,Manipulator.journals.get(rand.nextInt(Manipulator.journals.size())));
                            }
                   }
               }
               else {
                   System.out.println(journal.getName()+" "+journal.getVolume() + " не в наличии. Хотите зарезервировать?");
                   Scanner s = new Scanner(System.in);
                   String ss = s.nextLine();
                   if ((ss.equals("да") || ss.equals("Да")|| ss.equals("ДА")||ss.equals("Д")||ss.equals("д")|| ss.equals("Y")||ss.equals("y")|| ss.equals("Yes")|| ss.equals("yes") || ss.equals("YES"))) {
                       if(!Reserver.checkReserve(journal)) {
                        r.addReservation(user, journal, date);
                       }
                       else {
                           System.out.println("Просим прощения, данный журнал уже зарезервирован . Хотите взять другой?");
                           Scanner sss = new Scanner(System.in);
                            String ssss = sss.nextLine();
                            Journal l = Manipulator.journals.get(rand.nextInt(Manipulator.journals.size()));
                            if (ssss.equals("да") || ssss.equals("Да")|| ssss.equals("ДА")||ssss.equals("Д")||ssss.equals("д")|| ssss.equals("Y")||ssss.equals("y")|| ssss.equals("Yes")|| ssss.equals("yes") || ssss.equals("YES")) {
                             giveJournal(user,l);
                             Recorder.addRecord( user,l,date);
                            }
                       }
                   }
               }
           }
           else {
               System.out.println(user.getName()+" "+user.getSurname()+ " имеет задолженности. Верните журнал прежде чем взять новый.");
           }
           
        }
        else {
            
                 
            System.out.println(user.getName()+" " + user.getPatronim()+" "+user.getSurname() + " не зарегистрирован в библиотеке, зарегистрировать?(да или нет)");
            Scanner s = new Scanner(System.in);
            String ss = s.nextLine();
                   if ((ss.equals("да") || ss.equals("Да")|| ss.equals("ДА")||ss.equals("Д")||ss.equals("д")|| ss.equals("Y")||ss.equals("y")|| ss.equals("Yes")|| ss.equals("yes") || ss.equals("YES"))) {
             registrateUser1(user);
             giveJournal(user,journal);
            }
              
            }
        
    }
    public void takebook( User user, Bookable book) {
        user.returnBook(book);
        lib.returnBook(book);
    }
    public void takeJournal( User user, Journal journal) {
        user.returnJournal(journal);
        lib.returnJournal(journal);
    }
}
