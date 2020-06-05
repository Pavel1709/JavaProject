/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factoruexample;

/**
 *
 * @author pavel1709
 */
public class Debt {
    int id;
    User user;
    Bookable book;
    Journal journal;
    Debt(User user,Bookable book) {
       this.user = user;
       this.book = book;  
    }
    Debt(User user,Journal journal) {
       this.user = user;
       this.journal = journal;  
    }
    Debt(User user) {
        this.user = user;
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

}
