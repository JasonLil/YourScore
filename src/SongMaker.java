import javax.sound.midi.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by boyd on 4/21/15.
 */
public class SongMaker {
    private Sequence sequence;
    private static final Integer[][] MidiNotes; //MidiNotes is based off of this http://www.electronics.dit.ie/staff/tscarff/Music_technology/midi/midi_note_numbers_for_octaves.htm chart
    private static final Integer[] onCodes; //on and off codes are based off of Table 2 from this page :http://www.midi.org/techspecs/midimessages.php
    private static final Integer[] offCodes;
    private HashMap<String,Integer> note_to_Integer;

    private ArrayList<MidiXMLKey> keyInformation;
    private Integer currentKeyChange; //the keyInformation has each key change for each part and currentKeyChange is the index of keyInformation that we are on


    static {
        MidiNotes = new Integer[11][12];
        int midi_num = 0;
        for(int oct=0;oct<11;oct++){
            for(int note=0; note<12;note++){
                MidiNotes[oct][note]=midi_num;
                midi_num++;
            }
        }

        onCodes = new Integer[16];
        offCodes = new Integer[16];
        for(int num=0;num<16;num++){
            onCodes[num]=num+144;
            offCodes[num]=num+128;
        }


    }


    SongMaker(ArrayList<MidiXMLKey> keyInfo){
        this.currentKeyChange = 0;
        this.keyInformation = keyInfo;

        note_to_Integer = new HashMap<String, Integer>();
        note_to_Integer.put("C",0);
        note_to_Integer.put("D",2);
        note_to_Integer.put("E",4);
        note_to_Integer.put("F",5);
        note_to_Integer.put("G",7);
        note_to_Integer.put("A",9);
        note_to_Integer.put("B",11);

        try {
            this.sequence = new Sequence(Sequence.PPQ, 96);

        }catch(InvalidMidiDataException imde){
            this.sequence = null;
            System.out.println("Something went wrong.");
        }
    }


    //This method adds a part from the MusicXML. The parts are enumerated and named (such as Trombone ...)
    public void addParts(ArrayList<MidiXMLData> partInformation, Integer beats_per_minute){
        Track track=null;
        //This keeps track of if the partInfo.getPart is different
        Integer part = -1;
        //For each new part the ticker should be set back to 1
        Integer ticker = 1;
        try {
            for (MidiXMLData partInfo : partInformation) {
                boolean newPart = false;
                if (part != partInfo.getPart()) {
                    part = partInfo.getPart();
                    ticker = 1;
                    newPart = true;
                }
                if (this.sequence != null && newPart) {
                    track = this.sequence.createTrack();
                }
                this.createNoteToInteger(partInfo.getPart(),partInfo.getMeasure());
                //Looked at various online examples including this one:http://www.coderanch.com/t/587562/java/java/Midi-Head-Java
                if (track != null) {
                    ShortMessage on = new ShortMessage();
                    ShortMessage off = new ShortMessage();

                    if (partInfo.getOctave() == null) {
                        //I am going off of http://stackoverflow.com/questions/2038313/midi-ticks-to-actual-playback-seconds-midi-music this
                        //stackoverflow post for seconds per tick, but also based on sound added the *2
                        ticker+=partInfo.getDuration()*(60000/(beats_per_minute*96)*2);
                    } else {
                        on.setMessage(onCodes[part - 1], MidiNotes[partInfo.getOctave()][note_to_Integer.get(partInfo.getNote())], 78);
                        track.add(new MidiEvent(on, ticker));
                        ticker += partInfo.getDuration()*(60000/(beats_per_minute*96)*2);
                        off.setMessage(onCodes[part - 1], MidiNotes[partInfo.getOctave()][note_to_Integer.get(partInfo.getNote())], 78);
                        track.add(new MidiEvent(off, ticker));
                    }
                }

            }
        }catch(InvalidMidiDataException imde){
            System.out.println("There was something wrong with the data.");
        }
    }

    public void startSong(){
        try {
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();
            sequencer.setSequence(this.sequence);
            sequencer.start();

        }catch(MidiUnavailableException mue){
            System.out.println("You don't have midi available on your system.");
        }catch(InvalidMidiDataException imde){
            System.out.println("There is something wrong with the data.");
        }
    }


    public void createNoteToInteger(Integer part, Integer measure){
        if(this.currentKeyChange<this.keyInformation.size()) {
            if (this.keyInformation.get(this.currentKeyChange).getPart() < part) {
                this.currentKeyChange++;//this key change comes from changing parts
            }
            if (this.keyInformation.get(this.currentKeyChange).getMeasure() == measure) {
                if (this.keyInformation.get(this.currentKeyChange).getKey() == 1) {
                    this.createFSharp();
                } else if (this.keyInformation.get(this.currentKeyChange).getKey() == 2) {
                    this.createFSharp();
                    this.createCSharp();
                } else if (this.keyInformation.get(this.currentKeyChange).getKey() == 3) {
                    this.createFSharp();
                    this.createCSharp();
                    this.createGSharp();
                } else if (this.keyInformation.get(this.currentKeyChange).getKey() == 4) {
                    this.createFSharp();
                    this.createCSharp();
                    this.createGSharp();
                    this.createDSharp();
                } else if (this.keyInformation.get(this.currentKeyChange).getKey() == 5) {
                    this.createFSharp();
                    this.createCSharp();
                    this.createGSharp();
                    this.createDSharp();
                    this.createASharp();
                } else if (this.keyInformation.get(this.currentKeyChange).getKey() == 6) {
                    this.createFSharp();
                    this.createCSharp();
                    this.createGSharp();
                    this.createDSharp();
                    this.createASharp();
                    this.createESharp();
                } else if (this.keyInformation.get(this.currentKeyChange).getKey() == -1) {
                    this.createBFlat();
                } else if (this.keyInformation.get(this.currentKeyChange).getKey() == -2) {
                    this.createBFlat();
                    this.createEFlat();
                } else if (this.keyInformation.get(this.currentKeyChange).getKey() == -3) {
                    this.createBFlat();
                    this.createEFlat();
                    this.createAFlat();
                } else if (this.keyInformation.get(this.currentKeyChange).getKey() == -4) {
                    this.createBFlat();
                    this.createEFlat();
                    this.createAFlat();
                    this.createFFlat();
                } else if (this.keyInformation.get(this.currentKeyChange).getKey() == -5) {
                    this.createBFlat();
                    this.createEFlat();
                    this.createAFlat();
                    this.createFFlat();
                    this.createGFlat();
                } else if (this.keyInformation.get(this.currentKeyChange).getKey() == -6) {
                    this.createBFlat();
                    this.createEFlat();
                    this.createAFlat();
                    this.createFFlat();
                    this.createGFlat();
                    this.createCFlat();
                }
                this.currentKeyChange++;//This is an actual key change
            }
        }
    }

    public void createCFlat(){
        this.note_to_Integer.remove("C");
        this.note_to_Integer.put("C",11);
    }
    public void createGFlat(){
        this.note_to_Integer.remove("G");
        this.note_to_Integer.put("G",6);
    }
    public void createFFlat(){
        this.note_to_Integer.remove("F");
        this.note_to_Integer.put("F",4);
    }

    public void createAFlat(){
        this.note_to_Integer.remove("A");
        this.note_to_Integer.put("A",8);
    }

    public void createBFlat(){
        this.note_to_Integer.remove("B");
        this.note_to_Integer.put("B",10);
    }

    public void createEFlat(){
        this.note_to_Integer.remove("E");
        this.note_to_Integer.put("E",3);
    }


    public void createFSharp(){
        this.note_to_Integer.remove("F");
        this.note_to_Integer.put("F",6);
    }

    public void createCSharp(){
        this.note_to_Integer.remove("C");
        this.note_to_Integer.put("C",1);
    }

    public void createGSharp(){
        this.note_to_Integer.remove("G");
        this.note_to_Integer.put("G",8);
    }

    public void createDSharp(){
        this.note_to_Integer.remove("D");
        this.note_to_Integer.put("D",3);
    }

    public void createASharp(){
        this.note_to_Integer.remove("A");
        this.note_to_Integer.put("A",10);
    }

    public void createESharp(){
        this.note_to_Integer.remove("E");
        this.note_to_Integer.put("E",5);
    }
}
