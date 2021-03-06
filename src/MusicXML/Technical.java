package MusicXML;//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.04.20 at 03:34:39 PM CDT 
//


import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlType;


/**
 * Technical indications give performance information for individual instruments.
 * 
 * <p>Java class for technical complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="technical">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice maxOccurs="unbounded" minOccurs="0">
 *         &lt;element name="up-bow" type="{}empty-placement"/>
 *         &lt;element name="down-bow" type="{}empty-placement"/>
 *         &lt;element name="harmonic" type="{}harmonic"/>
 *         &lt;element name="open-string" type="{}empty-placement"/>
 *         &lt;element name="thumb-position" type="{}empty-placement"/>
 *         &lt;element name="fingering" type="{}fingering"/>
 *         &lt;element name="pluck" type="{}placement-text"/>
 *         &lt;element name="double-tongue" type="{}empty-placement"/>
 *         &lt;element name="triple-tongue" type="{}empty-placement"/>
 *         &lt;element name="stopped" type="{}empty-placement"/>
 *         &lt;element name="snap-pizzicato" type="{}empty-placement"/>
 *         &lt;element name="fret" type="{}fret"/>
 *         &lt;element name="strings" type="{}strings"/>
 *         &lt;element name="hammer-on" type="{}hammer-on-pull-off"/>
 *         &lt;element name="pull-off" type="{}hammer-on-pull-off"/>
 *         &lt;element name="bend" type="{}bend"/>
 *         &lt;element name="tap" type="{}placement-text"/>
 *         &lt;element name="heel" type="{}heel-toe"/>
 *         &lt;element name="toe" type="{}heel-toe"/>
 *         &lt;element name="fingernails" type="{}empty-placement"/>
 *         &lt;element name="hole" type="{}hole"/>
 *         &lt;element name="arrow" type="{}arrow"/>
 *         &lt;element name="handbell" type="{}handbell"/>
 *         &lt;element name="other-technical" type="{}placement-text"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "technical", propOrder = {
    "upBowOrDownBowOrHarmonic"
})
public class Technical {

    @XmlElementRefs({
        @XmlElementRef(name = "double-tongue", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "heel", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "other-technical", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "down-bow", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "triple-tongue", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "stopped", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "fret", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "hole", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "pluck", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "thumb-position", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "strings", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "pull-off", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "handbell", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "harmonic", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "open-string", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "tap", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "up-bow", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "fingernails", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "snap-pizzicato", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "hammer-on", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "toe", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "arrow", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "fingering", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "bend", type = JAXBElement.class, required = false)
    })
    protected List<JAXBElement<?>> upBowOrDownBowOrHarmonic;

    /**
     * Gets the value of the upBowOrDownBowOrHarmonic property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the upBowOrDownBowOrHarmonic property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUpBowOrDownBowOrHarmonic().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link javax.xml.bind.JAXBElement }{@code <}{@link MusicXML.EmptyPlacement }{@code >}
     * {@link javax.xml.bind.JAXBElement }{@code <}{@link MusicXML.HeelToe }{@code >}
     * {@link javax.xml.bind.JAXBElement }{@code <}{@link PlacementText }{@code >}
     * {@link javax.xml.bind.JAXBElement }{@code <}{@link MusicXML.EmptyPlacement }{@code >}
     * {@link javax.xml.bind.JAXBElement }{@code <}{@link MusicXML.EmptyPlacement }{@code >}
     * {@link javax.xml.bind.JAXBElement }{@code <}{@link MusicXML.EmptyPlacement }{@code >}
     * {@link javax.xml.bind.JAXBElement }{@code <}{@link MusicXML.Fret }{@code >}
     * {@link javax.xml.bind.JAXBElement }{@code <}{@link MusicXML.Hole }{@code >}
     * {@link javax.xml.bind.JAXBElement }{@code <}{@link PlacementText }{@code >}
     * {@link javax.xml.bind.JAXBElement }{@code <}{@link MusicXML.EmptyPlacement }{@code >}
     * {@link javax.xml.bind.JAXBElement }{@code <}{@link Strings }{@code >}
     * {@link javax.xml.bind.JAXBElement }{@code <}{@link MusicXML.HammerOnPullOff }{@code >}
     * {@link javax.xml.bind.JAXBElement }{@code <}{@link MusicXML.Handbell }{@code >}
     * {@link javax.xml.bind.JAXBElement }{@code <}{@link MusicXML.Harmonic }{@code >}
     * {@link javax.xml.bind.JAXBElement }{@code <}{@link MusicXML.EmptyPlacement }{@code >}
     * {@link javax.xml.bind.JAXBElement }{@code <}{@link PlacementText }{@code >}
     * {@link javax.xml.bind.JAXBElement }{@code <}{@link MusicXML.EmptyPlacement }{@code >}
     * {@link javax.xml.bind.JAXBElement }{@code <}{@link MusicXML.EmptyPlacement }{@code >}
     * {@link javax.xml.bind.JAXBElement }{@code <}{@link MusicXML.EmptyPlacement }{@code >}
     * {@link javax.xml.bind.JAXBElement }{@code <}{@link MusicXML.HammerOnPullOff }{@code >}
     * {@link javax.xml.bind.JAXBElement }{@code <}{@link MusicXML.HeelToe }{@code >}
     * {@link javax.xml.bind.JAXBElement }{@code <}{@link MusicXML.Arrow }{@code >}
     * {@link javax.xml.bind.JAXBElement }{@code <}{@link MusicXML.Fingering }{@code >}
     * {@link javax.xml.bind.JAXBElement }{@code <}{@link MusicXML.Bend }{@code >}
     * 
     * 
     */
    public List<JAXBElement<?>> getUpBowOrDownBowOrHarmonic() {
        if (upBowOrDownBowOrHarmonic == null) {
            upBowOrDownBowOrHarmonic = new ArrayList<JAXBElement<?>>();
        }
        return this.upBowOrDownBowOrHarmonic;
    }

}
