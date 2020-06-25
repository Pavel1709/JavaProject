/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factoruexample;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pavel1709
 */
public class RussianTextBook implements TextBook {
    public String author;
    public String name;
    static ArrayList<String> nameList;
    static ArrayList<String> authorList;
   ImportBooks ib;
    public static int rni;
    RussianTextBook(int i) {
        
    }
   RussianTextBook ( ) {
       setName(generateName());
       setAuthor(generateAuthor());
       removeAll();
   }
   @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setAuthor(String author) {
       this.author = author;
    }
       @Override
    public String getName() {
       return name;
    }

    @Override
    public String getAuthor() {
      return author;
    }
    
    @Override
    public void generateNameandAuthorList() {
        ib = new ImportBooks();
        nameList = new ArrayList<String>();
        authorList = new ArrayList<String>();
        for (int i = 0; i < ib.russianTextBookNames.length; i++ ) {
           nameList.add(ib.russianTextBookNames[i]);
           authorList.add(ib.russianTextBookAuthors[i]);
        }
    }
    @Override
    public String generateName() {
        double rn = Math.random()*nameList.size();
        
          rni = (int) Math.floor(rn) ;
          if (rni == 20) {
              rni = 19;
          }
         return nameList.get(rni);
       
    }
    @Override
    public String generateAuthor() {
        
         return authorList.get(rni);
       
    }

   public void removeAll() {
        nameList.remove(rni);
        authorList.remove(rni);

    }
}
