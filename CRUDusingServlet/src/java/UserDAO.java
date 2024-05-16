/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.*;
import java.sql.*;
/**
 *
 * @author Saiful
 */
public class UserDAO {
    
    public static Connection getConnection() {
        Connection conn = null;
        String dbUsername = "root";
        String dbPassword = "admin";
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/csm3023", dbUsername, dbPassword);
        } catch (Exception e) {
            System.out.println("Error connecting to the database: " + e.getMessage());
        }
        return conn;
    }
    
    public static void main(String[] args) throws SQLException {
        Connection conn = UserDAO.getConnection();
        List<User> list = new ArrayList<User>();
        PreparedStatement ps = conn.prepareStatement("select * from users");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            User e = new User();
            e.setId(rs.getInt(1));
            e.setUsername(rs.getString(2));
            e.setPassword(rs.getString(3));
            e.setRole(rs.getString(4));
            list.add(e);
        }
        System.out.print(list.get(0).getUsername()); 
        conn.close();
        
    }
    public static int save(User e) {
        int status = 0;
        try {
            Connection conn = UserDAO.getConnection();
            PreparedStatement ps = conn.prepareStatement(
                    "insert into users(username,password,roles) values (?,?,?)");
            ps.setString(1, e.getUsername());
            ps.setString(2, e.getPassword());
            ps.setString(3, e.getRole());
            
            status = ps.executeUpdate();
            
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return status;
    }
    
    public static int update(User e) {
        int status = 0;
        try {
            Connection conn = UserDAO.getConnection();
            PreparedStatement ps = conn.prepareStatement(
                    "update users set username=?,password=?,roles=? where id=?");
            ps.setString(1, e.getUsername());
            ps.setString(2, e.getPassword());
            ps.setString(3, e.getRole());
            ps.setInt(4, e.getId());
            
            status = ps.executeUpdate();
            
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return status;
    }
    
    public static int delete (int id) {
        int status = 0;
        try {
            Connection conn = UserDAO.getConnection();
            PreparedStatement ps = conn.prepareStatement("delete from users where id=?");
            ps.setInt(1, id);
            status = ps.executeUpdate();
            
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return status;
    }
    
    public static User getUserById(int id) {
        User e = new User();
        
        try {
            Connection conn = UserDAO.getConnection();
            PreparedStatement ps = conn.prepareStatement(
                    "select * from users where id=?");
            ps.setInt(1, e.getId());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                e.setId(rs.getInt(1));
                e.setUsername(rs.getString(2));
                e.setPassword(rs.getString(3));
                e.setRole(rs.getString(4));
            }
            
            conn.close();
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return e;
    }
    
    public static List<User> getAllUsers() {
        List<User> list = new ArrayList<User>();
        
        try {
            Connection conn = UserDAO.getConnection();
            PreparedStatement ps = conn.prepareStatement("select * from users");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User e = new User();
                e.setId(rs.getInt(1));
                e.setUsername(rs.getString(2));
                e.setPassword(rs.getString(3));
                e.setRole(rs.getString(4));
                list.add(e);
            }
            
            System.out.print(list.get(0).getUsername()); 
            
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
        
        return list;
    }
}
