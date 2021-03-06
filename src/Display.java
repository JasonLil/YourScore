import org.apache.batik.dom.svg.SVGDOMImplementation;
import org.apache.batik.svggen.SVGGraphics2D;
import org.apache.batik.swing.JSVGCanvas;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Element;
import org.w3c.dom.svg.SVGDocument;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;


/**
 * Created by boyd on 5/4/15.
 */
public class Display extends JFrame{
    private JPanel rootPanel;
    private JTabbedPane tabbedPane;
    private JPanel midiPanel;
    private JButton playButton;
    private JTextField fileName;
    private JTable partsTable;
    private JButton addButton;
    private JSlider tempoSlider;
    private JSVGCanvas canvas;
    private DOMImplementation dom;
    private SVGGraphics2D generator;
    private SVGDocument document;
    private String svgNS;
    private ArrayList<MidiXMLData> partInformation;
    private ArrayList<MidiXMLKey> keyInformation;
    private static MusicDB musicDB;
    private static MusicDataTable musicDataTable;
    private static SongMaker songMaker;


    Display(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JScrollPane scrollPane = new JScrollPane(this.rootPanel);
        this.tabbedPane = new JTabbedPane();
        setContentPane(this.tabbedPane);
        setVisible(true);

        this.partsTable.setGridColor(Color.BLACK);
        this.musicDB = new MusicDB();
        this.musicDB.setup();
        musicDataTable = new MusicDataTable(musicDB.getResultSet());
        this.partsTable.setModel(musicDataTable);

        this.tabbedPane.add(this.midiPanel,"Play MIDI");

        this.tabbedPane.add(scrollPane,"Visual Score");

        this.rootPanel.setLayout(new BorderLayout());


        this.canvas = new JSVGCanvas();
        this.canvas.setMySize(new Dimension(1000,1000));

        songMaker = new SongMaker();


        //This part is taken from Java Drawing with Apache Batik
        this.dom = SVGDOMImplementation.getDOMImplementation();
        this.svgNS = SVGDOMImplementation.SVG_NAMESPACE_URI;
        this.document = (SVGDocument)this.dom.createDocument(svgNS,"svg", null);
        this.generator = new SVGGraphics2D(this.document);
        this.createStaves();
        this.rootPanel.add("Center",this.canvas);
        pack();

        this.playButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int[] rows = partsTable.getSelectedRows();
                ArrayList<MidiXMLKey> keyInfo = new ArrayList<MidiXMLKey>();
                ArrayList<MidiXMLData> musicInfo = new ArrayList<MidiXMLData>();
                keyInfo.addAll(musicDB.getKeyInfo(rows));
                musicInfo.addAll(musicDB.getMeasureInfo(rows));
                for(MidiXMLData k : musicInfo){
                    System.out.println(k.getPart());
                    System.out.println(k.getNote());
                    System.out.println(k.getOctave());
                }


                if(playButton.getText().equals("Play")) {
                    playButton.setText("Stop");

                    songMaker.setKeyInformation(keyInfo);

                    songMaker.addParts(musicInfo,tempoSlider.getValue());

                    songMaker.startSong();
                }else{
                    playButton.setText("Play");
                    songMaker.stopSong();
                }
            }
        });

        this.addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                XMLMidiInformation xmlparser = new XMLMidiInformation();
                xmlparser.parseXMLFile(fileName.getText());
                musicDB.populateFromFile(xmlparser.getPartInformation(),xmlparser.getKeyInformation(),xmlparser.getSongName());
                musicDataTable.fireTableDataChanged();
            }
        });




    }





    public void createStaves(){
        Element root = this.document.getRootElement();
        root.setAttributeNS(null,"width","1000");
        root.setAttributeNS(null, "height", "1000");

        Integer breakBetween = 10;
        for(int i = 0;i<4;i++) {

            for (int k = 0; k < 5; k++) {

                Integer y1 = k*(20) + breakBetween;
                Integer y2 = k*(20) + breakBetween;
                Integer x1 = 0;
                Integer x2 = 1000;
                Element line = this.document.createElementNS(this.svgNS, "line");

                line.setAttributeNS(null, "x1", x1.toString());
                line.setAttributeNS(null,"x2", x2.toString());
                line.setAttributeNS(null,"y1", y1.toString());
                line.setAttributeNS(null, "y2", y2.toString());
                line.setAttributeNS(null,"stroke","black");
                line.setAttributeNS(null,"stroke-width","1");

                root.appendChild(line);

            }
            breakBetween+=130;
        }
        this.generator.getRoot(root);
        this.canvas.setSVGDocument(this.document);

    }

    public void createNotes(ArrayList<MidiXMLData> inputInfo){
        Integer cx = 10;

    }


    public ArrayList<MidiXMLData> getPartInformation() {
        return partInformation;
    }

    public void setPartInformation(ArrayList<MidiXMLData> partInformation) {
        this.partInformation = partInformation;
    }

    public ArrayList<MidiXMLKey> getKeyInformation() {
        return keyInformation;
    }

    public void setKeyInformation(ArrayList<MidiXMLKey> keyInformation) {
        this.keyInformation = keyInformation;
    }
}