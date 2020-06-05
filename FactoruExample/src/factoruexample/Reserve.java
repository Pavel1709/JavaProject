/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factoruexample;

//import java.util.Date;
import java.sql.Date;
/**
 *
 * @author pavel1709
 */
public class Reserve {
    User user;
    Bookable book;
    Journal journal;
    java.sql.Date date; 
    Reserve(User user,Bookable book, Date date) {
        this.book = book;
        this.user = user;
        this.date = date;
    }
    Reserve(User user,Journal journal,Date date) {
        this.journal = journal;
        this.user = user;
        this.date = date;
    }
    User getUser() {
        return user;
    }
    Bookable getBook() {
        return book;
    }
    Journal getJournal() {
        return journal;
    }

    public java.sql.Date getDate() {
        return date;
    }
    
}
