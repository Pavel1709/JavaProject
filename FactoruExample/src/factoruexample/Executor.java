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
    public void execute() {
        
        library.LibraryAggregate();
        for(int i = 0;i < 350; i++) {
            librarian.registrateUser1(uf.usersArray.get(r.nextInt(uf.usersArray.size()-1)));
        }
        for(int i = 0;i < 300; i++) {
            Bookable b = Manipulator.BookDataManipulator.bookList.get(r.nextInt(Manipulator.BookDataManipulator.bookList.size()-1));
            Journal j = Manipulator.journals.get(r.nextInt(Manipulator.journals.size()-1));
            User u = uf.usersArray.get(r.nextInt(uf.usersArray.size()-1));
             librarian.giveJournal(u , j);
             librarian.givebook(u, b);
//            timer.checkTimeOfRecod(Recorder.findRecord(b, u)); 

           // timer.checkTimeOfRecod(rr.findRecord(b, u)); 
         //   timer.checkTimeOfRecod(rr.findRecord(j, u)); 
        }
        for(int i = 0;i < Recorder.recordList.size(); i++) {
          // librarian.giveJournal(uf.usersArray.get(r.nextInt(uf.usersArray.size()-1)), Manipulator.journals.get(r.nextInt(Manipulator.journals.size()-1)));
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

