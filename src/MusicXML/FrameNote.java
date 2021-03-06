package MusicXML;//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.04.20 at 03:34:39 PM CDT 
//


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * The frame-note type represents each note included in the frame. An open string will have a fret value of 0, while a muted string will not be associated with a frame-note element.
 * 
 * <p>Java class for frame-note complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="frame-note">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="strings" type="{}strings"/>
 *         &lt;element name="fret" type="{}fret"/>
 *         &lt;element name="fingering" type="{}fingering" minOccurs="0"/>
 *         &lt;element name="barre" type="{}barre" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "frame-note", propOrder = {
    "strings",
    "fret",
    "fingering",
    "barre"
})
public class FrameNote {

    @XmlElement(required = true)
    protected Strings strings;
    @XmlElement(required = true)
    protected Fret fret;
    protected Fingering fingering;
    protected Barre barre;

    /**
     * Gets the value of the strings property.
     * 
     * @return
     *     possible object is
     *     {@link Strings }
     *     
     */
    public Strings getStrings() {
        return strings;
    }

    /**
     * Sets the value of the strings property.
     * 
     * @param value
     *     allowed object is
     *     {@link Strings }
     *     
     */
    public void setStrings(Strings value) {
        this.strings = value;
    }

    /**
     * Gets the value of the fret property.
     * 
     * @return
     *     possible object is
     *     {@link Fret }
     *     
     */
    public Fret getFret() {
        return fret;
    }

    /**
     * Sets the value of the fret property.
     * 
     * @param value
     *     allowed object is
     *     {@link Fret }
     *     
     */
    public void setFret(Fret value) {
        this.fret = value;
    }

    /**
     * Gets the value of the fingering property.
     * 
     * @return
     *     possible object is
     *     {@link Fingering }
     *     
     */
    public Fingering getFingering() {
        return fingering;
    }

    /**
     * Sets the value of the fingering property.
     * 
     * @param value
     *     allowed object is
     *     {@link Fingering }
     *     
     */
    public void setFingering(Fingering value) {
        this.fingering = value;
    }

    /**
     * Gets the value of the barre property.
     * 
     * @return
     *     possible object is
     *     {@link Barre }
     *     
     */
    public Barre getBarre() {
        return barre;
    }

    /**
     * Sets the value of the barre property.
     * 
     * @param value
     *     allowed object is
     *     {@link Barre }
     *     
     */
    public void setBarre(Barre value) {
        this.barre = value;
    }

}
