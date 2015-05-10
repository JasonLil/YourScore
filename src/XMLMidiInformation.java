import MusicXML.*;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.sax.SAXSource;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Created by boyd on 4/21/15.
 */
public class XMLMidiInformation {
    private ArrayList<MidiXMLData> partInformation;
    private ArrayList<MidiXMLKey> keyInformation;
    private String songName;

    XMLMidiInformation(){
        this.partInformation = new ArrayList<MidiXMLData>();
        this.keyInformation = new ArrayList<MidiXMLKey>();
    }

    public void parseXMLFile(String filename){
        try {
            JAXBContext jc = JAXBContext.newInstance(ObjectFactory.class);
            SAXParserFactory spf = SAXParserFactory.newInstance();
            //The next line is giving an error now that the dependencies have changed with Batik... I'm not sure it's needed.
            /*
            spf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, false);
            */
            XMLReader xmlReader = spf.newSAXParser().getXMLReader();
            InputSource inputSource = new InputSource(new FileReader(filename));
            SAXSource source = new SAXSource(xmlReader, inputSource);

            Unmarshaller unmarshaller = jc.createUnmarshaller();
            ScorePartwise XMLPartwise = (ScorePartwise) unmarshaller.unmarshal(source);
            int part_num =0;
            this.songName = XMLPartwise.getWork().getWorkTitle();

            for (ScorePartwise.Part part : XMLPartwise.getPart()) {
                part_num++;

                for (ScorePartwise.Part.Measure measure : part.getMeasure()) {

                    for (Object o : measure.getNoteOrBackupOrForward()) {

                        if(o.getClass().equals(Attributes.class)){
                            MidiXMLKey midiXMLKey = new MidiXMLKey();
                            Attributes attributes = (Attributes)o;

                            if(attributes.getKey().size()>0) {
                                midiXMLKey.setKey(attributes.getKey().get(0).getFifths().intValue());
                                midiXMLKey.setMeasure(Integer.parseInt(measure.getNumber()));
                                midiXMLKey.setPart(part_num);
                                this.keyInformation.add(midiXMLKey);
                            }

                        }
                        if (o.getClass().equals(Note.class)) {
                            Note n = (Note) o;
                            Integer octave = null;
                            String note = null;

                            for (JAXBElement j : n.getContent()) {

                                //all the note information isn't in one j JAXBElement. Each thing like a Note, a Rest, a duration
                                //come in sequential order so that the duration of the Note follows it
                                //measure and part are accounted for already, the others are to come




                                if (j.getName().toString().equals("duration")) {
                                    MidiXMLData musicInfo = new MidiXMLData();
                                    Integer duration = Integer.parseInt(j.getValue().toString());
                                    musicInfo.setDuration(duration);
                                    musicInfo.setMeasure(Integer.parseInt(measure.getNumber()));
                                    musicInfo.setPart(part_num);
                                    musicInfo.setOctave(octave);
                                    musicInfo.setNote(note);
                                    this.partInformation.add(musicInfo);


                                }
                                if (j.getValue().getClass().equals(Pitch.class)) {
                                    Pitch p = (Pitch) j.getValue();
                                    octave = p.getOctave();
                                    note = p.getStep().value();
                                } else if (j.getValue().getClass().equals(Rest.class)) {
                                    note = "rest";
                                }


                            }
                        }
                    }
                }
            }

        }catch(ParserConfigurationException pce){
            System.out.println(pce.toString());
        }catch(JAXBException jaxbe){
            System.out.println(jaxbe.toString());
        }catch(SAXException saxe){
            System.out.println(saxe.toString());
        }catch(FileNotFoundException fnfe){
            System.out.println("Please correctly identify the filename.");
        }
    }

    public ArrayList<MidiXMLData> getPartInformation() {
        return partInformation;
    }

    public ArrayList<MidiXMLKey> getKeyInformation() {
        return keyInformation;
    }
}
