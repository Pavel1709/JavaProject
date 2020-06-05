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
public class Manipulator {
    ArrayList<User> users ;
   // ArrayList<Books> Books;
    ArrayList<Record> Records;
    ArrayList<Journal> Journals;
    Student st;
    static int amountOfBooks = 76;
            public Manipulator() {
                
            }
            public void initialize() throws IOException {
                
                User.generateNameList() ;
                
                Student.generateGroupNameList();
                Student.generateSurNameListForWomen();
                Student.generateSurNameListForMen();
                Teacher.generateDepartmentList();
                Teacher.generateSurNameListForMen();
                Teacher.generateSurNameListForWomen();
                Teacher.generatePatronimListForMen();
                Teacher.generatePatronimListForWomen();
                
            }
            
            public void generateData() throws IOException {
                JournalDataManipulator JDM = new JournalDataManipulator();
                Journals = JDM.createJournals();
                BookDataManipulator BDM = new BookDataManipulator();
                EnglishFiction ef = new EnglishFiction(1);
                RussianFiction rf = new RussianFiction(1);
                EnglishTextBook etb = new EnglishTextBook(1);
                RussianTextBook rtb = new RussianTextBook(1);
                ef.generateNameandAuthorList();
                rf.generateNameandAuthorList();
                etb.generateNameandAuthorList();
                etb.generateUniversitiesAndLevelsList();
                rtb.generateNameandAuthorList();
                
                BDM.createTestBook();
                
                System.out.println("VSE");
                UserFactory1 UF = new UserFactory1();
                users=UF.createUsers(100);
            }
            
            
            
            static ArrayList<Journal> journals;
          private static class JournalDataManipulator {
              
                public JournalDataManipulator() {
                    
                }
                   public  ArrayList<Journal> createJournals() {
        
          journals = new ArrayList<Journal>();
        
        JournalDirector JD = new JournalDirector();
        
      
        JD.setJB(new PhysicsJournalBuilder());
        journals.addAll(createThematicalJournals(JD));
        
        
        JD.setJB(new AstronomicalJournalBuilder());
        journals.addAll(createThematicalJournals(JD));
        return journals;
    }
    
    public ArrayList<Journal> createThematicalJournals(JournalDirector JD) {
        
    ArrayList<Journal> thematicalJournals = new ArrayList<Journal>();
    
   // ArrayList<Journal> AstronomicalJournals = new ArrayList<Journal>();
    while (! JD.isJournalsIsOver()) {
    JD.createJournal();
    thematicalJournals.add(JD.getJournal());
    } 
    return thematicalJournals;
            }
}
              static class BookDataManipulator {
                  static ArrayList<Bookable> bookList = new ArrayList<Bookable> ();
              public BookDataManipulator() {
               
              }
              public void createTestBook() {
              BookFactory factory;
              int i = 0;
              while (i<amountOfBooks) {
                  int R = i- (int) Math.floor(i/4)*4;
                    switch (R) {
                        case 0: {factory = new RussianBookFactory(); 
                        bookList.add(factory.createFiction());}
                        break;
                        case 1: {factory = new RussianBookFactory(); 
                        bookList.add(factory.createTextBook());}
                        break;
                        case 2: {factory = new EnglishBookFactory(); 
                        bookList.add(factory.createFiction());}
                        break;
                        case 3: {factory = new EnglishBookFactory(); 
                        bookList.add(factory.createTextBook());}
                        break;  
                    }
                          i++;
                      }
              
          }
          }
}
