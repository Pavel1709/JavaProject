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
import org.apache.commons.math3.distribution.WeibullDistribution;

/**
 *
 * @author pavel1709
 */
public class EnglishFiction implements Fiction {
    public String name;
    public String author;
    static ArrayList<String> nameList;
    static ArrayList<String> authorList;
    ImportBooks ib;
    WeibullDistribution w;
    public static int i;
    EnglishFiction(int l) {
        
    }
    
    EnglishFiction () {
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
        for (int i = 0; i < ImportBooks.englishFictionNames.length; i++ ) {
           nameList.add(ImportBooks.englishFictionNames[i]);
           authorList.add(ImportBooks.englishFictionAuthors[i]);
        }
    }
    @Override
    public String generateName() {
        w =new WeibullDistribution(1, 50);
        
         i = (int)Math.floor(w.sample()); 
         return nameList.get(i%(nameList.size() ));
       
    }
    @Override
    public String generateAuthor() {
         return authorList.get(i%nameList.size());

    }
      public void removeAll() {
        nameList.remove(i%nameList.size());
        authorList.remove(i%nameList.size());
    }
}
    

