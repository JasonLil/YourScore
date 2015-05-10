import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

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

            statement.executeUpdate("CREATE TABLE parts (part_id Integer (START WITH 1, INCREMENT BY 1), part INTEGER, key INTEGER , song_name CHAR(20))");
            statement.executeUpdate("CREATE TABLE measures (measure_num INTEGER, octave INTEGER, note CHAR(1), duration INTEGER, part_id INTEGER, FOREIGN KEY part_id REFERENCES parts(part_id))");
            statement.executeUpdate("CREATE TABLE keys (part_id INTEGER ,part INTEGER ,key_int INTEGER, measure INTEGER (FOREIGN KEY part_id REFERENCES parts(part_id)))");

        }catch(SQLException se){
            System.out.println("You have already made the database.");
        }
    }

    public void populateFromFile(ArrayList<MidiXMLData> musicData, ArrayList<MidiXMLKey> keyData, String songName){
        try{
            conn = DriverManager.getConnection(PROTOCOL + DB_NAME + ";create=true", USER, PASS);

            PreparedStatement ps = conn.prepareStatement("INSERT INTO parts (part, name) VALUES (?,?)");



            PreparedStatement ps_measures = conn.prepareStatement("INSERT INTO measures (measure_num,octave,note, duration,)");
            PreparedStatement ps_keys = conn.prepareStatement("INSERT INTO keys (part_id, ,part, key_int, measure) VALUES (?,?,?,?)");

            Integer part_id;
            ResultSet resultSet = statement.executeQuery("Select MAX(part_id) as max_pid from parts");
            if(!resultSet.next()){
                part_id = 0;
            }else{
                part_id = resultSet.getInt("max_pid");
            }
            Integer part_for_first = part_id;
            Integer part = -1;
            for(MidiXMLData midiXMLData : musicData){

                if(part != midiXMLData.getPart()){
                    ps.setString(2,songName);
                    ps.setInt(1, midiXMLData.getPart());
                    ps.executeUpdate();
                    part = midiXMLData.getPart();
                }

            }




        }catch(SQLException se){
            JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"There was a database problem.");
        }
    }






}
