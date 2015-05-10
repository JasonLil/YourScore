/**
 * Created by boyd on 4/25/15.
 */
public class MidiXMLKey {
    private Integer part;
    private Integer key;//corresponds to the circle of fifths http://en.wikipedia.org/wiki/Circle_of_fifths where 0 is C Major, 1 is G Major
    private Integer measure;





    public Integer getPart() {
        return part;
    }

    public void setPart(Integer part) {
        this.part = part;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public Integer getMeasure() {
        return measure;
    }

    public void setMeasure(Integer measure) {
        this.measure = measure;
    }
}
