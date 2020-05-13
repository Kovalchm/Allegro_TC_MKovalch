package SQL_HELPER;

import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DB_Manager {
    public static String url = "jdbc:postgresql://localhost:5432/testdb";
    public static String user = "postgres";
    public static String passwd = "1Qwerty1";


    public DB_Manager() throws SQLException { }

    public List<String> getClient_params(){
        List<String> cl_data = new ArrayList<>();
        try{
            Connection connection = DriverManager.getConnection(url,user,passwd);
            PreparedStatement pst = connection.prepareStatement("SELECT * FROM client_data");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                cl_data.add(rs.getString(2));
                cl_data.add(rs.getString(3));
                /*System.out.print(rs.getString(2));
                System.out.print(": ");
                System.out.println(rs.getString(3));*/
            }

        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return cl_data;
    }

}




