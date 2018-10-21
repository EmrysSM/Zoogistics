/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2_zoo;
import java.sql.*;
import java.util.logging.*;
import static javax.swing.text.StyleConstants.Size;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Tomng
 */
public class zoo_model implements Serializable {

    /**
     * @param args the command line arguments
     */
    
    String query = "SELECT * FROM  `main_tb` ";
       Statement st;
       ResultSet rs;
    
    public class Animal {
    
    private int id;
    private String Name;
    private String Type;
    private String Sex;
    private String Location;
    private String Last_Feeding;
    private String Next_Activity;
    
    
    public Animal(int ID, String name, String type, String sex, String location, String last_feeding, String next_activity)
    {
        this.id = ID;
        this.Name = name;
        this.Type = type;
        this.Sex = sex;
        this.Location = location;
        this.Last_Feeding = last_feeding;
        this.Next_Activity = next_activity;
    }
    
    public int getId()
    {
        return id;
    }
     public void setId(int id) {
        this.id = id;
    }
    
    public String getName()
    {
        return Name;
    }
    public void setName(String name) {
        this.Name = name;
    }
    
    public String getType()
    {
        return Type;
    }
    public void setType(String type) {
        this.Type = type;
    }
    
    public String getSex()
    {
        return Sex;
    }
    public void setSex(String sex) {
        this.Sex = sex;
    }
    
    public String getLocation()
    {
        return Location;
    }
    public void setLocation(String location) {
        this.Location = location;
    }
    
    public String getLast_Feeding()
    {
        return Last_Feeding;
    }
    public void setLast_Feeding(String last_feeding) {
        this.Last_Feeding = last_feeding;
    }
    
    public String getNext_Activity()
    {
        return Next_Activity;
    }
    public void setNext_Activity(String next_activity) {
        this.Next_Activity = next_activity;
    }
    
    public void deleteAnimal(int aId){
        
        try {
           rs = st.executeQuery("DELETE FROM main_tb WHERE id="+aId+";");
       } catch (Exception e) {
           e.printStackTrace();
       }
    } 
//    public void addAnimal(String aName, String type, String sex, String location, String last_feeding, String next_activity ){
//        
//        try {
//           rs = st.executeQuery("DELETE FROM main_tb WHERE id=;");
//       } catch (Exception e) {
//           e.printStackTrace();
//       }    
//     
//    }
    
    
    public void insertAnimal(String aName, String type, String sex, String location, String last_feeding, String next_activity ) {
        String sql = "INSERT INTO main_tb(name,type,sex,location,laste_feeding,next_activity) VALUES(?,?,?,?,?,?)";
 
        try (Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1,aName);
            pstmt.setString(2,type);
            pstmt.setString(3,sex);
            pstmt.setString(4,location);
            pstmt.setString(5,last_feeding);
            pstmt.setString(6,next_activity);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
}

    
    
    
// public Connection getConnection() // connect to database
//   {
//       Connection con;
//       try {
//           con = DriverManager.getConnection("jdbc:mysql://localhost/test_db", "root","");
//           return con;
//       } catch (Exception e) {
//           e.printStackTrace();
//           return null;
//       }
//       
//   }   
    
     private Connection getConnection() {
        // SQLite connection string
        String url = "jdbc:mysql://localhost/test_db" + ",root";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    
    
    public ArrayList<Animal> getAnimalList()
   {
       ArrayList<Animal> AnimalsList = new ArrayList<Animal>();
       Connection connection = getConnection();
       
       
       
       try {
           st = connection.createStatement();
           rs = st.executeQuery(query);
           Animal animal;
           while(rs.next())
           {
               animal = new Animal(rs.getInt("id"),
                       rs.getString("type"),
                       rs.getString("name"),
                       rs.getString("sex"),
                       rs.getString("location"),
                       rs.getString("last_feeding"),
                       rs.getString("next_activity"));
               AnimalsList.add(animal);
           }
       } catch (Exception e) {
           e.printStackTrace();
       }
       return AnimalsList;
   }
    
    
    
       
    
    
//       public static void main(String[] args) throws SQLException {
//        Connection myConn = null;
//        Statement myStmt = null;
//        ResultSet myRs = null;
//
//        String user = "root";
//        String pass = "root";
//
//        try {
//            // 1. Get a connection to database
//            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zoo_db", user, pass);
//
//            // 2. Create a statement
//            myStmt = myConn.createStatement();
//
//            // 3. Execute SQL query
//            myRs = myStmt.executeQuery("select * from main_tb");
//
//            // 4. Process the result set
//            while (myRs.next()) {
//                System.out.println(myRs.getString("id") + ", " + myRs.getString("name") 
//                      + ", " + myRs.getString("location")+ ", " + myRs.getString("sex")
//                      + ", " + myRs.getString("last_feeding")
//                                                );
//            //Method: latestFeed()    
//                
//                
//            
//            
//            }
//
//        } catch (Exception exc) {
//            exc.printStackTrace();
//        } finally {
//            if (myRs != null) {
//                myRs.close();
//            }
//
//            if (myStmt != null) {
//                myStmt.close();
//            }
//
//            if (myConn != null) {
//                myConn.close();
//            }
//        }
//    
//    
//    }
       
       
}