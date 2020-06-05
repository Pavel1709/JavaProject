/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factoruexample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pavel1709
 */
public class SQLconnector {
  private String url;
    private String username;
    private String password;
    private Connection con;
    static Statement statement1;
    static Statement statement2;
    Recorder r = new Recorder();
    Library l = new Library();
    public void setConnectionParams(String url, String username, String password) {
      this. url = url;
      this.username = username;
      this.password = password;
     
}
     public void connect() throws SQLException{
         con = DriverManager.getConnection(url, username , password);
     }
     public void disconnect() throws SQLException{
         con.close();
     }
     public void checkConnection() throws SQLException {
         if (con.isValid(5)) {
             System.out.println("Connection is valid");
         }
         else {
             System.out.println("Connection is invalid");
         }
     }

    /**
     *
     * @throws SQLException
     */
    public void createTable() throws SQLException {
        statement1 = con.createStatement();
        statement1.executeUpdate("CREATE TABLE IF NOT EXISTS FactoruExample.Records (ID INTEGER not NULL,"+" User VARCHAR(70),"+" Book VARCHAR(255), "+"Date DATE," /*+  "FOREIGN KEY(Book) REFERENCES FactoruExample.Books(book) " */  + " PRIMARY KEY(ID))");
        statement1.executeUpdate("CREATE TABLE IF NOT EXISTS FactoruExample.Books (ID INTEGER not NULL,"+" Book VARCHAR(255), "+" Amount INTEGER,"+" PRIMARY KEY(ID))");
        statement1.executeUpdate("CREATE TABLE IF NOT EXISTS FactoruExample.Debts (ID INTEGER not NULL,"+"User VARCHAR(255),"+"Book VARCHAR(255),"+" PRIMARY KEY(ID))");
        statement1.executeUpdate("CREATE TABLE IF NOT EXISTS FactoruExample.Reserves (ID INTEGER not NULL,"+"User VARCHAR(255),"+"Book VARCHAR(255),"+"Date DATE,"+" PRIMARY KEY(ID))");
        statement1.executeUpdate("ALTER TABLE FactoruExample.Books MODIFY ID INTEGER NOT NULL AUTO_INCREMENT");
        statement1.executeUpdate("ALTER TABLE FactoruExample.Records MODIFY ID INTEGER NOT NULL AUTO_INCREMENT");
        statement1.executeUpdate("ALTER TABLE FactoruExample.Debts MODIFY ID INTEGER NOT NULL AUTO_INCREMENT");
        statement1.executeUpdate("ALTER TABLE FactoruExample.Reserves MODIFY ID INTEGER NOT NULL AUTO_INCREMENT");
        statement1.executeUpdate("SET NAMES 'utf8'");
         }
     String book;
    public void fillTable() throws SQLException {
     statement2 = con.createStatement();
     int id = 1;
     for(int i = 0; i < r.recordList.size();i++ ) {
         if (r.recordList.get(i).book == null) {
          book = r.recordList.get(i).getJournal().getName() + " " + r.recordList.get(i).getJournal().getYear() +" " + r.recordList.get(i).getJournal().getVolume();
         }
         else {
          book = r.recordList.get(i).getBook().getName() + " " + r.recordList.get(i).getBook().getAuthor();
         }
         String user = r.recordList.get(i).getUser().getName() +" "+ r.recordList.get(i).getUser().getPatronim() + " " + r.recordList.get(i).getUser().getSurname();
         Date date = Recorder.recordList.get(i).getDate();
         statement2.executeUpdate("INSERT INTO FactoruExample.Records (  User, Book, Date) VALUES( '"+user+"' , '"+book+"', '"+date+"')");
         id++;
     }
     Library.availableBooks.entrySet().forEach(s ->{try {
          statement2.executeUpdate("INSERT INTO FactoruExample.Books (Book ,Amount) VALUES ('"+s.getKey().getName()+" "+s.getKey().getAuthor()+"','"+s.getValue()+"')");}
          catch (SQLException ex) {
             Logger.getLogger(SQLconnector.class.getName()).log(Level.SEVERE, null, ex);
          }
          });
     Library.availableJournals.entrySet().forEach(s ->{try {
          statement2.executeUpdate("INSERT INTO FactoruExample.Books (Book ,Amount) VALUES ('"+s.getKey().getName()+" "+s.getKey().getVolume()+" "+s.getKey().getYear()+"',"+s.getValue()+")");}
          catch (SQLException ex) {
             Logger.getLogger(SQLconnector.class.getName()).log(Level.SEVERE, null, ex);
          }
          });
     Debter.debtList.forEach(d-> {
         if (d.getBook()   == null) {
             try {
                 statement2.executeUpdate("INSERT INTO FactoruExample.Debts(User, Book) VALUES ('"+ d.getUser().name +" "+d.getUser().patronim + d.getUser().surname+ "','" +d.getJournal().getName()+" " + d.getJournal().volume +" "+ d.getJournal().year+"')");
             } catch (SQLException ex) {
                 Logger.getLogger(SQLconnector.class.getName()).log(Level.SEVERE, null, ex);
             }
         }
         else {
             try {
                 statement2.executeUpdate("INSERT INTO FactoruExample.Debts(User, Book) VALUES ('"+ d.getUser().name +" "+d.getUser().patronim + d.getUser().surname+ "','" +d.getBook().getName()+" " + d.getBook().getAuthor()+"')");
             } catch (SQLException ex) {
                 Logger.getLogger(SQLconnector.class.getName()).log(Level.SEVERE, null, ex);
             }
         }
     });
    Reserver.reserveList.forEach(r -> 
    {
        if(r.getBook() == null)  {
            try {
                statement2.executeUpdate("INSERT INTO FactoruExample.Reserves(User, Book, Date) VALUES ('"+ r.getUser().name +" "+r.getUser().patronim + r.getUser().surname+ "','" +r.getJournal().getName()+" " + r.getJournal().volume +" "+ r.getJournal().year+ "','" +r.getDate()+"')");
            } catch (SQLException ex) {
                Logger.getLogger(SQLconnector.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else {
            try {
                statement2.executeUpdate("INSERT INTO FactoruExample.Reserves(User, Book, Date) VALUES ('"+ r.getUser().name +" "+r.getUser().patronim + r.getUser().surname+ "','" +r.getBook().getName()+" " + r.getBook().getAuthor()+"','"+r.getDate()+"')");
            } catch (SQLException ex) {
                Logger.getLogger(SQLconnector.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    });
      }
}
