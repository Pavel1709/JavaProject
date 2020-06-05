/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factoruexample;

import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.TimeUnit;
/**
 *
 * @author pavel1709
 */
public class FactoruExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, InterruptedException {
      LibFrame j1 = new LibFrame();
      j1.setVisible(true);
     
    // Manipulator DM= new Manipulator();
    //  DM.generateData();
    //  DM.initialize();
       /*
      Library library = new Library();
      library.LibraryAggregate();
      /*
      Library.availableBooks.keySet().stream().map((book) -> {
          System.out.println(book.getName());
            return book;
        }).forEachOrdered((book) -> {
            System.out.println(Library.availableBooks.get(book));
        });
      /*
        UserFactory1 u = new UserFactory1();
        Debter d = new Debter();
        //  d.addDebt(u.usersArray.get(1), Manipulator.BookDataManipulator.bookList.get(5));
        d.addDebt(u.usersArray.get(2), Manipulator.BookDataManipulator.bookList.get(3));
        try {
        d.removeDebt(u.usersArray.get(2), Manipulator.BookDataManipulator.bookList.get(3));
        }
        catch(Exception e) {
        System.out.println("Такого долга нет");
        }
        //d.removeDebt(new Debt(u.usersArray.get(2), Manipulator.BookDataManipulator.bookList.get(5)));
        //d.removeDebt(new Debt(u.usersArray.get(1), Manipulator.BookDataManipulator.bookList.get(5)));
        //d.removeDebt(u.usersArray.get(1), Manipulator.BookDataManipulator.bookList.get(5));
        //  d.removeDebt(UserFactory1.usersArray.get(1), Manipulator.BookDataManipulator.bookList.get(5));
        for(Debt dd: d.debtList) {
        System.out.println(dd);
        }
        Librarian l = new Librarian();
        //System.out.println(d.findUserWithDebt(u.usersArray.get(2)));
        System.out.println(l.checkDebt(u.usersArray.get(2)));
        System.out.println( d.findUserWithDebt(u.usersArray.get(2)));
        Reserver r = new Reserver();
        //r.addReservation(u.usersArray.get(2),Manipulator.BookDataManipulator.bookList.get(5));
        //r.removeReservation(u.usersArray.get(2),Manipulator.BookDataManipulator.bookList.get(5));
        System.out.println(r.checkReserve(Manipulator.BookDataManipulator.bookList.get(5)));
        Date date = new Date();
        System.out.println(date);
        Recorder rr = new Recorder();
        rr.addRecord( u.usersArray.get(2), Manipulator.BookDataManipulator.bookList.get(5), new Date());
        TimeUnit.SECONDS.sleep(1);
        rr.addRecord( u.usersArray.get(2), Manipulator.BookDataManipulator.bookList.get(5), new Date());
        TimeUnit.SECONDS.sleep(1);
        rr.addRecord( u.usersArray.get(2), Manipulator.BookDataManipulator.bookList.get(5), new Date());
        TimeUnit.SECONDS.sleep(1);
        rr.addRecord( u.usersArray.get(2), Manipulator.BookDataManipulator.bookList.get(5), new Date());
        TimeUnit.SECONDS.sleep(1);
        rr.addRecord( u.usersArray.get(2), Manipulator.BookDataManipulator.bookList.get(5), new Date());
        TimeUnit.SECONDS.sleep(1);
        rr.addRecord( u.usersArray.get(2), Manipulator.BookDataManipulator.bookList.get(5), new Date());
        TimeUnit.SECONDS.sleep(1);
        rr.addRecord( u.usersArray.get(2), Manipulator.BookDataManipulator.bookList.get(5), new Date());
        TimeUnit.SECONDS.sleep(1);
        rr.addRecord( u.usersArray.get(2), Manipulator.BookDataManipulator.bookList.get(5), new Date());
        Executor ex = new Executor();
        ex.execute();
        Library lib = new Library();
        Library.LibraryAggregate();
        l.registrateUser(u.usersArray.get(2));
        l.givebook(u.usersArray.get(2),  Manipulator.BookDataManipulator.bookList.get(5));
        //u.usersArray.get(2).returnBook(Manipulator.BookDataManipulator.bookList.get(5));
        System.out.println(l.checkReg(u.usersArray.get(2)));
        System.out.println(!l.checkDebt(u.usersArray.get(2)));
        System.out.println(l.lookForBook(Manipulator.BookDataManipulator.bookList.get(5)));
        System.out.println(!Reserver.checkReserve(Manipulator.BookDataManipulator.bookList.get(5)));
        System.out.println(u.usersArray.get(15).books);
         */
    
   // Executor ex = new Executor();
   // ex.execute();
    
   //  Timer t = new Timer();
   /*
      Debter.debtList.forEach(a ->  {
            Debter.debtList.forEach(b -> {
        if ( t.checkUser(b,a) && t.checkJournal(a,b)  ) {
            Debter.debtList.remove(a);
        }
        
        });
        });
         Debter.debtList.forEach(a ->  {
            Debter.debtList.forEach(b -> {
        if ( t.checkUser(a,b) && t.checkJournal(a,b) ) {
            Debter.debtList.remove(a);
        }
        
        });
        });
    */
   /*
    for (Iterator<Debt> iterator1 = Debter.debtList.iterator(); iterator1.hasNext(); ) {
         for (Iterator<Debt> iterator2 = Debter.debtList.iterator(); iterator2.hasNext(); ) {
    Debt value1 = iterator1.next();
    Debt value2 = iterator2.next();
    if (value1.getBook().getName().equals(value2.getBook().getName())) {
        iterator1.remove();
    }
}
}
  */
 
  // Reserver.reserveList.forEach(r-> {System.out.println(r.book.getName());});
 
  //  ex.executeSQL();
    
     
    
    }
}
