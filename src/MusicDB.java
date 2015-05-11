import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

/**
 * Created by boyd on 5/9/15.
 */
public class MusicDB {
    private final String PROTOCOL = "jdbc:derby:";
    private final String DB_NAME = "yourScoreDB";
    private final String USER = "user";
    private final String PASS = "password";

    private Statement statement = null;
    private Connection conn = null;
    private ResultSet rs = null;


    public void setup(){
        try{
            conn = DriverManager.getConnection(PROTOCOL + DB_NAME + ";create=true", USER, PASS);

            statement = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            try {
                statement.executeUpdate("CREATE TABLE parts (part_id Integer NOT NULL, part INTEGER, song_name CHAR(20), PRIMARY KEY (part_id))");
                statement.executeUpdate("CREATE TABLE measures (measure_num INTEGER, octave INTEGER, note CHAR(1), duration INTEGER, part_id INTEGER, FOREIGN KEY (part_id) REFERENCES parts(part_id))");
                statement.executeUpdate("CREATE TABLE keys (part_id INTEGER ,part INTEGER ,key_int INTEGER, measure INTEGER, FOREIGN KEY (part_id) REFERENCES parts(part_id))");
            }catch(SQLException sqle){
                System.out.println(sqle.toString());
            }
        }catch(SQLException se){
            System.out.println("You have already made the database.");
        }
    }

    public void populateFromFile(ArrayList<MidiXMLData> musicData, ArrayList<MidiXMLKey> keyData, String songName){
        try{
            conn = DriverManager.getConnection(PROTOCOL + DB_NAME + ";create=true", USER, PASS);

            PreparedStatement ps = conn.prepareStatement("INSERT INTO parts (part_id,part, song_name) VALUES (?,?,?)");



            PreparedStatement ps_measures = conn.prepareStatement("INSERT INTO measures (measure_num,octave,note, duration,part_id) VALUES (?,?,?,?,?)");
            PreparedStatement ps_keys = conn.prepareStatement("INSERT INTO keys (part_id,part, key_int, measure) VALUES (?,?,?,?)");

            Integer part_id;
            ResultSet resultSet = statement.executeQuery("Select MAX(part_id) as max_pid from parts");
            if(!resultSet.next()){
                part_id = 0;
            }else{
                part_id = resultSet.getInt("max_pid");
            }
            System.out.println("Part_Id :"+part_id);
            Integer part_for_first = part_id;
            Integer part = -1;
            for(MidiXMLData midiXMLData : musicData){

                if(part != midiXMLData.getPart()){
                    part_for_first++;
                    ps.setString(3,songName);
                    ps.setInt(2, midiXMLData.getPart());
                    ps.setInt(1,part_for_first);
                    ps.executeUpdate();
                    part = midiXMLData.getPart();

                }
                if(midiXMLData.getNote()=="r") {
                    ps_measures.setInt(1, midiXMLData.getMeasure());
                    ps_measures.setInt(2, 0);
                    ps_measures.setString(3, midiXMLData.getNote());
                    ps_measures.setInt(4, midiXMLData.getDuration());
                    ps_measures.setInt(5, part_for_first);

                    ps_measures.executeUpdate();
                }else{
                    ps_measures.setInt(1, midiXMLData.getMeasure());
                    ps_measures.setInt(2, midiXMLData.getOctave());
                    ps_measures.setString(3, midiXMLData.getNote());
                    ps_measures.setInt(4, midiXMLData.getDuration());
                    ps_measures.setInt(5, part_for_first);
                    ps_measures.executeUpdate();
                }
            }
            Integer p = -1;
            for(MidiXMLKey midiXMLKey : keyData){
                if(p!=midiXMLKey.getPart()) {
                    part_id++;
                    p=midiXMLKey.getPart();
                }

                ps_keys.setInt(1,part_id);
                ps_keys.setInt(2,midiXMLKey.getPart());
                ps_keys.setInt(3, midiXMLKey.getKey());
                ps_keys.setInt(4, midiXMLKey.getMeasure());
                ps_keys.executeUpdate();

            }




        }catch(SQLException se){
            System.out.println(se.toString());
            JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"There was a database problem.");
        }
    }


    public ArrayList<MidiXMLData> getMeasureInfo(int[] rows){
        ArrayList<MidiXMLData> musicInfo = new ArrayList<MidiXMLData>();
        try{
            this.conn = DriverManager.getConnection(PROTOCOL + DB_NAME + ";create=true", USER, PASS);
            for(Integer p : rows) {
                PreparedStatement ps = this.conn.prepareStatement("SELECT m.measure_num as m, m.octave as o, m.note as n, m.duration as d, p.part as p from parts as p join measures as m on p.part_id=m.part_id where p.part_id=(?)");
                ps.setInt(1, p);
                this.rs = ps.executeQuery();
                while(this.rs.next()){
                    MidiXMLData data = new MidiXMLData();
                    data.setPart(this.rs.getInt("p"));
                    data.setDuration(this.rs.getInt("d"));
                    data.setMeasure(this.rs.getInt("m"));
                    data.setNote(this.rs.getString("n"));
                    data.setOctave(this.rs.getInt("o"));
                    musicInfo.add(data);
                }
            }


        }catch(SQLException se){
            JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"There was a database problem.");
        }
        return musicInfo;
    }

    public ArrayList<MidiXMLKey> getKeyInfo(int[] rows){
        ArrayList<MidiXMLKey> musicInfo = new ArrayList<MidiXMLKey>();
        try{
            this.conn = DriverManager.getConnection(PROTOCOL + DB_NAME + ";create=true", USER, PASS);
            for(Integer p : rows) {
                PreparedStatement ps = this.conn.prepareStatement("SELECT k.part as p, k.measure as m, k.key_int as ke from keys as k join parts as p on p.part_id=k.part_id where p.part_id=(?)");
                ps.setInt(1, p);
                this.rs = ps.executeQuery();
                while(this.rs.next()){
                    MidiXMLKey data = new MidiXMLKey();
                    data.setKey(this.rs.getInt("ke"));
                    data.setMeasure(this.rs.getInt("m"));
                    data.setPart(this.rs.getInt("p"));
                    musicInfo.add(data);
                }
            }


        }catch(SQLException se){
            JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"There was a database problem.");
        }
        return musicInfo;
    }



    public ResultSet getResultSet(){
        try {
            this.conn = DriverManager.getConnection(PROTOCOL + DB_NAME + ";create=true", USER, PASS);
            statement = this.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            this.rs = statement.executeQuery("SELECT song_name, part from parts");


        }catch(SQLException se){
            JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "There was a database problem.");
        }
        return this.rs;
    }



}
