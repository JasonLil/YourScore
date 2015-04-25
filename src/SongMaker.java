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
    private static final HashMap<String,Integer> note_to_Integer;

    static {
        MidiNotes = new Integer[11][12];
        int midi_num = 0;
        for(int note=0;note<12;note++){
            for(int oct=0; oct<11;oct++){
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

        note_to_Integer = new HashMap<String, Integer>();
        note_to_Integer.put("C",0);
        note_to_Integer.put("D",2);
        note_to_Integer.put("E",4);
        note_to_Integer.put("F",5);
        note_to_Integer.put("G",7);
        note_to_Integer.put("A",9);
        note_to_Integer.put("B",11);

    }


    SongMaker(){
        try {
            this.sequence = new Sequence(Sequence.PPQ, 4);
        }catch(InvalidMidiDataException imde){
            this.sequence = null;
            System.out.println("Something went wrong.");
        }
    }


    //This method adds a part from the MusicXML. The parts are enumerated and named (such as Trombone ...)
    public void addParts(ArrayList<MidiXMLData> partInformation){
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

                if (track != null) {
                    ShortMessage on = new ShortMessage();
                    ShortMessage off = new ShortMessage();

                    if (partInfo.getOctave() == null) {
                        ticker+=partInfo.getDuration();
                    } else {
                        on.setMessage(onCodes[part - 1], MidiNotes[partInfo.getOctave()][note_to_Integer.get(partInfo.getNote())], 78);
                        track.add(new MidiEvent(on, ticker));
                        ticker += partInfo.getDuration();
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

}
