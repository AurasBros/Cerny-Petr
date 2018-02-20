
package cernypetr;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author jan1h
 */
public class People {
    String DBurl = "";
    String DBuserName = "";
    String DBpsw = "";
    
    
    public People() {
        ArrayList<String> connection_data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("connection_data.txt"))) {
            String s;
            while ((s = br.readLine()) != null) {
                    connection_data.add(s);
            }
        }
        catch (Exception e) {
                System.err.println("Chyba při čtení ze souboru.");
        }
        
    DBurl = connection_data.get(0);
    DBuserName = connection_data.get(1);
    DBpsw = connection_data.get(2);
    }
//===============================================================================================================      
    
    public boolean connectivity() {
            String sql = "SELECT connectivity FROM connectivity"; //zakladni sql prikaz
            String connectivity = "";
            try {
                Connection conn = DriverManager.getConnection(DBurl,DBuserName,DBpsw);
                Statement stmt = conn.createStatement();
                
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {connectivity = rs.getString("connectivity");}
                
                conn.close();
            } 
            catch (Exception e) {//vytiskne error, jestli je
                System.err.println(e.getMessage());
                System.err.println("naser si");
            }
        return (Boolean.valueOf(connectivity));//vrati true, jestlize dostalo od databaze hodnotu true, jinak vrati false 
    }
//===============================================================================================================   
    
        public void selectJenda() {       
            try {
                Connection conn = DriverManager.getConnection(DBurl,DBuserName,DBpsw);
                Statement stmt = conn.createStatement();

                ResultSet rs = stmt.executeQuery("SELECT jenda FROM petr666");
                while ( rs.next() ) {
                    String lastName = rs.getString("jenda");
                    System.out.println(lastName);
                }
                    conn.close();
            } catch (Exception e) {
                System.err.println("Got an exception! ");
                System.err.println(e.getMessage());
            }
        }
//===============================================================================================================       
        
        public ArrayList getNames() { 
            ArrayList<String> names = new ArrayList<>(); 
            try {
                Connection conn = DriverManager.getConnection(DBurl,DBuserName,DBpsw);
                Statement stmt = conn.createStatement();

                ResultSet rs = stmt.executeQuery("SELECT name FROM people");
                while ( rs.next() ) {
                    String name = rs.getString("name");
                    names.add(name);
                }
                    conn.close();
            } catch (Exception e) {
                System.err.println("Got an exception! ");
                System.err.println(e.getMessage());
            }
            return(names);
        }        
//===============================================================================================================               
        
        /**
         * Vlozi name a pws do databaze
         * @param name
         * @param psw
         */
        public void insertUser(String name, String psw) {       
            String sql = "INSERT INTO people (name,psw) VALUES ('" + name + "','" + psw + "')"; //zakladni sql prikaz
            
            try {
                Connection conn = DriverManager.getConnection(DBurl,DBuserName,DBpsw); //pripojeni k DB
                
                java.sql.PreparedStatement pstmt = conn.prepareStatement(sql); //vygeneruje hotovy prikaz pro databazi
                int cislo = pstmt.executeUpdate();//tady se executne sql //zbytecna promena, jen aby IDE nekricelo
                
                conn.close();
            }
            catch (Exception e) {System.err.println(e.getMessage());}//vytiskne error, jestli je
        }
//===============================================================================================================        
        
        /**
         * Vrati hodnotu ze sloupce id, kde name = name
         * @param name
         * @return id
         * 1
         */
        public String nameToId(String name) {
            String sql = "SELECT id FROM people WHERE name = '" + name + "'"; //zakladni sql prikaz
            String id = "";//nastavi id na prazdnou hodnotu
            try {
                Connection conn = DriverManager.getConnection(DBurl,DBuserName,DBpsw);
                Statement stmt = conn.createStatement();
                
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {id = rs.getString("id");}
                
                conn.close();
            } 
            catch (Exception e) {System.err.println(e.getMessage());}//vytiskne error, jestli je
            
        return (id);//vrati posledni vysledek id    
        }        
//===============================================================================================================   

        /**
         * Vrati hodnotu ze sloupce name, kde id = id
         * @param id
         * @return name
         * 2
         */
        public String idToName(String id) {
            String sql = "SELECT name FROM people WHERE id = '" + id + "'"; //zakladni sql prikaz
            String name = "";//nastavi name na prazdnou hodnotu
            try {
                Connection conn = DriverManager.getConnection(DBurl,DBuserName,DBpsw);
                Statement stmt = conn.createStatement();
                
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {name = rs.getString("name");}
                
                conn.close();
            } 
            catch (Exception e) {System.err.println(e.getMessage());}//vytiskne error, jestli je
            
        return (name);//vrati posledni vysledek name    
        } 
//===============================================================================================================   

        /**
         * Vrati hodnotu ze sloupce name, kde psw = psw
         * @param psw
         * @return name
         * 3
         */
        public String pswToName(String psw) {
            String sql = "SELECT name FROM people WHERE psw = '" + psw + "'"; //zakladni sql prikaz
            String name = "";//nastavi name na prazdnou hodnotu
            try {
                Connection conn = DriverManager.getConnection(DBurl,DBuserName,DBpsw);
                Statement stmt = conn.createStatement();
                
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {name = rs.getString("name");}
                
                conn.close();
            } 
            catch (Exception e) {System.err.println(e.getMessage());}//vytiskne error, jestli je
            
        return (name);//vrati posledni vysledek name    
        }         
//===============================================================================================================   

        /**
         * Vrati hodnotu ze sloupce id, kde psw = psw
         * @param psw
         * @return id
         * 4
         */
        public String pswToId(String psw) {
            String sql = "SELECT id FROM people WHERE psw = '" + psw + "'"; //zakladni sql prikaz
            String id = "";//nastavi id na prazdnou hodnotu
            try {
                Connection conn = DriverManager.getConnection(DBurl,DBuserName,DBpsw);
                Statement stmt = conn.createStatement();
                
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {id = rs.getString("id");}
                
                conn.close();
            } 
            catch (Exception e) {System.err.println(e.getMessage());}//vytiskne error, jestli je
            
        return (id);//vrati posledni vysledek id    
        }        
//===============================================================================================================           
        
        /**
         * Vrati hodnotu ze sloupce psw, kde id = id
         * @param id
         * @return psw
         * 5
         */
        public String idToPsw(String id) {
            String sql = "SELECT psw FROM people WHERE id = '" + id + "'"; //zakladni sql prikaz
            String psw = "";//nastavi psw na prazdnou hodnotu
            try {
                Connection conn = DriverManager.getConnection(DBurl,DBuserName,DBpsw);
                Statement stmt = conn.createStatement();
                
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {psw = rs.getString("psw");}
                
                conn.close();
            } 
            catch (Exception e) {System.err.println(e.getMessage());}//vytiskne error, jestli je
            
        return (psw);//vrati posledni vysledek psw    
        }        
//===============================================================================================================   
        
        /**
         * Vrati hodnotu ze sloupce psw, kde name = name
         * @param name
         * @return psw
         * 6
         */
        public String nameToPsw(String name) {
            String sql = "SELECT psw FROM people WHERE name = '" + name + "'"; //zakladni sql prikaz
            String psw = "";//nastavi psw na prazdnou hodnotu
            try {
                Connection conn = DriverManager.getConnection(DBurl,DBuserName,DBpsw);
                Statement stmt = conn.createStatement();
                
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {psw = rs.getString("psw");}
                
                conn.close();
            } 
            catch (Exception e) {System.err.println(e.getMessage());}//vytiskne error, jestli je
            
        return (psw);//vrati posledni vysledek psw    
        }        
 //===============================================================================================================              

        /**
         * 
         * @param name
         * @return doesUserExist? (TRUE/FALSE)
         */
        public boolean doesUserExist(String name) {
            String sql = "SELECT id FROM people WHERE name = '" + name + "'"; //zakladni sql prikaz
            String id = "";//nastavi id na prazdnou hodnotu
            boolean exists = false;
            try {
                Connection conn = DriverManager.getConnection(DBurl,DBuserName,DBpsw);
                Statement stmt = conn.createStatement();
                
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {id = rs.getString("id");}
                
                conn.close();
            } 
            catch (Exception e) {System.err.println(e.getMessage());}//vytiskne error, jestli je
            
            exists = (!(id.equals("")));
        return (exists);//vrati posledni vysledek psw    
        }
//===============================================================================================================   

        
}



