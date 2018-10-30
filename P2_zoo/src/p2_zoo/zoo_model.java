

//add package here
package p2_zoo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tomng
 */
public class zoo_model {
    public static void main(String args[]) throws SQLException {
        zoo_model model = new zoo_model();
        model.getConnection();
        //model.insertAnimal("Mike","Male","Move","2018-10-12 10:03:34","Gorilla","Harley_Field"); //works
        //model.delete("main_tb",2); //works
        //"Update "+Table+" SET "+col+" = "+value+" WHERE "+rowID+" = "+valueID+"";
        //model.update("main_tb", "Sex", "m8", "main_ID", 21); //works
        //model.read_Last_Feeding("main_tb"); //works
    }
    
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
    }
    
    
    public void deleteAnimal(Integer aId){
        
        try {
           rs = st.executeQuery("DELETE FROM main_tb WHERE main_ID="+aId+";");
       } catch (Exception e) {
           e.printStackTrace();
       }
    } 

    
    public void insertAnimal(String aName, String sex, String next_activity, String last_feeding, String type, String location ) {
        String sql = "INSERT INTO main_tb(name,sex,Next_Activity,Last_Feeding,Food_tb_type,IsFull_Location) VALUES(?,?,?,?,?,?)";
 
        try (Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1,aName);
            pstmt.setString(2,sex);
            pstmt.setString(3,next_activity);
            pstmt.setString(4,last_feeding);
            pstmt.setString(5,type);
            pstmt.setString(6,location);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

   
    // return ArrayList of 5 latest Last_Feeding
public List<List<String>> read_Last_Feeding(String main_tb) throws SQLException{ 
        String query="SELECT * FROM "+ main_tb+ " ORDER by Last_Feeding DESC LIMIT 5"; 
        
        List<List<String>> output = new ArrayList<>(); // list of list, one per row
        
        
        rs = st.executeQuery(query);
        int numCols = 7;
        while(rs.next()){
            List<String> row = new ArrayList<>(numCols);
        int i = 1;
            while(i<= numCols){
             row.add(rs.getString(i++));   
            }
          output.add(row); 
        }
        
        System.out.println(output);
        return output;
    }
    
    
    

    
//     private Connection getConnection() {
//                                                       //user     password
//        String url = "jdbc:mysql://localhost/zoo_db" + ",root" + ",root";
//        Connection conn = null;
//        try {
//            conn = DriverManager.getConnection(url);
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//        return conn;
//    }
     
     
     public Connection getConnection(){
           // connect to databese and set up Statement
            Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zoo_db?autoReconnect=true&useSSL=false","root","root");
            st = conn.createStatement();

        }catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            //conn.close();
            System.exit(0);
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
    
    
    //INSERT INTO `zoo_db`.`main_tb` (`Name`, `Sex`, `Next_Activity`, `Last_Feeding`, `Food_tb_Type`, `IsFull_Location`) VALUES ('Jenny', 'Female', 'Move', '2018-10-14 02:33:34', 'Kangraroo', 'Jump_Around');

    public int insert(String Table, ArrayList input) throws SQLException{
        String query="insert into "+Table+" ";
        query+= "values (";
        query+="'"+input.get(0)+"'";
        for(int i=1; i<input.size() ;i++){
            query+=", '"+input.get(i)+"'";
        }
        query+= " )";
        st.executeUpdate(query);
        
        return 0;
    }
    
    public int delete(String Table, int input) throws SQLException{
        String query="DELETE FROM " + Table + " WHERE main_ID=\""+ input +"\";";
        st.executeUpdate(query);
        return 0;
    }
    
    public int update(String Table, String col, String value, String rowID, int valueID) throws SQLException{
        String query="Update "+Table+" SET "+col+" = \'"+value+"\' WHERE "+rowID+" = "+valueID+"";
        st.executeUpdate(query);
        int out =0;
        return out;
    }
    
       
    
    

       
       
    
}
