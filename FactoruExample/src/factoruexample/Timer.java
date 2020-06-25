/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factoruexample;

import java.util.Date;

/**
 *
 * @author pavel1709
 */
public class Timer {
    Debter d = new Debter();
    Date dd = new Date();
    long raz = (long) 9e+9;
    public void checkTimeOfRecod(Record r) {

            if (r.getDate().getTime() <  (dd.getTime()-raz) ) {
                
                if (r.getBook()  != null) {
                             d.addDebt(r.getUser(), r.getBook());
                        
                }
           
                else {
                        d.addDebt(r.getUser(), r.getJournal());

                }
            }
        }
    public boolean checkUser(Debt r, Debt i) {
        if ( ((i.getUser().getName().equals(r.getUser().getName()) ) && (i.getUser().getSurname().equals(r.getUser().getSurname()) ) &&  (i.getUser().getPatronim().equals(r.getUser().getPatronim())))) 
          return true;  
          return false;
    }
    public boolean checkBook(Debt r, Debt i) {
        if ( (i.getBook().getName().equals(r.getBook().getName()))) {
            return true;
        }
        return false;
    }
    public boolean checkJournal(Debt r, Debt i) {
        if ( (i.getJournal().getName().equals(r.getJournal().getName()))) {
            return true;
        }
        return false;
    }
}  
        
    




