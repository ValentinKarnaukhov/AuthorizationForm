package sample;


import java.sql.*;

public class RegForm {

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

    public boolean isCorrect(String login, String email){
        String test="0";
        connect();

        try {
            rs=stmt.executeQuery("SELECT COUNT(*) FROM users WHERE login='"+login+"' OR email='"+email+"'");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            rs.next();
            test=rs.getString("COUNT(*)");
            System.out.println(test);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try { con.close(); } catch(SQLException se) { /*can't do anything */ }
        try { stmt.close(); } catch(SQLException se) { /*can't do anything */ }
        if(test.equals("1"))return false;
        else return true;
    }

    public void addUser(String email,String login, String password, String fname, String lname){
        connect();

        try {
            stmt.executeUpdate("INSERT INTO `users` (`login`, `pass`, `fname`, `sname`, `email`) VALUES ( '"+login+"', '"+password+"', '"+fname+"', '"+lname+"', '"+email+"')");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
