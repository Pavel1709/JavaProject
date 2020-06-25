/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factoruexample;

import static factoruexample.Teacher.generatePatronim;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pavel1709
 */
public class Student extends User {
   static ImportPeople ip;
   public String groupName ;
  private static ArrayList <String> GroupNameList;
  private static ArrayList <String> SurNameListForMen;
  private static ArrayList <String> SurNameListForWomen;
  private static ArrayList <String> patronimsListforWomen ;
  private static ArrayList <String> patronimsListforMen ;
   public Student () throws IOException {
       
       this.setName(User.generateName());
       this.setId(User.generateID());
       this.setGroupName(generateGroupName());
       this.setSurname(generateSurName());
       this.setPatronim(generatePatronim());
   }
   
    @Override
    public String getDivision() {
       return groupName;
    }
    public void setGroupName(String groupName) {
        this.groupName=groupName;
    }
       public static void generateGroupNameList() {
        GroupNameList = new ArrayList<String>();
        GroupNameList.add("B18-901");
        GroupNameList.add("B17-901");
        GroupNameList.add("B16-901");
        GroupNameList.add("B19-901");
    }
       
       public static String generateGroupName () {
        generateGroupNameList();
        double rn = Math.random()*GroupNameList.size();
        
         int rni = (int) Math.floor(rn) ;
          if (rni == 4) {
              rni = 3;
          }
         return GroupNameList.get(rni);
}
       
    
         
        
         public static void generateSurNameListForMen()  {
           ip = new ImportPeople();
        SurNameListForMen = new ArrayList<String>();
        for (String surnames: ImportPeople.studentsSurnames ) {
            switch(surnames.charAt(surnames.length()-1)) {
                case 'в' : SurNameListForMen.add(surnames);
                break;
                case 'к':  SurNameListForMen.add(surnames+"ий");
                break;
                case 'н':  
                    if(surnames.charAt(surnames.length()-2) == 'д')
                    SurNameListForMen.add(surnames+"ый");
                     if(surnames.charAt(surnames.length()-2) == 'и')
                    SurNameListForMen.add(surnames);
                      if(surnames.charAt(surnames.length()-2) == 'ы')
                    SurNameListForMen.add(surnames);
                      if(surnames.charAt(surnames.length()-2) == 'я')
                    SurNameListForMen.add(surnames);
                break;
                case 'о':  SurNameListForMen.add(surnames);
                break;
                case 'с':  SurNameListForMen.add(surnames);
                break;
                case 'ц':  SurNameListForMen.add(surnames);
                break;
            }
        }
       
    }
         public static void generateSurNameListForWomen()  {
           ip = new ImportPeople();
        SurNameListForWomen = new ArrayList<String>();
        for (String surnames: ImportPeople.studentsSurnames ) {
            switch(surnames.charAt(surnames.length()-1)) {
                case 'в' : SurNameListForWomen.add(surnames+ "a");
                break;
                case 'к':  SurNameListForWomen.add(surnames+"ая");
                break;
                case 'н':  
                    if(surnames.charAt(surnames.length()-2) == 'и')
                    SurNameListForWomen.add(surnames+"a");
                    if(surnames.charAt(surnames.length()-2) == 'я')
                    SurNameListForWomen.add(surnames);
                    if(surnames.charAt(surnames.length()-2) == 'д')
                    SurNameListForWomen.add(surnames+"ая");
                    if(surnames.charAt(surnames.length()-2) == 'ы')
                    SurNameListForWomen.add(surnames+"а");
                break;
                case 'о':  SurNameListForWomen.add(surnames);
                break;
                case 'с':  SurNameListForWomen.add(surnames);
                break;
                case 'ц':  SurNameListForWomen.add(surnames);
                break;
            }
        }
       
    }
         
        public static String generateSurName () {
        generateSurNameListForMen();
        generateSurNameListForWomen();
        String s ="";
        switch (User.NameList.get(User.rni).charAt(User.NameList.get(User.rni).length()-1)) {
              case('а') : {
        double rn = Math.random()*SurNameListForWomen.size();
         int rni = (int) Math.floor(rn) ;
          if (rni == 61) {
              rni = 60;
          }
         s = SurNameListForWomen.get(rni); 
              }
              break;
              
        case('я') : {
        double rn = Math.random()*SurNameListForWomen.size();
         int rni = (int) Math.floor(rn) ;
          if (rni == 61) {
              rni = 60;
          }
         s = SurNameListForWomen.get(rni); 
              }
              break;
        case('в') : {
        double rn = Math.random()*SurNameListForMen.size();
         int rni = (int) Math.floor(rn) ;
          if (rni == 61) {
              rni = 60;
          }
         s = SurNameListForMen.get(rni); 
              }
              break;
              case('й') : {
        double rn = Math.random()*SurNameListForMen.size();
         int rni = (int) Math.floor(rn) ;
          if (rni == 61) {
              rni = 60;
          }
         s = SurNameListForMen.get(rni); 
              }
              break;
              case('с') : {
        double rn = Math.random()*SurNameListForMen.size();
         int rni = (int) Math.floor(rn) ;
          if (rni == 61) {
              rni = 60;
          }
         s = SurNameListForMen.get(rni); 
              }
              break;
              case('н') : {
        double rn = Math.random()*SurNameListForMen.size();
         int rni = (int) Math.floor(rn) ;
          if (rni == 61) {
              rni = 60;
          }
         s = SurNameListForMen.get(rni); 
              }
              break;
              case('р') : {
        double rn = Math.random()*SurNameListForMen.size();
         int rni = (int) Math.floor(rn) ;
          if (rni == 61) {
              rni = 60;
          }
         s = SurNameListForMen.get(rni); 
              }
              break;
        }
         return s;
}
}
        