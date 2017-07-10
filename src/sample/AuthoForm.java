package sample;


import java.awt.*;
import java.sql.*;

public class AuthoForm  {

    private static final String url="jdbc:mysql://VH254.spaceweb.ru:3306/wippi2010r";
    private static final String user = "wippi2010r";
    private static final String password="Password1212";


    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;


    private void connect(){
        try {
            con= DriverManager.getConnection(url,user,password);

            stmt=con.createStatement();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean isRight(String login, String password) throws SQLException {
        connect();

        rs=stmt.executeQuery("SELECT COUNT(*) FROM users WHERE login='"+login+"' AND pass='"+password+"'");
        rs.next();
        String test=rs.getString("COUNT(*)");

        try { con.close(); } catch(SQLException se) { /*can't do anything */ }
        try { stmt.close(); } catch(SQLException se) { /*can't do anything */ }

        if(test.equals("1"))return true;
        else return false;
    }

    public String returnName(String login) throws SQLException {
        connect();

        rs=stmt.executeQuery("SELECT fname FROM users WHERE login='"+login+"'");
        rs.next();
        String test=rs.getString("fname");
        try { con.close(); } catch(SQLException se) { /*can't do anything */ }
        try { stmt.close(); } catch(SQLException se) { /*can't do anything */ }
        return test;

    }

}
