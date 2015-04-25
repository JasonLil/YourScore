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

    XMLMidiInformation(){
        this.partInformation = new ArrayList<MidiXMLData>();
    }

    public void parseXMLFile(String filename){
        try {
            JAXBContext jc = JAXBContext.newInstance(ObjectFactory.class);
            SAXParserFactory spf = SAXParserFactory.newInstance();
            spf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, false);
            XMLReader xmlReader = spf.newSAXParser().getXMLReader();
            InputSource inputSource = new InputSource(new FileReader(filename));
            SAXSource source = new SAXSource(xmlReader, inputSource);

            Unmarshaller unmarshaller = jc.createUnmarshaller();
            ScorePartwise XMLPartwise = (ScorePartwise) unmarshaller.unmarshal(source);
            int part_num =0;

            for (ScorePartwise.Part part : XMLPartwise.getPart()) {
                part_num++;

                for (ScorePartwise.Part.Measure measure : part.getMeasure()) {

                    for (Object o : measure.getNoteOrBackupOrForward()) {
                        if(o.getClass().equals(Attributes.class)){
                            Attributes attributes = (Attributes)o;
                            System.out.println("Part Num: "+part_num);
                            System.out.println(attributes.getKey().size());
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
}
