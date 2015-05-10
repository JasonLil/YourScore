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

            statement.executeUpdate("CREATE TABLE songs (song_id INTEGER (START WITH 1, INCREMENT BY 1), name CHAR(20),PRIMARY KEY id)");
            statement.executeUpdate("CREATE TABLE parts (part_id Integer (START WITH 1, INCREMENT BY 1), key INTEGER , song_name CHAR(20),FOREIGN KEY song_name REFERENCES songs(name))");
            statement.executeUpdate("CREATE TABLE measures (measure_id INTEGER (START WITH 1, INCREMENT BY 1), octave INTEGER, note CHAR(1), duration INTEGER, part_id INTEGER, FOREIGN KEY part_id REFERENCES parts(part_id))");

        }catch(SQLException se){
            System.out.println("You have already made the database.");
        }
    }

    public void populateFromFile(){
        try{
            conn = DriverManager.getConnection(PROTOCOL + DB_NAME + ";create=true", USER, PASS);

            PreparedStatement ps = conn.prepareStatement("INSERT INTO songs");


        }catch(SQLException se){
            JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"There was a database problem.");
        }
    }






}
