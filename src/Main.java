

/**
 * Created by boyd on 4/20/15.
 */
public class Main {
    public static void main(String[] args){

        XMLMidiInformation midiInformation = new XMLMidiInformation();
        midiInformation.parseXMLFile("air.xml");
        /*
        for(MidiXMLData data : midiInformation.getPartInformation()){
            System.out.println("Part: " +data.getPart());
            System.out.println("Measure: "+ data.getMeasure());
            System.out.println("Octave: "+ data.getOctave());
            System.out.println("Note: "+ data.getNote());
            System.out.println("Duration: "+ data.getDuration());
        }
    */
        for(MidiXMLKey midiKey : midiInformation.getKeyInformation()){
            System.out.println(midiKey.getPart());
            System.out.println(midiKey.getMeasure());
            System.out.println(midiKey.getKey());
        }

    }
}
