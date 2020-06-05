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
    public void checkTimeOfRecod(Record r) {
        
       // Recorder.recordList.forEach((r) -> {
            if (r.getDate().getTime() <  (dd.getTime()-1) ) {
                
                if (r.getBook()  != null) {
                   
                   // Debter.debtList.forEach(i-> { 
                        //Debter.debtList.stream().filter(b -> (!b.user.getName().equals(r.user.getName()))).forEach(b -> d.addDebt(r.getUser(), r.getBook()));
                  //      if ( (checkUser(r, b)) && (checkBook(r, b))) {
                             d.addDebt(r.getUser(), r.getBook());
                        
                }
           
            else {
              //  Debter.debtList.forEach(i-> {
                    
                   // if ( (checkUser(r, i)) && (checkJournal(r , i))) {
                        d.addDebt(r.getUser(), r.getJournal());
                  //  }});
            }
       // });
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
        
    




