/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factoruexample;
import factoruexample.Manipulator.BookDataManipulator;
import java.util.*;
/**
 *
 * @author pavel1709
 */
public class Library {
    static int amountOfBooks = 76;
    static int amountOfJournals;
//  static int amountOfBooksInLib = Manipulator.amountOfBooks + Manipulator.journals.size() ;
  static Random r1 = new Random();
  static  Random r2 = new Random();
  static  Random r3 = new Random();
  static HashMap<Bookable,Integer> availableBooks = new HashMap<>();
  static HashMap<Journal,Integer> availableJournals = new HashMap<>();
  public static void LibraryAggregate() {
   for (int j = 0; j <  amountOfBooks; j++) {
        availableBooks.put(BookDataManipulator.bookList.get(r1.nextInt(Manipulator.amountOfBooks)), r2.nextInt(UserFactory1.amountOfUsers));
   }
   for (int j = 0; j < Manipulator.journals.size(); j++) {
       availableJournals.put(Manipulator.journals.get(j),r3.nextInt(100));
   }
  }
  public void takeBook(Bookable book) {
      availableBooks.put(book, availableBooks.get(book) - 1);
  }
  public void returnBook(Bookable book) {
      availableBooks.put(book, availableBooks.get(book) + 1);
  }
  public void takeJournal(Journal journal) {
      availableJournals.put(journal, availableJournals.get(journal) - 1);
  }
  public void returnJournal(Journal journal) {
      availableJournals.put(journal, availableJournals.get(journal) + 1);
  }
  
}
