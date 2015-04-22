package MusicXML;//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.04.20 at 03:34:39 PM CDT 
//


import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * A measure-style indicates a special way to print partial to multiple measures within a part. This includes multiple rests over several measures, repeats of beats, single, or multiple measures, and use of slash notation.
 * 
 * The multiple-rest and measure-repeat symbols indicate the number of measures covered in the element content. The beat-repeat and slash elements can cover partial measures. All but the multiple-rest element use a type attribute to indicate starting and stopping the use of the style. The optional number attribute specifies the staff number from top to bottom on the system, as with clef.
 * 
 * <p>Java class for measure-style complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="measure-style">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="multiple-rest" type="{}multiple-rest"/>
 *         &lt;element name="measure-repeat" type="{}measure-repeat"/>
 *         &lt;element name="beat-repeat" type="{}beat-repeat"/>
 *         &lt;element name="slash" type="{}slash"/>
 *       &lt;/choice>
 *       &lt;attGroup ref="{}color"/>
 *       &lt;attGroup ref="{}font"/>
 *       &lt;attribute name="number" type="{}staff-number" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "measure-style", propOrder = {
    "multipleRest",
    "measureRepeat",
    "beatRepeat",
    "slash"
})
public class MeasureStyle {

    @XmlElement(name = "multiple-rest")
    protected MultipleRest multipleRest;
    @XmlElement(name = "measure-repeat")
    protected MeasureRepeat measureRepeat;
    @XmlElement(name = "beat-repeat")
    protected BeatRepeat beatRepeat;
    protected Slash slash;
    @XmlAttribute(name = "number")
    protected BigInteger number;
    @XmlAttribute(name = "color")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String color;
    @XmlAttribute(name = "font-family")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String fontFamily;
    @XmlAttribute(name = "font-style")
    protected FontStyle fontStyle;
    @XmlAttribute(name = "font-size")
    protected String fontSize;
    @XmlAttribute(name = "font-weight")
    protected FontWeight fontWeight;

    /**
     * Gets the value of the multipleRest property.
     * 
     * @return
     *     possible object is
     *     {@link MultipleRest }
     *     
     */
    public MultipleRest getMultipleRest() {
        return multipleRest;
    }

    /**
     * Sets the value of the multipleRest property.
     * 
     * @param value
     *     allowed object is
     *     {@link MultipleRest }
     *     
     */
    public void setMultipleRest(MultipleRest value) {
        this.multipleRest = value;
    }

    /**
     * Gets the value of the measureRepeat property.
     * 
     * @return
     *     possible object is
     *     {@link MeasureRepeat }
     *     
     */
    public MeasureRepeat getMeasureRepeat() {
        return measureRepeat;
    }

    /**
     * Sets the value of the measureRepeat property.
     * 
     * @param value
     *     allowed object is
     *     {@link MeasureRepeat }
     *     
     */
    public void setMeasureRepeat(MeasureRepeat value) {
        this.measureRepeat = value;
    }

    /**
     * Gets the value of the beatRepeat property.
     * 
     * @return
     *     possible object is
     *     {@link BeatRepeat }
     *     
     */
    public BeatRepeat getBeatRepeat() {
        return beatRepeat;
    }

    /**
     * Sets the value of the beatRepeat property.
     * 
     * @param value
     *     allowed object is
     *     {@link BeatRepeat }
     *     
     */
    public void setBeatRepeat(BeatRepeat value) {
        this.beatRepeat = value;
    }

    /**
     * Gets the value of the slash property.
     * 
     * @return
     *     possible object is
     *     {@link Slash }
     *     
     */
    public Slash getSlash() {
        return slash;
    }

    /**
     * Sets the value of the slash property.
     * 
     * @param value
     *     allowed object is
     *     {@link Slash }
     *     
     */
    public void setSlash(Slash value) {
        this.slash = value;
    }

    /**
     * Gets the value of the number property.
     * 
     * @return
     *     possible object is
     *     {@link java.math.BigInteger }
     *     
     */
    public BigInteger getNumber() {
        return number;
    }

    /**
     * Sets the value of the number property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.math.BigInteger }
     *     
     */
    public void setNumber(BigInteger value) {
        this.number = value;
    }

    /**
     * Gets the value of the color property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getColor() {
        return color;
    }

    /**
     * Sets the value of the color property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setColor(String value) {
        this.color = value;
    }

    /**
     * Gets the value of the fontFamily property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFontFamily() {
        return fontFamily;
    }

    /**
     * Sets the value of the fontFamily property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFontFamily(String value) {
        this.fontFamily = value;
    }

    /**
     * Gets the value of the fontStyle property.
     * 
     * @return
     *     possible object is
     *     {@link FontStyle }
     *     
     */
    public FontStyle getFontStyle() {
        return fontStyle;
    }

    /**
     * Sets the value of the fontStyle property.
     * 
     * @param value
     *     allowed object is
     *     {@link FontStyle }
     *     
     */
    public void setFontStyle(FontStyle value) {
        this.fontStyle = value;
    }

    /**
     * Gets the value of the fontSize property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFontSize() {
        return fontSize;
    }

    /**
     * Sets the value of the fontSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFontSize(String value) {
        this.fontSize = value;
    }

    /**
     * Gets the value of the fontWeight property.
     * 
     * @return
     *     possible object is
     *     {@link FontWeight }
     *     
     */
    public FontWeight getFontWeight() {
        return fontWeight;
    }

    /**
     * Sets the value of the fontWeight property.
     * 
     * @param value
     *     allowed object is
     *     {@link FontWeight }
     *     
     */
    public void setFontWeight(FontWeight value) {
        this.fontWeight = value;
    }

}
