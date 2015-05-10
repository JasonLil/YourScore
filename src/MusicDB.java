import javax.swing.*;
import java.sql.*;

/**
 * Created by boyd on 5/9/15.
 */
public class MusicDB {
    private final String PROTOCOL = "jdbc:derby:";
    private final String DB_NAME = "movieDB";
    private final String USER = "user";
    private final String PASS = "password";

    private Statement statement = null;
    private Connection conn = null;
    private ResultSet rs = null;


    public void setup(){
        try{
            conn = DriverManager.getConnection(PROTOCOL + DB_NAME + ";create=true", USER, PASS);

            statement = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            statement.executeUpdate("CREATE TABLE measure ()")

        }catch(SQLException se){
            System.out.println("You have already made the database.");
        }
    }




}
