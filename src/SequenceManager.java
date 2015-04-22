import javax.sound.midi.*;

/**
 * Created by boyd on 4/21/15.
 */
public class SequenceManager {
    public static void main(String[] args){
        try {
            Sequence sequence = new Sequence(Sequence.PPQ, 4);
            Track track = sequence.createTrack();
            ShortMessage on = new ShortMessage();
            on.setMessage(144,60,78);
            track.add(new MidiEvent(on,1));
            ShortMessage off = new ShortMessage();
            off.setMessage(128,60,78);
            track.add(new MidiEvent(off,20));


            Sequencer seqR = MidiSystem.getSequencer();
            seqR.open();
            seqR.setSequence(sequence);
            seqR.setTickPosition(0);
            seqR.start();

        }catch(InvalidMidiDataException imde){
            System.out.println(imde.toString());
        }catch(MidiUnavailableException mue){
            System.out.println(mue.toString());
        }
    }
}
