package SQL_HELPER;

import org.junit.Test;

import java.sql.*;


public class DB_Manager {
    public static String url = "jdbc:postgresql://localhost:5432/testdb";
    public static String user = "postgres";
    public static String passwd = "1Qwerty1";

    public DB_Manager() throws SQLException { }


    public void getPostgreData(){
        try{

            Connection connection = DriverManager.getConnection(url,user,passwd);
            PreparedStatement pst = connection.prepareStatement("SELECT * FROM client_data");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {

                System.out.print(rs.getString(2));
                System.out.print(": ");
                System.out.println(rs.getString(3));

            }

        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }

}




