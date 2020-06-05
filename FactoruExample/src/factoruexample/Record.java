/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factoruexample;

import java.sql.Date;

/**
 *
 * @author pavel1709
 */
public class Record {
    int id;
    User user;
    Bookable book;
    Journal journal;
    Date date; 
     Record(int id,User user,Bookable book, Date date) {
        this.id = id;
        this.book = book;
        this.user = user;
        this.date = date;
    }
     Record(int id,User user,Journal journal, Date date) {
        this.id = id;
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
    Date getDate() {
        return date;
    }

    int getId() {
        return id;
    }
    
}
