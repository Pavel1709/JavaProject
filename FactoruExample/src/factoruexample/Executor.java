/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factoruexample;

import java.sql.SQLException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pavel1709
 */
public class Executor {
    SQLconnector sql = new SQLconnector();
    Library library = new Library();
    Librarian librarian = new Librarian();
    UserFactory1 uf = new UserFactory1();
    Random r = new Random();
    Timer timer = new Timer();
    Recorder rr = new Recorder();
    int itterations = 280;
    int amountOfBooksInLib = 350;
    int returns = 30;
    public void execute() {
        library.LibraryAggregate();
        for(int i = 0;i < amountOfBooksInLib; i++) {
            librarian.registrateUser1(uf.usersArray.get(r.nextInt(uf.usersArray.size()-1)));
        }
        for(int i = 0;i < itterations; i++) {
            Bookable b = Manipulator.BookDataManipulator.bookList.get(r.nextInt(Manipulator.BookDataManipulator.bookList.size()-1));
            Journal j = Manipulator.journals.get(r.nextInt(Manipulator.journals.size()-1));
            User u1 = uf.usersArray.get(r.nextInt(uf.usersArray.size()-1));
            User u2 = uf.usersArray.get(r.nextInt(uf.usersArray.size()-1));
             librarian.giveJournal(u1 , j);
             librarian.givebook(u2, b);
             //librarian.takebook(Recorder.recordList.get(r.nextInt(Recorder.recordList.size())).getUser(), Recorder.recordList.get(r.nextInt(Recorder.recordList.size())).getBook());
             //librarian.takeJournal(Recorder.recordList.get(r.nextInt(Recorder.recordList.size())).getUser(), Recorder.recordList.get(r.nextInt(Recorder.recordList.size())).getJournal());
        }
        
      for (int i = 0; i < returns; i++ ) {
           int l = r.nextInt(Recorder.recordList.size()-1);
           int ll = r.nextInt(Recorder.recordList.size()-1);
             librarian.takebook(Recorder.recordList.get(l).getUser(), Recorder.recordList.get(l).getBook());
             librarian.takeJournal(Recorder.recordList.get(ll).getUser(), Recorder.recordList.get(ll).getJournal());
        }
         
        for(int i = 0;i < Recorder.recordList.size(); i++) {
           timer.checkTimeOfRecod(Recorder.recordList.get(i)); 
        }
        
    }
    public void executeSQL() {  
      sql.setConnectionParams("jdbc:mysql://localhost/?useUnicode=true&serverTimezone=UTC", "root", "gfijr179");
      try{
          sql.connect();
          sql.checkConnection();
          sql.createTable();
          sql.fillTable();
          sql.disconnect();
      }
      catch(SQLException ex) {
          Logger.getLogger(Executor.class.getName()).log(Level.SEVERE, null , ex);
      }
    }
    }

