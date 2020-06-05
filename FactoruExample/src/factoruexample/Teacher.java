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
public class Teacher extends User {
      static ImportPeople ip;
   //public String groupName ;
  private static ArrayList <String> DepartmentList;
  
   private static ArrayList <String> SurNameListForMen;
   private static ArrayList <String> SurNameListForWomen;
   private static ArrayList <String> patronimsListforMen ;
   private static ArrayList <String> patronimsListforWomen ;
   public Teacher () throws IOException {
       
       this.setName(User.generateName());
       this.setId(User.generateID());
       this.setDepartment(generateDepartment());
       this.setSurname(generateSurName());
       this.setPatronim(generatePatronim());
      
   }
    public String department;
      @Override
    public String getDivision() {
       return department;
    }
     public void setDepartment(String department) {
        this.department=department;
    }
       public static void generateDepartmentList() {
        DepartmentList = new ArrayList<String>();
        DepartmentList.add("ИИКС");
        DepartmentList.add("ФБИУКС");
        DepartmentList.add("ИФТЭБ");
        DepartmentList.add("ИЯФИТ");
    }
       
       public static String generateDepartment () {
        generateDepartmentList();
        double rn = Math.random()*DepartmentList.size();
        
         int rni = (int) Math.floor(rn) ;
          if (rni == 4) {
              rni = 3;
          }
         return DepartmentList.get(rni);
}
    
   
  
     
         public static void generateSurNameListForMen()  {
           ip = new ImportPeople();
        SurNameListForMen = new ArrayList<String>();
        /*
          try {
              ip.ImportTeahersSurNames();
          } catch (IOException ex) {
              Logger.getLogger(Teacher.class.getName()).log(Level.SEVERE, null, ex);
          }
        */
        for (String surnames: ip.teachersSurnames ) {
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
       // SurNameListForMen.add(surnames);
        }
       
    }
         public static void generateSurNameListForWomen()  {
           ip = new ImportPeople();
        SurNameListForWomen = new ArrayList<String>();
        /*
          try {
              ip.ImportTeahersSurNames();
          } catch (IOException ex) {
              Logger.getLogger(Teacher.class.getName()).log(Level.SEVERE, null, ex);
          }
        */
        for (String surnames: ip.teachersSurnames ) {
            switch(surnames.charAt(surnames.length()-1)) {
                case 'в' : SurNameListForWomen.add(surnames+'a');
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
        //SurNameListForMen.add(surnames);
        }
       
    }
         
        public static String generateSurName () {
        generateSurNameListForMen();
        generateSurNameListForWomen();
        String s ="";
       // double rn = Math.random()*SurNameListForMen.size();
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
     
        public static void generatePatronimListForMen() throws IOException {
            String pat ="";
            ip = new ImportPeople();
            //ip.ImportNames();
          
             patronimsListforMen = new ArrayList<String> ();
            for (String names: ip.names) {
                if  (  (names.charAt(names.length()-1) != 'a') && (names.charAt(names.length()-1) != 'я')) {
                       switch (names.charAt(names.length()-1)) {
                           case ('н') : patronimsListforMen.add(names+"ович");
                           break;
                           case ('р') : patronimsListforMen.add(names+"ович");
                           break;
                           case ('в') : patronimsListforMen.add(names+"ович");
                           break;
                           case ('с') : patronimsListforMen.add(names+"ович");
                           break;
                            case('й') : { 
                               for (int i = 0; i< names.length()-1; i++) {
                                   pat+=names.charAt(i);
                               }
                               patronimsListforMen.add(pat+"евич"); }
                            pat="";
                               break; 
                           
                               
                }
                       
                }    
        }
           
}
        public static void generatePatronimListForWomen() throws IOException {
            String pat ="";
            ip = new ImportPeople();
            //ip.ImportNames();
          
             patronimsListforWomen = new ArrayList<String> ();
            for (String names: ip.names) {
                if  (  (names.charAt(names.length()-1) != 'a') && (names.charAt(names.length()-1) != 'я')) {
                       switch (names.charAt(names.length()-1)) {
                           case ('н') : patronimsListforWomen.add(names+"овна");
                           break;
                           case ('р') : patronimsListforWomen.add(names+"овна");
                           break;
                           case ('в') : patronimsListforWomen.add(names+"овна");
                           break;
                           case ('с') : patronimsListforWomen.add(names+"овна");
                           break;
                            case('й') : { 
                               for (int i = 0; i< names.length()-1; i++) {
                                   pat+=names.charAt(i);
                               }
                               patronimsListforWomen.add(pat+"евна"); }
                            pat="";
                               break; 
                           
                               
                }
                       
                }    
        }
           
}
        
        public static String generatePatronim () throws IOException {
       generateNameList();
        String p="";
      
         //generateName();
        generatePatronimListForWomen();
        generatePatronimListForMen();
       
         switch (User.NameList.get(User.rni).charAt(User.NameList.get(User.rni).length()-1)) {
              case('а') : {
         
        double rn = Math.random()*patronimsListforWomen.size();
        
         int rni = (int) Math.floor(rn) ;
          if (rni == 12) {
              rni = 11;
          }
         p = patronimsListforWomen.get(rni); 
              }
              break;
       
              case('я') : {
         
        double rn = Math.random()*patronimsListforWomen.size();
        
         int rni = (int) Math.floor(rn) ;
          if (rni == 12) {
              rni = 11;
          }
         p = patronimsListforWomen.get(rni); 
              }
              break;
         case'в' : {
         
        double rn = Math.random()*patronimsListforMen.size();
        
         int rni = (int) Math.floor(rn) ;
          if (rni == 12) {
              rni = 11;
          }
         p = patronimsListforMen.get(rni); 
              }
              break;

         case'й' : {
         
        double rn = Math.random()*patronimsListforMen.size();
        
         int rni = (int) Math.floor(rn) ;
          if (rni == 12) {
              rni = 11;
          }
         p = patronimsListforMen.get(rni); 
              }
              break;
              case'н' : {
         
        double rn = Math.random()*patronimsListforMen.size();
        
         int rni = (int) Math.floor(rn) ;
          if (rni == 12) {
              rni = 11;
          }
         p = patronimsListforMen.get(rni); 
              }
              break;
              case'с' : {
         
        double rn = Math.random()*patronimsListforMen.size();
        
         int rni = (int) Math.floor(rn) ;
          if (rni == 12) {
              rni = 11;
          }
         p = patronimsListforMen.get(rni); 
              }
              break;
              case'р' : {
         
        double rn = Math.random()*patronimsListforMen.size();
        
         int rni = (int) Math.floor(rn) ;
          if (rni == 12) {
              rni = 11;
          }
         p = patronimsListforMen.get(rni); 
              }
              break;
}

         return p;
        }


}

