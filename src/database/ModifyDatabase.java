package database;

import ds.Student;

import java.sql.*;

public class ModifyDatabase {
    // driver links
    static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
    static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
    //  Database credentials
    static final String USER = "archisman";
    static final String PASS = "resunimda";

    private Connection conn;
    private Statement stmt;

    public ModifyDatabase() {
        try{
            // Register JDBC driver
            Class.forName(JDBC_DRIVER);
            // Open a connection
            System.out.println("Connecting to database...");
            this.conn = DriverManager.getConnection(DB_URL,USER,PASS);

        } catch(Exception se){
            se.printStackTrace();
        }
        System.out.println("Connected to database......");
    }

    public boolean add(String fName, String lName, String uName, String password) {
        System.out.println("Creating statement...");
        try {
            stmt = conn.createStatement();
            String sql = "insert into Student values (" + uName + ",'" + fName + "','" + lName + "','" + password +"')";
            System.out.println("Executing update query: " + sql);
            stmt.executeUpdate(sql);

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Student find(int uid) {
        System.out.println("Creating statement...");
        try {
            stmt = conn.createStatement();
            String sql = "select * from Student where id="+uid;
            System.out.println("Executing search query: " + sql);
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            return new Student(
                    rs.getString("firstName"),
                    rs.getString("lastName"),
                    rs.getInt("id"),
                    rs.getString("password"));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void closeConnection() {
        try{
            if(stmt!=null)
                stmt.close();
        }catch(SQLException se){
            se.printStackTrace();
        }
        try{
            if(conn!=null)
                conn.close();
        }catch(SQLException se){
            se.printStackTrace();
        }
        System.out.println("Connection to Database terminated......");
    }


}
